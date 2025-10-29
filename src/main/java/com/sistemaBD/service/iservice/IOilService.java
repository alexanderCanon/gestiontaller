package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.OilRequest;
import com.sistemaBD.dto.response.OilResponse;

import java.util.List;

public interface IOilService {
    List<OilResponse> findAll();
    OilResponse findById(Integer id);
    OilResponse save(OilRequest request);
    OilResponse update(Integer id, OilRequest request);
    void delete(Integer id);
}
