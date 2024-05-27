package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
@NamedNativeQuery( name = "findAllByPersonId",
query = "SELECT * FROM cars WHERE person_id = ?",
resultClass = Car.class )
@Data
@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String model;
    @ManyToOne
    private Person person;
}
