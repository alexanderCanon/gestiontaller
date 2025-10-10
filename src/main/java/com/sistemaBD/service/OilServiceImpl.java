package com.sistemaBD.service;

import com.sistemaBD.domain.Oil;
import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;
import com.sistemaBD.repository.OilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OilServiceImpl implements OilService {

    private final OilRepository oilRepository;
    private final OilMapper oilMapper;

    // Inyección de dependencias por constructor (práctica recomendada por SOLID)
    public OilServiceImpl(OilRepository oilRepository, OilMapper oilMapper) {
        this.oilRepository = oilRepository;
        this.oilMapper = oilMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OilResponseDTO> findAll() {
        List<Oil> oils = oilRepository.findAll();
        return oilMapper.toResponseDTOList(oils);
    }

    @Override
    @Transactional(readOnly = true)
    public OilResponseDTO findById(Integer id) {
        Oil oil = oilRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aceite no encontrado con ID: " + id));
        return oilMapper.toResponseDTO(oil);
    }

    @Override
    @Transactional
    public OilResponseDTO save(OilRequestDTO oilDTO) {
        Oil oil = oilMapper.toEntity(oilDTO);
        Oil savedOil = oilRepository.save(oil);
        return oilMapper.toResponseDTO(savedOil);
    }

    @Override
    @Transactional
    public OilResponseDTO update(Integer id, OilRequestDTO oilDTO) {
        Oil existingOil = oilRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se puede actualizar. Aceite no encontrado con ID: " + id));

        // Usa el mapper para actualizar la entidad existente con los datos del DTO
        oilMapper.updateEntityFromDto(oilDTO, existingOil);

        Oil updatedOil = oilRepository.save(existingOil);
        return oilMapper.toResponseDTO(updatedOil);
    }



    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (!oilRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Aceite no encontrado con ID: " + id);
        }
        oilRepository.deleteById(id);
    }
}