package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.House;
import com.example.demo.model.Pasport;
import com.example.demo.model.Person;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface PersonService {
    public Person savePerson(Person person);

     Person updatePerson(Person person);

    public List<Person> getAllPerson();

    public Person getById(Long id);

    public Person changeName(Person person);

    public void deleteById(Long id);


    public List<Person> getAllByHouseList(List<House> houseList);
    public List<Person> getAllByFirstLetterOfLastname(String letterOfLastname);

    public List<Person> getAllByHouseStreet(String street);

}
