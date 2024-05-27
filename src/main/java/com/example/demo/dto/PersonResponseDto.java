package com.example.demo.dto;

import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Pasport;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto {
    private long id;
    private String name;

    private List<CarDto> cars;

    private PapsortDto pasport;
    private LocalDateTime createDate;
    private HouseDto house;
    private List<HouseDto> houseList;
}
