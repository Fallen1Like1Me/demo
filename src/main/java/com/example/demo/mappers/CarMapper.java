package com.example.demo.mappers;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);
    CarDto carEntityToDto(Car car);
    Car carDtoToEntity(CarDto carDto);
    List<Car> listToCar(List<CarDto> list);
    List<CarDto> listToDto(List<Car> carList);
}
