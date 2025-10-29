package com.sistemaBD.repository;

import com.sistemaBD.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    // Método de ejemplo: Buscar vehículos por marca y modelo
    List<Vehicle> findByBrandAndModel(String brand, String model);

}