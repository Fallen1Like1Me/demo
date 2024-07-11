package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.mappers.PersonMapper;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.service.PersonServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class PersonController {

    private final PersonMapper personMapper;
    private final PersonServiceImpl personServiceImpl;
    @PostMapping("/save")
    public PersonDto savePerson(@RequestBody PersonDto personDto){
        Person founded = personServiceImpl.savePerson(personMapper.dtoToEntity(personDto));
        return personMapper.entityToDto(founded);
    }

    @GetMapping("/all")
    public List<PersonDto> getAllPerson(){
    var personList= personServiceImpl.getAllPerson();
    return personMapper.mapToDto(personList);
    }

    @GetMapping("/getById/{id}")
    public PersonDto getById(@PathVariable Long id){
        var test1 = personServiceImpl.getById(id);
        var test = personMapper.entityToDto(test1);
        return test;
    }

    @DeleteMapping("/deleteById")
    public void deletById(@PathParam("id") Long id){
        personServiceImpl.deleteById(id);
    }

    @PatchMapping("/changeName")
    public Person changeName(@RequestBody Person person){
        return personServiceImpl.changeName(person);
    }

    @GetMapping("/getAllByHouseList")
    public List<PersonDto> getAllByHouseList(List<House> houseList){
       return personMapper.mapToDto(personServiceImpl.getAllByHouseList(houseList));
    }

    @GetMapping("/getAllPersonByHouseList")
    public List<PersonDto> getAllPersonByHouseListStreet(@PathParam("street") String street){
        return personMapper.mapToDto(personServiceImpl.getAllByHouseStreet(street));
    }
}

