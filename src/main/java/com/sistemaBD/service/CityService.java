package com.sistemaBD.service;

import com.sistemaBD.domain.City;
import com.sistemaBD.dto.request.CityRequest;
import com.sistemaBD.dto.response.CityResponse;
import com.sistemaBD.repository.CityRepository;
import com.sistemaBD.service.iservice.ICityService;
import com.sistemaBD.service.mapper.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService implements ICityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public List<CityResponse> findAll() {
        return cityRepository.findAll().stream()
                .map(cityMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CityResponse findById(Integer id) {
        return cityRepository.findById(id)
                .map(cityMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    @Override
    public CityResponse save(CityRequest request) {
        City city = cityMapper.toEntity(request);
        return cityMapper.toResponse(cityRepository.save(city));
    }

    @Override
    public CityResponse update(Integer id, CityRequest request) {
        City cityToUpdate = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        cityMapper.updateFromDto(request, cityToUpdate);
        return cityMapper.toResponse(cityRepository.save(cityToUpdate));
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }
}
