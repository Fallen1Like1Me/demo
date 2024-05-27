package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.PapsortDto;
import com.example.demo.dto.PersonResponseDto;
import com.example.demo.mappers.CarMapper;
import com.example.demo.mappers.PersonMapper;
import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.websocket.server.PathParam;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController

public class PersonController {

    private final PersonMapper personMapper;
    private final PersonService personService;
    @PostMapping("/save")
    public PersonResponseDto savePerson(@RequestBody Person person){
        Person founded = personService.savePerson(person);
        return personMapper.entityToDto(founded);
    }

    @GetMapping("/all")
    public List<PersonResponseDto> getAllPerson(){
    var personList= personService.getAllPerson();
    return personMapper.mapToDto(personList);
    }

    @GetMapping("/getById/{id}")
    public PersonResponseDto getById(@PathVariable Long id){
        var test1 =personService.getById(id);
        var test = personMapper.entityToDto(test1);
        return test;
    }

    @DeleteMapping("/deleteById")
    public void deletById(@PathParam("id") Long id){
        personService.deleteById(id);
    }

    @PatchMapping("/changeName")
    public Person changeName(@RequestBody Person person){
        return personService.changeName(person);
    }

    @GetMapping("/getAllByHouseList")
    public List<PersonResponseDto> getAllByHouseList(List<House> houseList){
       return personMapper.mapToDto(personService.getAllByHouseList(houseList));
    }

}

