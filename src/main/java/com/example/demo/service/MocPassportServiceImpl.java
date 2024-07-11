package com.example.demo.service;

import com.example.demo.model.Pasport;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("MocPassportServiceImpl")

public class MocPassportServiceImpl implements PassportService {

    @Override
    public Pasport savePasport(Pasport pasport) {
        return null;
    }

    @Override
    public Pasport getById(Long id) {
        return null;
    }

    @Override
    public List<Pasport> getAllPassports() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Pasport> getPasportsByLastnameFirstLetter(String lastnameFirstLetter) {
        return List.of();
    }

    public Integer test(){
        return 1;
    }
}
