package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private long id;
    private String name;

    private List<CarDto> cars;

    private PapsortDto pasport;
    private LocalDateTime createDate;
    private HouseDto house;
    private List<HouseDto> houseList;
    private String sex;
}
