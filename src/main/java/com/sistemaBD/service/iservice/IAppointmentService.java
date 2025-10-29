package com.sistemaBD.service.iservice;

import com.sistemaBD.dto.request.AppointmentRequest;
import com.sistemaBD.dto.response.AppointmentResponse;

import java.util.List;

public interface IAppointmentService {
    List<AppointmentResponse> findAll();
    AppointmentResponse findById(Integer id);
    AppointmentResponse save(AppointmentRequest request);
    AppointmentResponse update(Integer id, AppointmentRequest request);
    void delete(Integer id);
}
