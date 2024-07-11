package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

import java.util.List;

public interface CarService {

     Car saveCar (Car car);

     List<Car> getAllCars();

     void deleteCarById(Long id);

     void deletByModel(String model);

     List<Car> findByPersonId(Long personId);
}
