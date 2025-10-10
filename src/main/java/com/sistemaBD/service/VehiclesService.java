package com.sistemaBD.service;

import com.sistemaBD.domain.Vehicles;
import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;
import com.sistemaBD.repository.VehiclesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService implements IVehiclesService {

    private final VehiclesRepository vehiclesRepository;
    private final VehicleMapper vehicleMapper;

    public VehiclesService(VehiclesRepository vehiclesRepository, VehicleMapper vehicleMapper) {
        this.vehiclesRepository = vehiclesRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehiclesResponseDTO> getAllVehicles() {
        List<Vehicles> vehicles = vehiclesRepository.findAll();
        return vehicleMapper.toResponseDTOList(vehicles);
    }

    @Override
    public VehiclesResponseDTO getVehicleById(String placa) {
        Vehicles vehicle = findVehicleByIdOrThrow(placa);
        return vehicleMapper.toResponseDTO(vehicle);
    }

    @Override
    public VehiclesResponseDTO createVehicle(VehiclesRequestDTO vehicleDTO) {
        if (vehiclesRepository.existsById(vehicleDTO.getPlaca())) {
            throw new IllegalArgumentException("Ya existe un vehículo con la placa: " + vehicleDTO.getPlaca());
        }
        Vehicles vehicle = vehicleMapper.toEntity(vehicleDTO);
        Vehicles savedVehicle = vehiclesRepository.save(vehicle);
        return vehicleMapper.toResponseDTO(savedVehicle);
    }

    @Override
    public VehiclesResponseDTO updateVehicle(String placa, VehiclesRequestDTO vehicleDTO) {
        Vehicles existingVehicle = findVehicleByIdOrThrow(placa);

        vehicleMapper.updateEntityFromDto(vehicleDTO, existingVehicle);

        Vehicles updatedVehicle = vehiclesRepository.save(existingVehicle);
        return vehicleMapper.toResponseDTO(updatedVehicle);
    }

    @Override
    public void deleteVehicle(String placa) {
        if (!vehiclesRepository.existsById(placa)) {
            throw new EntityNotFoundException("Vehículo no encontrado con la placa: " + placa);
        }
        vehiclesRepository.deleteById(placa);
    }

    private Vehicles findVehicleByIdOrThrow(String placa) {
        return vehiclesRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con la placa: " + placa));
    }
}
