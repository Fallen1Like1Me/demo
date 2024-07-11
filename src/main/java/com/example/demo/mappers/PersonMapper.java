package com.example.demo.mappers;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.enums.SexType;
import com.example.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "cars",source = "person", qualifiedByName = "mapToCarDto")
    @Mapping(target = "createDate", source = "createDate")
    PersonDto entityToDto(Person person);

    @Named("mapToCarDto")
    default List<CarDto> mapToCarDto(Person person){
        return CarMapper.MAPPER.listToDto(person.getCars());
    }
    @Mapping(target = "sex", source = "personDto",qualifiedByName = "getSex")
    Person dtoToEntity(PersonDto personDto);

    List<Person> mapToEntity(List<PersonDto> personDtos);

    List<PersonDto> mapToDto(List<Person> personList);
    @Named("getSex")
    default SexType getSex(PersonDto personDto){
        if(personDto.getSex().equalsIgnoreCase("MALE")){
            return SexType.MALE;
        }
        if (personDto.getSex().equalsIgnoreCase("female")){
            return SexType.FEMALE;
        }
        else throw new RuntimeException();
    }
}
