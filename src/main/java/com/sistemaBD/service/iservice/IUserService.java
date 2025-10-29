package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.UserRequest;
import com.sistemaBD.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    List<UserResponse> findAll();
    UserResponse findById(String dpi);
    UserResponse save(UserRequest request);
    UserResponse update(String dpi, UserRequest request);
    void delete(String dpi);
}
