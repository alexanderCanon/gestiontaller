package com.sistemaBD.repository;

import com.sistemaBD.domain.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Integer> {

    // Example method: Buscar servicios por tipo
    List<ServiceEntity> findByType(String type);


}