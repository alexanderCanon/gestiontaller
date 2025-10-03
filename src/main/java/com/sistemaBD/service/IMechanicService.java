package com.sistemaBD.service;

import com.sistemaBD.dto.MechanicResponseDTO;
import com.sistemaBD.domain.Mechanic;

import java.util.List;
import java.util.Optional;

public interface IMechanicService {

    MechanicResponseDTO save(Mechanic mechanic);

    List<MechanicResponseDTO> findAll();

    Optional<MechanicResponseDTO> findById(String id);

    MechanicResponseDTO update(String id, Mechanic mechanicDetails);

    void deleteById(String id);

    List<MechanicResponseDTO> findByApellido(String apellido);
}