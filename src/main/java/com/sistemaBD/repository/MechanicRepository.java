package com.sistemaBD.repository;

import com.sistemaBD.domain.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic,String> {

    // Método de ejemplo: Buscar mecánicos por apellido
    List<Mechanic> findByApellido(String apellido);
}
