package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.ServiceRequest;
import com.sistemaBD.dto.response.ServiceResponse;

import java.util.List;

public interface IServiceEntityService {
    List<ServiceResponse> findAll();
    ServiceResponse findById(Integer id);
    ServiceResponse save(ServiceRequest request);
    ServiceResponse update(Integer id, ServiceRequest request);
    void delete(Integer id);
}
