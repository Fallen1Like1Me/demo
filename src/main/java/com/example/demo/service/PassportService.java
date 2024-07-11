package com.example.demo.service;

import com.example.demo.model.Pasport;

import java.util.List;

public interface PassportService {

    Pasport savePasport(Pasport pasport);

    Pasport getById(Long id);


    List<Pasport> getAllPassports();


    void deleteById(Long id);


    List<Pasport> getPasportsByLastnameFirstLetter(String lastnameFirstLetter);
}
