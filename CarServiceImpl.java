package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Person;
import com.example.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Lazy
    @Autowired
    private PersonService personService;
    private MocPassportServiceImpl mocPassportService;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        List<Car> carList = carRepository.findAll();
        return carList;
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }


    public void deletByModel(String model) {
        carRepository.deleteByModel(model);
    }

    public List<Car> findByPersonId(Long personId) {
        return carRepository.findAllByPersonId(personId);
    }

    @Transactional
    public Car postPersonToCar(Long personId, Long carId) {
        Person person = personService.getById(personId);
        Car car = getCarById(carId);
        person.getCars().add(car);
        car.setPerson(person);
        personService.updatePerson(person);
        return carRepository.save(car);
    }

    public Integer math(Integer a, Integer b) {
        return a * b * mocPassportService.test();
    }
}

