package com.sistemaBD.service;

import com.sistemaBD.domain.Country;
import com.sistemaBD.dto.request.CountryRequest;
import com.sistemaBD.dto.response.CountryResponse;
import com.sistemaBD.repository.CountryRepository;
import com.sistemaBD.service.iservice.ICountryService;
import com.sistemaBD.service.mapper.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryResponse> findAll() {
        return countryRepository.findAll().stream()
                .map(countryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CountryResponse findById(Integer id) {
        return countryRepository.findById(id)
                .map(countryMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @Override
    public CountryResponse save(CountryRequest request) {
        Country country = countryMapper.toEntity(request);
        return countryMapper.toResponse(countryRepository.save(country));
    }

    @Override
    public CountryResponse update(Integer id, CountryRequest request) {
        Country countryToUpdate = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        countryMapper.updateFromDto(request, countryToUpdate);
        return countryMapper.toResponse(countryRepository.save(countryToUpdate));
    }

    @Override
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
