package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {
    private long id;
    private String street;
    private PersonDto personDto;
    private List<PersonDto> personDtoList;
}
