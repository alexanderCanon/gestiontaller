package com.sistemaBD.service;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicRequestDTO;
import com.sistemaBD.dto.MechanicResponseDTO;
import com.sistemaBD.repository.MechanicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService implements IMechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private MechanicMapper mechanicMapper;

    @Override
    public List<MechanicResponseDTO> getAllMechanics() {
        List<Mechanic> mechanics = mechanicRepository.findAll();
        return mechanicMapper.toResponseDTOList(mechanics);
    }

    @Override
    public MechanicResponseDTO getMechanicById(String id) {
        Mechanic mechanic = findMechanicByIdOrThrow(id);
        return mechanicMapper.toResponseDTO(mechanic);
    }

    @Override
    public MechanicResponseDTO createMechanic(MechanicRequestDTO requestDTO) {
        Mechanic mechanic = mechanicMapper.toEntity(requestDTO);
        Mechanic savedMechanic = mechanicRepository.save(mechanic);
        return mechanicMapper.toResponseDTO(savedMechanic);
    }

    @Override
    public MechanicResponseDTO updateMechanic(String id, MechanicRequestDTO requestDTO) {
        Mechanic existingMechanic = findMechanicByIdOrThrow(id);

        mechanicMapper.updateEntityFromDto(requestDTO, existingMechanic);

        Mechanic updatedMechanic = mechanicRepository.save(existingMechanic);
        return mechanicMapper.toResponseDTO(updatedMechanic);
    }

    @Override
    public void deleteMechanic(String id) {
        if (!mechanicRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Mecánico no encontrado con el ID: " + id);
        }
        mechanicRepository.deleteById(id);
    }

    @Override
    public List<MechanicResponseDTO> getMechanicsByApellido(String apellido) {
        List<Mechanic> mechanics = mechanicRepository.findByApellido(apellido);
        return mechanicMapper.toResponseDTOList(mechanics);
    }

    private Mechanic findMechanicByIdOrThrow(String id) {
        return mechanicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mecánico no encontrado con el ID: " + id));
    }
}