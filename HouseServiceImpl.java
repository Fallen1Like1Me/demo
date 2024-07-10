package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService{
    private final HouseRepository houseRepository;
    @Lazy
    @Autowired
    private PersonService personServiceImpl;


    public House saveHouse(House house){
        return houseRepository.save(house);
    }

    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }

    public List<House> getHousesByPerson(Person person){

        return houseRepository.findAllByPersonList(List.of(person));
    }

    public House getHouseById(Long id){
        return houseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public List<House> getHousesByStreet(String street){
        return houseRepository.getAllByHouseStreet(street);
    }

    @Transactional
    public House postPerson(Long personId, Long houseId){
        Person person = personServiceImpl.getById(personId);
        House house = getHouseById(houseId);
        person.getHouseList().add(house);
        house.getPersonList().add(person);
        personServiceImpl.updatePerson(person);
        return houseRepository.save(house);
    }
}
