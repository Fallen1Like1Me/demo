package com.example.demo.controller;

import com.example.demo.dto.PapsortDto;
import com.example.demo.mappers.PasportMapper;
import com.example.demo.model.Pasport;
import com.example.demo.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PassportController {
    public final PassportService passportService;
    public final PasportMapper pasportMapper;

    @PostMapping("/save/pasport")
    public PapsortDto savePasport(@RequestBody Pasport pasport){
        Pasport founded = passportService.savePasport(pasport);
        return pasportMapper.pasportEntityToDto(founded);
    }

    @GetMapping("/getPassportById/{id}")
    public PapsortDto getById(@PathVariable Long id){
        return pasportMapper.pasportEntityToDto(passportService.getById(id));
    }

    @GetMapping("/getAllPassports")
    public List<PapsortDto> getAllPassports(){
        List<Pasport> pasportList = passportService.getAllPassports();
        return pasportMapper.mapToDto(pasportList);
    }
}
