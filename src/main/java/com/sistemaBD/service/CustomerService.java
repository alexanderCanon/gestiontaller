package com.sistemaBD.service;

import com.sistemaBD.domain.Customer;
import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
// DELETE THIS LINE: import com.sistemaBD.repository.ICustomerService as CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {

    // CORRECTED LINE: Use the full class path for the repository here.
    private final com.sistemaBD.repository.CustomerService customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.toEntity(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponseDTO(savedCustomer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toResponseDTOList(customers);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerResponseDTO> findById(Integer id) {
        return customerRepository.findById(id)
                .map(customerMapper::toResponseDTO);
    }

    @Override
    public CustomerResponseDTO update(Integer id, CustomerRequestDTO customerRequestDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        Customer updatedCustomer = customerMapper.toEntity(customerRequestDTO);

        updatedCustomer.setClienteId(existingCustomer.getClienteId());

        Customer savedCustomer = customerRepository.save(updatedCustomer);

        return customerMapper.toResponseDTO(savedCustomer);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findByApellido(String apellido) {
        List<Customer> customers = customerRepository.findByApellido(apellido);
        return customerMapper.toResponseDTOList(customers);
    }
}