package com.sistemaBD.service;

import com.sistemaBD.domain.Vehicles;
import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    Vehicles toEntity(VehiclesRequestDTO requestDTO);

    VehiclesResponseDTO toResponseDTO(Vehicles vehicle);

    List<VehiclesResponseDTO> toResponseDTOList(List<Vehicles> vehicles);

    @Mapping(target = "placa", ignore = true)
    void updateEntityFromDto(VehiclesRequestDTO requestDTO, @MappingTarget Vehicles vehicle);
}
