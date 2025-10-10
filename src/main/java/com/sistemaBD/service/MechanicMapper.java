package com.sistemaBD.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicResponseDTO;

@Mapper(componentModel = "spring")
public interface MechanicMapper {

    MechanicMapper INSTANCE = Mappers.getMapper(MechanicMapper.class);

    MechanicResponseDTO toResponseDTO(Mechanic entity);

    Mechanic toEntity(MechanicResponseDTO dto);

    List<MechanicResponseDTO> toResponseDTOList(List<Mechanic> entities);
}