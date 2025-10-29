package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.RoleRequest;
import com.sistemaBD.dto.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    List<RoleResponse> findAll();
    RoleResponse findById(Integer id);
    RoleResponse save(RoleRequest request);
    RoleResponse update(Integer id, RoleRequest request);
    void delete(Integer id);
}
