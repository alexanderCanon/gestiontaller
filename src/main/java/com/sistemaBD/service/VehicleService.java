package com.sistemaBD.service;

import com.sistemaBD.domain.Vehicle;
import com.sistemaBD.dto.request.VehicleRequest;
import com.sistemaBD.dto.response.VehicleResponse;
import com.sistemaBD.repository.VehicleRepository;
import com.sistemaBD.service.iservice.IVehicleService;
import com.sistemaBD.service.mapper.VehicleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleResponse> findAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse findById(String plate) {
        return vehicleRepository.findById(plate)
                .map(vehicleMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    public VehicleResponse save(VehicleRequest request) {
        Vehicle vehicle = vehicleMapper.toEntity(request);
        return vehicleMapper.toResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleResponse update(String plate, VehicleRequest request) {
        Vehicle vehicleToUpdate = vehicleRepository.findById(plate)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicleMapper.updateFromDto(request, vehicleToUpdate);
        return vehicleMapper.toResponse(vehicleRepository.save(vehicleToUpdate));
    }

    @Override
    public void delete(String plate) {
        vehicleRepository.deleteById(plate);
    }
}
