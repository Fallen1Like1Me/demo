package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> getAllByHouseList(List<House> houseList);
//todo изменить метод сверху добавить запрос
    @Query(value = "SELECT * FROM Person where lastname ilike ?1 and sex = 'MALE'", nativeQuery = true)
    List<Person> getPersonMaleByFirstLetter(String firstLetter);
}
