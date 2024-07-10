package com.example.demo.mappers;

import com.example.demo.dto.PapsortDto;
import com.example.demo.model.Pasport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PasportMapper {
    PapsortDto pasportEntityToDto(Pasport pasport);

    Pasport pasportDtoToEntity(PapsortDto papsortDto);

    List<Pasport> mapToEntity(List<PapsortDto> dtoList);

    List<PapsortDto> mapToDto(List<Pasport> pasportList);
}
