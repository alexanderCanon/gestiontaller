package com.sistemaBD.service;

import com.sistemaBD.domain.Oil;
import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;
import com.sistemaBD.repository.OilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OilService implements IOilService {

    private final OilRepository oilRepository;
    private final OilMapper oilMapper;

    public OilService(OilRepository oilRepository, OilMapper oilMapper) {
        this.oilRepository = oilRepository;
        this.oilMapper = oilMapper;
    }

    @Override
    public List<OilResponseDTO> getAllOils() {
        List<Oil> oils = oilRepository.findAll();
        return oilMapper.toResponseDTOList(oils);
    }

    @Override
    public OilResponseDTO getOilById(Integer id) {
        Oil oil = findOilByIdOrThrow(id);
        return oilMapper.toResponseDTO(oil);
    }

    @Override
    public OilResponseDTO createOil(OilRequestDTO oilDTO) {
        Oil oil = oilMapper.toEntity(oilDTO);
        Oil savedOil = oilRepository.save(oil);
        return oilMapper.toResponseDTO(savedOil);
    }

    @Override
    public OilResponseDTO updateOil(Integer id, OilRequestDTO oilDTO) {
        Oil existingOil = findOilByIdOrThrow(id);

        oilMapper.updateEntityFromDto(oilDTO, existingOil);

        Oil updatedOil = oilRepository.save(existingOil);
        return oilMapper.toResponseDTO(updatedOil);
    }

    @Override
    public void deleteOil(Integer id) {
        if (!oilRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Aceite no encontrado con ID: " + id);
        }
        oilRepository.deleteById(id);
    }

    private Oil findOilByIdOrThrow(Integer id) {
        return oilRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aceite no encontrado con ID: " + id));
    }
}
