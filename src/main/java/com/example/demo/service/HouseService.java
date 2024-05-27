package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRepository houseRepository;


    public House saveHouse(House house){
       return houseRepository.save(house);
    }

    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }

    public List<House> getHousesByPerson(Person person){
        return houseRepository.findAllByPersonList(List.of(person));
    }
}
