package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getAllByHouseList(List<House> houseList);
}
