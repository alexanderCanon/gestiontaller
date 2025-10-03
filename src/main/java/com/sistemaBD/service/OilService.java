package com.sistemaBD.service;

import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;

import java.util.List;

public interface OilService {

    /**
     * Recupera una lista de todos los aceites.
     * @return Lista de DTOs de respuesta de aceites.
     */
    List<OilResponseDTO> findAll();

    /**
     * Busca un aceite por su ID.
     * @param id El ID del aceite.
     * @return El DTO de respuesta del aceite encontrado.
     */
    OilResponseDTO findById(Integer id);

    /**
     * Crea un nuevo aceite.
     * @param oilDTO El DTO con la información del aceite a crear.
     * @return El DTO de respuesta del aceite creado.
     */
    OilResponseDTO save(OilRequestDTO oilDTO);

    /**
     * Actualiza un aceite existente.
     * @param id El ID del aceite a actualizar.
     * @param oilDTO El DTO con la nueva información.
     * @return El DTO de respuesta del aceite actualizado.
     */
    OilResponseDTO update(Integer id, OilRequestDTO oilDTO);

    /**
     * Elimina un aceite por su ID.
     * @param id El ID del aceite a eliminar.
     */
    void deleteById(Integer id);
}