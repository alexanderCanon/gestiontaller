package com.sistemaBD.service;

import com.sistemaBD.domain.Services;
import com.sistemaBD.dto.ServicesRequestDTO;
import com.sistemaBD.dto.ServicesResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper para la conversión entre la entidad Services y sus DTOs.
 */
@Mapper(componentModel = "spring") // componentModel = "spring" lo hace un Bean de Spring
public interface ServiceMapper {

    // Instancia para poder usarlo si no se inyecta con Spring
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    // Mapeos
    ServicesResponseDTO toResponseDTO(Services service);

    Services toEntity(ServicesRequestDTO requestDTO);

    List<ServicesResponseDTO> toResponseDTOList(List<Services> services);

    /**
     * Actualiza una entidad 'Services' existente a partir de un DTO de solicitud.
     * @param requestDTO El DTO con los datos de origen.
     * @param service La entidad de destino que será actualizada.
     */
    void updateEntityFromDto(ServicesRequestDTO requestDTO, @MappingTarget Services service);
}
