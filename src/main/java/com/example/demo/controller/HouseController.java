package com.example.demo.controller;

import com.example.demo.dto.HouseDto;
import com.example.demo.mappers.HouseMapper;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HouseController {
    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @PostMapping("/saveHouse")
    public HouseDto saveHouse(@RequestBody House house){
        House founded = houseService.saveHouse(house);
        return houseMapper.mapToDto(founded);
    }

    @GetMapping("/getAllHouses")
    public List<HouseDto> getAllHouses(){
        var founded = houseService.getAllHouses();
        return houseMapper.mapListDto(founded);
    }

    @GetMapping("/getHousesByPerson")
    public List<HouseDto> getByPerson(Person person){
        var houses = houseService.getHousesByPerson(person);
        return houseMapper.mapListDto(houses);
    }
}
