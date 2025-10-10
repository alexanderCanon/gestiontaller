package com.sistemaBD.service;

import com.sistemaBD.domain.Oil;
import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OilMapper {

    OilMapper INSTANCE = Mappers.getMapper(OilMapper.class);

    /**
     * Convierte un DTO de solicitud a una entidad Oil.
     */
    Oil toEntity(OilRequestDTO requestDTO);

    /**
     * Convierte una entidad Oil a un DTO de respuesta.
     */
    OilResponseDTO toResponseDTO(Oil oil);

    /**
     * Convierte una lista de entidades Oil a una lista de DTOs de respuesta.
     */
    List<OilResponseDTO> toResponseDTOList(List<Oil> oils);

    /**
     * Actualiza una entidad existente a partir de un DTO.
     * Se ignora el 'aceiteId' porque es el identificador y no debe cambiar.
     * @param requestDTO El DTO con los datos para actualizar.
     * @param oil La entidad que será actualizada.
     */
    @Mapping(target = "aceiteId", ignore = true)
    void updateEntityFromDto(OilRequestDTO requestDTO, @MappingTarget Oil oil);
}