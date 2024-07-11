package com.example.demo.model;

import com.example.demo.enums.SexType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private String lastname;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", updatable = false)
    private SexType sex;
    @OneToMany(mappedBy = "person")
    private List<Car> cars;
    @OneToOne
    private Pasport pasport;
    private LocalDateTime createDate;
    @ManyToMany(mappedBy = "personList")
    private List<House> houseList;
}
