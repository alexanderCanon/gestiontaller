package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.AddressRequest;
import com.sistemaBD.dto.response.AddressResponse;

import java.util.List;

public interface IAddressService {
    List<AddressResponse> findAll();
    AddressResponse findById(Integer id);
    AddressResponse save(AddressRequest request);
    AddressResponse update(Integer id, AddressRequest request);
    void delete(Integer id);
}
