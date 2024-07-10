package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.mappers.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.service.CarServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    public final CarServiceImpl carServiceImpl;
    @PostMapping("/saveCar")
    public CarDto saveCar(@RequestBody CarDto car){
        Car founded = carServiceImpl.saveCar(CarMapper.MAPPER.carDtoToEntity(car));
        return CarMapper.MAPPER.carEntityToDto(founded);
    }

    @GetMapping("/getAllCars")
    public List<CarDto> getAllCars(){
        var carList = carServiceImpl.getAllCars();
        return CarMapper.MAPPER.listToDto(carList);
    }

    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id){
        carServiceImpl.deleteCarById(id);
    }

    @DeleteMapping("/deleteByModel/{model}")
    public void deleteByModel(@PathVariable String model){
       carServiceImpl.deletByModel(model);
    }

    @GetMapping("/getCarByPersonId")
    public List<CarDto> getByPersonId(Long id){
        var carList = carServiceImpl.findByPersonId(id);
        return CarMapper.MAPPER.listToDto(carList);
    }


    @PatchMapping("/car/person/add")
    public CarDto setCarAndPerson(@PathParam("carId") Long carId, @PathParam("personId") Long personId){
        return CarMapper.MAPPER.carEntityToDto(carServiceImpl.postPersonToCar(personId, carId));
    }
}
