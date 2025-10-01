package com.sistemaBD.repository;

import com.sistemaBD.domain.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, String> {
    // Método de ejemplo: Buscar vehículos por marca y modelo
    List<Vehicles> findByMarcaAndModelo(String marca, String modelo);

}
