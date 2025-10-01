package com.sistemaBD.repository;

import com.sistemaBD.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    // Example method: Buscar servicios por tipo
    List<Services> findByTipo(String tipo);
}
