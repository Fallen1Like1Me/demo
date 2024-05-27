package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class House {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @JoinTable(name = "ref_person_houses",
    joinColumns = @JoinColumn(name = "house_id"),
    inverseJoinColumns = @JoinColumn(name = "person_id"))
    @ManyToMany
    private List<Person> personList;
    private String street;

}
