package com.sistemaBD.service;

import com.sistemaBD.dto.MechanicRequestDTO;
import com.sistemaBD.dto.MechanicResponseDTO;

import java.util.List;

public interface IMechanicService {

    List<MechanicResponseDTO> getAllMechanics();

    MechanicResponseDTO getMechanicById(String id);

    MechanicResponseDTO createMechanic(MechanicRequestDTO requestDTO);

    MechanicResponseDTO updateMechanic(String id, MechanicRequestDTO requestDTO);

    void deleteMechanic(String id);

    List<MechanicResponseDTO> getMechanicsByApellido(String apellido);
}
