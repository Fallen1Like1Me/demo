package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.mappers.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    public final CarService carService;
    @PostMapping("/saveCar")
    public CarDto saveCar(@RequestBody Car car){
        Car founded = carService.saveCar(car);
        return CarMapper.MAPPER.carEntityToDto(founded);
    }

    @GetMapping("/getAllCars")
    public List<CarDto> getAllCars(){
        var carList = carService.getAllCars();
        return CarMapper.MAPPER.listToDto(carList);
    }

    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCarById(id);
    }

    @DeleteMapping("/deleteByModel/{model}")
    public void deleteByModel(@PathVariable String model){
       carService.deletByModel(model);
    }

    @GetMapping("/getCarByPersonId")
    public List<CarDto> getByPersonId(Long id){
        var carList = carService.findByPersonId(id);
        return CarMapper.MAPPER.listToDto(carList);
    }
}
