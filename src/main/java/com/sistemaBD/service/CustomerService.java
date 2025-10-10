package com.sistemaBD.service;

import com.sistemaBD.domain.Customer;
import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import com.sistemaBD.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toResponseDTOList(customers);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Integer id) {
        Customer customer = findCustomerByIdOrThrow(id);
        return customerMapper.toResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.toEntity(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO customerRequestDTO) {
        Customer existingCustomer = findCustomerByIdOrThrow(id);

        customerMapper.updateEntityFromDto(customerRequestDTO, existingCustomer);

        Customer updatedCustomer = customerRepository.save(existingCustomer);

        return customerMapper.toResponseDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Cliente no encontrado con el ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerResponseDTO> getCustomersByApellido(String apellido) {
        List<Customer> customers = customerRepository.findByApellido(apellido);
        return customerMapper.toResponseDTOList(customers);
    }

    private Customer findCustomerByIdOrThrow(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
    }
}
