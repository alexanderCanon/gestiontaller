package com.sistemaBD.controller;

import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import com.sistemaBD.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        CustomerResponseDTO newCustomer = customerService.save(requestDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Integer id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomersByApellido(@PathVariable String apellido) {
        List<CustomerResponseDTO> customers = customerService.findByApellido(apellido);
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable Integer id,
            @Valid @RequestBody CustomerRequestDTO requestDTO) {

        try {
            CustomerResponseDTO updatedCustomer = customerService.update(id, requestDTO);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            // Manejar EntityNotFoundException si se implementa un @ControllerAdvice
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}