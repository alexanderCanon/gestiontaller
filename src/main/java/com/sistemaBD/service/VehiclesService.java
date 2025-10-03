package com.sistemaBD.service;

import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;

import java.util.List;

public interface VehiclesService {

    /**
     * Obtiene todos los vehículos.
     * @return Una lista de DTOs de vehículos.
     */
    List<VehiclesResponseDTO> findAll();

    /**
     * Busca un vehículo por su placa.
     * @param placa La placa del vehículo a buscar.
     * @return El DTO del vehículo encontrado.
     */
    VehiclesResponseDTO findById(String placa);

    /**
     * Guarda un nuevo vehículo.
     * @param vehicleDTO El DTO con la información del vehículo a crear.
     * @return El DTO del vehículo guardado.
     */
    VehiclesResponseDTO save(VehiclesRequestDTO vehicleDTO);

    /**
     * Actualiza un vehículo existente.
     * @param placa La placa del vehículo a actualizar.
     * @param vehicleDTO El DTO con la nueva información.
     * @return El DTO del vehículo actualizado.
     */
    VehiclesResponseDTO update(String placa, VehiclesRequestDTO vehicleDTO);

    /**
     * Elimina un vehículo por su placa.
     * @param placa La placa del vehículo a eliminar.
     */
    void deleteById(String placa);
}