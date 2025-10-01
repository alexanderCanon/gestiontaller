package com.sistemaBD.repository;

import com.sistemaBD.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService extends JpaRepository<Customer, Integer> {

    // Método de ejemplo: Buscar clientes por apellido
    List<Customer> findByApellido(String apellido);
}
