package com.sistemaBD.repository;

import com.sistemaBD.domain.Oil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OilRepository extends JpaRepository<Oil, Integer> {
    // Método de ejemplo: Buscar aceites por tipo
    List<Oil> findByType(String type);

}