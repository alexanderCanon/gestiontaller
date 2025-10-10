package com.sistemaBD.service;

import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;

import java.util.List;

public interface IVehiclesService {

    List<VehiclesResponseDTO> getAllVehicles();

    VehiclesResponseDTO getVehicleById(String placa);

    VehiclesResponseDTO createVehicle(VehiclesRequestDTO vehicleDTO);

    VehiclesResponseDTO updateVehicle(String placa, VehiclesRequestDTO vehicleDTO);

    void deleteVehicle(String placa);
}
