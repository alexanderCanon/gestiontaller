package com.sistemaBD.service;

import com.sistemaBD.domain.Customer;
import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerRequestDTO dto);

    CustomerResponseDTO toResponseDTO(Customer entity);

    List<CustomerResponseDTO> toResponseDTOList(List<Customer> entities);

    void updateEntityFromDto(CustomerRequestDTO requestDTO, @MappingTarget Customer entity);
}
