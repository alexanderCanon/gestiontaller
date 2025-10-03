package com.sistemaBD.mapper;

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

    /**
     * Convierte un DTO de solicitud a una entidad Vehicle.
     * @param requestDTO El DTO de entrada.
     * @return La entidad Vehicle mapeada.
     */
    Vehicles toEntity(VehiclesRequestDTO requestDTO);

    /**
     * Convierte una entidad Vehicle a un DTO de respuesta.
     * @param vehicle La entidad de origen.
     * @return El DTO de respuesta mapeado.
     */
    VehiclesResponseDTO toResponseDTO(Vehicles vehicle);

    /**
     * Convierte una lista de entidades Vehicle a una lista de DTOs de respuesta.
     * @param vehicles La lista de entidades.
     * @return La lista de DTOs de respuesta.
     */
    List<VehiclesResponseDTO> toResponseDTOList(List<Vehicles> vehicles);

    /**
     * Actualiza una entidad existente a partir de un DTO de solicitud.
     * Ignora el campo 'placa' ya que es el identificador y no debe ser modificado.
     * @param requestDTO El DTO con los datos nuevos.
     * @param vehicle La entidad a actualizar (obtenida de la base de datos).
     */
    @Mapping(target = "placa", ignore = true)
    void updateEntityFromDto(VehiclesRequestDTO requestDTO, @MappingTarget Vehicles vehicle);
}