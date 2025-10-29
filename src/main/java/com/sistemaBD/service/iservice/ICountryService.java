package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.CountryRequest;
import com.sistemaBD.dto.response.CountryResponse;

import java.util.List;

public interface ICountryService {
    List<CountryResponse> findAll();
    CountryResponse findById(Integer id);
    CountryResponse save(CountryRequest request);
    CountryResponse update(Integer id, CountryRequest request);
    void delete(Integer id);
}
