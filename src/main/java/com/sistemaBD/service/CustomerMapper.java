package com.sistemaBD.service;

import com.sistemaBD.domain.Customer;
import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "nombre", source = "nombreCompleto", qualifiedByName = "toNombre"),
            @Mapping(target = "apellido", source = "nombreCompleto", qualifiedByName = "toApellido"),
            @Mapping(target = "clienteId", ignore = true)
    })
    Customer toEntity(CustomerRequestDTO dto);

    @Mappings({
            @Mapping(target = "nombreCompleto", expression = "java(entity.getNombre() + \" \" + entity.getApellido())")
    })
    CustomerResponseDTO toResponseDTO(Customer entity);

    List<CustomerResponseDTO> toResponseDTOList(List<Customer> entities);

    @Named("toNombre")
    default String extractNombre(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.isBlank()) return "";
        String[] parts = nombreCompleto.trim().split("\\s+", 2);
        return parts.length > 0 ? parts[0] : "";
    }

    @Named("toApellido")
    default String extractApellido(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.isBlank()) return "";
        String[] parts = nombreCompleto.trim().split("\\s+", 2);
        return parts.length > 1 ? parts[1] : "";
    }
}