package com.sistemaBD.service;

import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

    List<CustomerResponseDTO> findAll();

    Optional<CustomerResponseDTO> findById(Integer id);

    CustomerResponseDTO update(Integer id, CustomerRequestDTO customerRequestDTO);

    void deleteById(Integer id);

    List<CustomerResponseDTO> findByApellido(String apellido);
}