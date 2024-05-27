package com.example.demo.mappers;

import com.example.demo.dto.HouseDto;
import com.example.demo.model.House;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseDto mapToDto(House house);
    House mapToEntity(HouseDto houseDto);
    List<HouseDto> mapListDto(List<House> houseList);
    List<House> mapListEntity(List<HouseDto> houseDtoList);
}
