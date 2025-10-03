package com.sistemaBD.service.impl;

import com.sistemaBD.domain.Vehicles;
import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;
import com.sistemaBD.mapper.VehicleMapper;
import com.sistemaBD.repository.VehiclesRepository;
import com.sistemaBD.service.VehiclesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiclesServiceImpl implements VehiclesService {

    private final VehiclesRepository vehiclesRepository;
    private final VehicleMapper vehicleMapper;

    // Inyección de dependencias por constructor (principio SOLID)
    public VehiclesServiceImpl(VehiclesRepository vehiclesRepository, VehicleMapper vehicleMapper) {
        this.vehiclesRepository = vehiclesRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiclesResponseDTO> findAll() {
        List<Vehicles> vehicles = vehiclesRepository.findAll();
        return vehicleMapper.toResponseDTOList(vehicles);
    }

    @Override
    @Transactional(readOnly = true)
    public VehiclesResponseDTO findById(String placa) {
        Vehicles vehicle = vehiclesRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con la placa: " + placa));
        return vehicleMapper.toResponseDTO(vehicle);
    }

    @Override
    @Transactional
    public VehiclesResponseDTO save(VehiclesRequestDTO vehicleDTO) {
        // Opcional: Validar si la placa ya existe antes de intentar guardar
        if (vehiclesRepository.existsById(vehicleDTO.getPlaca())) {
            throw new IllegalArgumentException("Ya existe un vehículo con la placa: " + vehicleDTO.getPlaca());
        }
        Vehicles vehicle = vehicleMapper.toEntity(vehicleDTO);
        Vehicles savedVehicle = vehiclesRepository.save(vehicle);
        return vehicleMapper.toResponseDTO(savedVehicle);
    }

    @Override
    @Transactional
    public VehiclesResponseDTO update(String placa, VehiclesRequestDTO vehicleDTO) {
        Vehicles existingVehicle = vehiclesRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con la placa: " + placa));

        // Usamos el mapper para actualizar la entidad existente
        vehicleMapper.updateEntityFromDto(vehicleDTO, existingVehicle);

        Vehicles updatedVehicle = vehiclesRepository.save(existingVehicle);
        return vehicleMapper.toResponseDTO(updatedVehicle);
    }

    @Override
    @Transactional
    public void deleteById(String placa) {
        if (!vehiclesRepository.existsById(placa)) {
            throw new EntityNotFoundException("Vehículo no encontrado con la placa: " + placa);
        }
        vehiclesRepository.deleteById(placa);
    }
}