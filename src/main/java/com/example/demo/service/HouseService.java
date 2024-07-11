package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HouseService {
    public House saveHouse(House house);

    public List<House> getAllHouses();

    public List<House> getHousesByPerson(Person person);

    public House getHouseById(Long id);

    public List<House> getHousesByStreet(String street);

    public House postPerson(Long personId, Long houseId);
}
