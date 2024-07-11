package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.House;
import com.example.demo.model.Pasport;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PassportService passportService;
    private final CarService carServiceImpl;
    private final HouseService houseServiceImpl;

    

@Transactional()
@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public Person savePerson(Person person){
        Pasport pasp = passportService.savePasport(new Pasport());
        Person chel = personRepository.save(person);
        chel.setPasport(pasp);
        pasp.setPerson(chel);
        chel.setCreateDate(LocalDateTime.now());
        return chel;
    }

    public Person updatePerson(Person person){
    return personRepository.save(person);
    }

    public List<Person> getAllPerson(){
        List<Person> listPerson = personRepository.findAll();
        listPerson.forEach(person -> person.getCars());
        listPerson.forEach(person -> person.getPasport());
        listPerson.forEach(person -> person.getCreateDate());
        return listPerson;
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
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
        carServiceImpl.deleteCarById(id);
    }

    public List<Person> getAllByHouseList(List<House> houseList){
    return personRepository.getAllByHouseList(houseList);
    }
    public List<Person> getAllByFirstLetterOfLastname(String letterOfLastname){
    return personRepository.getPersonMaleByFirstLetter(letterOfLastname + "%");
    }

    public List<Person> getAllByHouseStreet(String street){
        List<Person> personList = houseServiceImpl.getHousesByStreet(street).stream()
                .flatMap(house -> house.getPersonList().stream())
                .collect(Collectors.toList());
        return personList;
    }


}
