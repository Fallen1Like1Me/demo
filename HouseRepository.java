package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    public List<House> findAllByPersonList(List<Person> personList);


    @Query( value = "SELECT h FROM House h WHERE upper(h.street) = upper(:street)", nativeQuery = false)
    List<House> getAllByHouseStreet(@Param("street") String street);
}
