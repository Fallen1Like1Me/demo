package com.example.demo.mappers;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.PersonResponseDto;
import com.example.demo.model.Car;
import com.example.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "cars",source = "person", qualifiedByName = "mapToCarDto")
    @Mapping(target = "createDate", source = "createDate")
    PersonResponseDto entityToDto(Person person);
    @Named("mapToCarDto")
    default List<CarDto> mapToCarDto(Person person){
       return CarMapper.MAPPER.listToDto(person.getCars());
    }
    Person dtoToEntity(PersonResponseDto personResponseDto);
    List<Person> mapToEntity(List<PersonResponseDto> personResponseDtos);
    List<PersonResponseDto> mapToDto(List<Person> personList);
}
