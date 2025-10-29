package com.sistemaBD.service;

import com.sistemaBD.domain.Oil;
import com.sistemaBD.dto.request.OilRequest;
import com.sistemaBD.dto.response.OilResponse;
import com.sistemaBD.repository.OilRepository;
import com.sistemaBD.service.iservice.IOilService;
import com.sistemaBD.service.mapper.OilMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OilService implements IOilService {

    private final OilRepository oilRepository;
    private final OilMapper oilMapper;

    @Override
    public List<OilResponse> findAll() {
        return oilRepository.findAll().stream()
                .map(oilMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OilResponse findById(Integer id) {
        return oilRepository.findById(id)
                .map(oilMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Oil not found"));
    }

    @Override
    public OilResponse save(OilRequest request) {
        Oil oil = oilMapper.toEntity(request);
        return oilMapper.toResponse(oilRepository.save(oil));
    }

    @Override
    public OilResponse update(Integer id, OilRequest request) {
        Oil oilToUpdate = oilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oil not found"));
        oilMapper.updateFromDto(request, oilToUpdate);
        return oilMapper.toResponse(oilRepository.save(oilToUpdate));
    }

    @Override
    public void delete(Integer id) {
        oilRepository.deleteById(id);
    }
}
