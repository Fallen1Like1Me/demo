package com.example.demo.controller;

import com.example.demo.dto.HouseDto;
import com.example.demo.mappers.HouseMapper;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.service.HouseServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HouseController {
    private final HouseServiceImpl houseServiceImpl;
    private final HouseMapper houseMapper;

    @PostMapping("/saveHouse")
    public HouseDto saveHouse(@RequestBody House house){
        House founded = houseServiceImpl.saveHouse(house);
        return houseMapper.mapToDto(founded);
    }

    @GetMapping("/getAllHouses")
    public List<HouseDto> getAllHouses(){
        var founded = houseServiceImpl.getAllHouses();
        return houseMapper.mapListDto(founded);
    }

    @GetMapping("/getHousesByPerson")
    public List<HouseDto> getByPerson(Person person){
        var houses = houseServiceImpl.getHousesByPerson(person);
        return houseMapper.mapListDto(houses);
    }

    @PatchMapping("/house/person/add")
    public HouseDto setHouseAndPerson(@PathParam("houseId") Long houseId, @PathParam("personId") Long personId){
        return houseMapper.mapToDto(houseServiceImpl.postPerson(houseId, personId));
    }
}
