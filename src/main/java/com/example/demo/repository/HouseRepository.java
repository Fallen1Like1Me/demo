package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    public List<House> findAllByPersonList(List<Person> personList);


    @Query( value = "SELECT * FROM house WHERE upper(street) = upper(?)", nativeQuery = true)
    List<House> getAllByHouseStreet(String street);
}
