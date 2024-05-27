package com.example.demo.service;

import com.example.demo.model.Pasport;
import com.example.demo.repository.PasportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PassportService {
    private final PasportRepository pasportRepository;

    public Pasport savePasport (Pasport pasport){
        return pasportRepository.save(pasport);
    }

    public Pasport getById(Long id){
        return pasportRepository.findById(id).orElseThrow(() -> new RuntimeException("Паспорт не найден"));
    }

    public List<Pasport> getAllPassports(){
        List<Pasport> pasportList = pasportRepository.findAll();
        return pasportList;
    }

    public void deleteById(Long id){
        pasportRepository.deleteById(id);
    }
}
