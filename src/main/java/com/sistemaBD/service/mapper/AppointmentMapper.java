package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Appointment;
import com.sistemaBD.dto.request.AppointmentRequest;
import com.sistemaBD.dto.response.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ServiceEntityMapper.class, VehicleMapper.class, UserMapper.class})
public interface AppointmentMapper {

    @Mapping(target = "service", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "user", ignore = true)
    Appointment toEntity(AppointmentRequest request);

    AppointmentResponse toResponse(Appointment appointment);

    @Mapping(target = "service", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateFromDto(AppointmentRequest request, @MappingTarget Appointment appointment);
}
