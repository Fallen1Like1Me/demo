package com.example.demo.service;

import com.example.demo.exception.WrongRequestDateException;
import com.example.demo.model.Pasport;
import com.example.demo.model.Person;
import com.example.demo.repository.PasportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Primary
public class PassportServiceImpl implements PassportService {
    @Lazy
    @Autowired
    private PersonService personServiceImpl;
    private final PasportRepository pasportRepository;
    private final Random random = new Random();

    @Override
    public Pasport savePasport(Pasport pasport) {
        pasport.setSeries(random.nextInt(100000, 999999));
        return pasportRepository.save(pasport);
    }

    @Override
    public Pasport getById(Long id) {
        return pasportRepository.findById(id).orElseThrow(() -> new RuntimeException("Паспорт не найден"));
    }

    @Override
    public List<Pasport> getAllPassports() {
        List<Pasport> pasportList = pasportRepository.findAll();
        return pasportList;
    }

    @Override
    public void deleteById(Long id) {
        pasportRepository.deleteById(id);
    }

    @Override
    public List<Pasport> getPasportsByLastnameFirstLetter(String lastnameFirstLetter) {
        if (lastnameFirstLetter.length() != 1) {
            throw new WrongRequestDateException("вы ввели больше одной буквы");
        }
        return personServiceImpl.getAllByFirstLetterOfLastname(lastnameFirstLetter).stream().map(Person::getPasport).collect(Collectors.toList());

    }
}
