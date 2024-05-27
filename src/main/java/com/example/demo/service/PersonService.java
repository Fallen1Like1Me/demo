package com.example.demo.service;

import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Pasport;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PassportService passportService;
    private final CarService carService;

    

@Transactional()
    public Person savePerson(Person person){
        Pasport pasp = passportService.savePasport(new Pasport());
        Person chel = personRepository.save(person);
        chel.setPasport(pasp);
        pasp.setPerson(chel);
        chel.setCreateDate(LocalDateTime.now());
        return chel;
    }

    public List<Person> getAllPerson(){
        List<Person> listPerson = personRepository.findAll();
        listPerson.forEach(person -> person.getCars());
        listPerson.forEach(person -> person.getPasport());
        listPerson.forEach(person -> person.getCreateDate());
        return listPerson;
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person changeName(Person person) {
        Person oldPerson = personRepository.findById(person.getId()).orElseThrow(() -> new RuntimeException("житель не найден"));
            oldPerson.setName(person.getName());
           return personRepository.save(oldPerson);
    }
@org.springframework.transaction.annotation.Transactional
    public void deleteById(Long id){
        personRepository.deleteById(id);
        passportService.deleteById(id);
        carService.deleteCarById(id);
    }

    public List<Person> getAllByHouseList(List<House> houseList){
    return personRepository.getAllByHouseList(houseList);
    }


}
