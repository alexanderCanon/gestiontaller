package com.sistemaBD.controller;

import com.sistemaBD.dto.CustomerRequestDTO;
import com.sistemaBD.dto.CustomerResponseDTO;
import com.sistemaBD.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes") 
public class CustomerController {

    @Autowired // Inyección de dependencia por campo (Field Injection)
    private ICustomerService customerService;

    // Endpoint para CREAR un nuevo cliente
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        CustomerResponseDTO newCustomer = customerService.save(requestDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // Endpoint para OBTENER TODOS los clientes
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    // Endpoint para OBTENER UN cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Integer id) {
        // Usa Optional para obtener el cliente, mapeando a OK o Not Found.
        Optional<CustomerResponseDTO> customer = customerService.findById(id);

        return customer
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para ACTUALIZAR un cliente
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable Integer id,
            @Valid @RequestBody CustomerRequestDTO requestDTO) {

        // Nota: Se asume que el servicio lanza una excepción manejable o retorna algo si el ID no existe.
        CustomerResponseDTO updatedCustomer = customerService.update(id, requestDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    // Endpoint para ELIMINAR un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna un código 204 No Content
    }

    // Endpoint para OBTENER clientes por apellido
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomersByApellido(@PathVariable String apellido) {
        List<CustomerResponseDTO> customers = customerService.findByApellido(apellido);

        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }
}
