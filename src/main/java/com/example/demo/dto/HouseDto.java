package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {
    private long id;
    private String street;
    private PersonResponseDto personResponseDto;
    private List<PersonResponseDto> personResponseDtoList;
}
