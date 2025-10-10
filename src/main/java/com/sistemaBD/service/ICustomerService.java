package com.sistemaBD.service;

import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import java.util.List;

public interface ICustomerService {

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Integer id);

    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO customerRequestDTO);

    void deleteCustomer(Integer id);

    List<CustomerResponseDTO> getCustomersByApellido(String apellido);
}
