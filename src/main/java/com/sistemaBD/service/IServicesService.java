package com.sistemaBD.service;


import com.sistemaBD.dto.ServicesRequestDTO;
import com.sistemaBD.dto.ServicesResponseDTO;

import java.util.List;

/**
 * Interfaz para la capa de servicio que define las operaciones de negocio
 * para la gestión de Servicios del taller.
 */
public interface IServicesService {

    /**
     * Obtiene todos los servicios disponibles.
     * @return Una lista de DTOs con la información de cada servicio.
     */
    List<ServicesResponseDTO> getAllServices();

    /**
     * Busca y obtiene un servicio por su ID.
     * @param id El ID del servicio a buscar.
     * @return El DTO del servicio encontrado.
     */
    ServicesResponseDTO getServiceById(Integer id);

    /**
     * Crea un nuevo servicio.
     * @param requestDTO El DTO con la información del servicio a crear.
     * @return El DTO del servicio recién creado.
     */
    ServicesResponseDTO createService(ServicesRequestDTO requestDTO);

    /**
     * Actualiza un servicio existente.
     * @param id El ID del servicio a actualizar.
     * @param requestDTO El DTO con la nueva información del servicio.
     * @return El DTO del servicio actualizado.
     */
    ServicesResponseDTO updateService(Integer id, ServicesRequestDTO requestDTO);

    /**
     * Elimina un servicio por su ID.
     * @param id El ID del servicio a eliminar.
     */
    void deleteService(Integer id);

    /**
     * Busca y obtiene todos los servicios de un tipo específico.
     * @param tipo El tipo de servicio a buscar.
     * @return Una lista de DTOs con los servicios que coinciden con el tipo.
     */
    List<ServicesResponseDTO> getServicesByType(String tipo);
}
