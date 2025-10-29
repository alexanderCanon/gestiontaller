package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.VehicleRequest;
import com.sistemaBD.dto.response.VehicleResponse;

import java.util.List;

public interface IVehicleService {
    List<VehicleResponse> findAll();
    VehicleResponse findById(String plate);
    VehicleResponse save(VehicleRequest request);
    VehicleResponse update(String plate, VehicleRequest request);
    void delete(String plate);
}
