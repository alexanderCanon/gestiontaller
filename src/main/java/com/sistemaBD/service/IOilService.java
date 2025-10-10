package com.sistemaBD.service;

import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;

import java.util.List;

public interface IOilService {

    List<OilResponseDTO> getAllOils();

    OilResponseDTO getOilById(Integer id);

    OilResponseDTO createOil(OilRequestDTO oilDTO);

    OilResponseDTO updateOil(Integer id, OilRequestDTO oilDTO);

    void deleteOil(Integer id);
}
