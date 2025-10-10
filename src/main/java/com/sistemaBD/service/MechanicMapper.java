package com.sistemaBD.service;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicRequestDTO;
import com.sistemaBD.dto.MechanicResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MechanicMapper {

    MechanicMapper INSTANCE = Mappers.getMapper(MechanicMapper.class);

    MechanicResponseDTO toResponseDTO(Mechanic entity);

    Mechanic toEntity(MechanicRequestDTO dto);

    List<MechanicResponseDTO> toResponseDTOList(List<Mechanic> entities);

    void updateEntityFromDto(MechanicRequestDTO requestDTO, @MappingTarget Mechanic entity);
}
