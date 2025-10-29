package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.DepartmentRequest;
import com.sistemaBD.dto.response.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> findAll();
    DepartmentResponse findById(Integer id);
    DepartmentResponse save(DepartmentRequest request);
    DepartmentResponse update(Integer id, DepartmentRequest request);
    void delete(Integer id);
}
