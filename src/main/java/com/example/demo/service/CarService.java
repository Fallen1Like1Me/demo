package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public Car saveCar (Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        List<Car> carList = carRepository.findAll();
        return carList;
    }

    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

    public void deletByModel(String model){
        carRepository.deleteByModel(model);
    }

    public List<Car> findByPersonId(Long personId){
       return carRepository.findAllByPersonId(personId);
    }
}
