package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.CityRequest;
import com.sistemaBD.dto.response.CityResponse;

import java.util.List;

public interface ICityService {
    List<CityResponse> findAll();
    CityResponse findById(Integer id);
    CityResponse save(CityRequest request);
    CityResponse update(Integer id, CityRequest request);
    void delete(Integer id);
}
