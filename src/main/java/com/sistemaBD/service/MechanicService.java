package com.sistemaBD.service;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicResponseDTO;
// El mapper ahora está en el mismo paquete
import com.sistemaBD.repository.MechanicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class MechanicService implements IMechanicService {

    private final MechanicRepository mechanicRepository;
    private final MechanicMapper mechanicMapper;

    @Override
    public MechanicResponseDTO save(Mechanic mechanic) {
        Mechanic savedMechanic = mechanicRepository.save(mechanic);
        return mechanicMapper.toResponseDTO(savedMechanic);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MechanicResponseDTO> findAll() {
        List<Mechanic> mechanics = mechanicRepository.findAll();
        return mechanicMapper.toResponseDTOList(mechanics);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MechanicResponseDTO> findById(String id) {
        return mechanicRepository.findById(id)
                .map(mechanicMapper::toResponseDTO);
    }

    @Override
    public MechanicResponseDTO update(String id, Mechanic mechanicDetails) {
        Mechanic existingMechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mecánico no encontrado con id: " + id));

        existingMechanic.setNombre(mechanicDetails.getNombre());
        existingMechanic.setApellido(mechanicDetails.getApellido());
        existingMechanic.setTelefono(mechanicDetails.getTelefono());

        Mechanic updatedMechanic = mechanicRepository.save(existingMechanic);
        return mechanicMapper.toResponseDTO(updatedMechanic);
    }

    @Override
    public void deleteById(String id) {
        if (!mechanicRepository.existsById(id)) {
            throw new EntityNotFoundException("Mecánico no encontrado con id: " + id);
        }
        mechanicRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MechanicResponseDTO> findByApellido(String apellido) {
        List<Mechanic> mechanics = mechanicRepository.findByApellido(apellido);
        return mechanicMapper.toResponseDTOList(mechanics);
    }
}
