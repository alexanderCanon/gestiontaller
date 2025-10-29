package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Vehicle;
import com.sistemaBD.dto.request.VehicleRequest;
import com.sistemaBD.dto.response.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toEntity(VehicleRequest request);
    VehicleResponse toResponse(Vehicle vehicle);
    void updateFromDto(VehicleRequest request, @MappingTarget Vehicle vehicle);
}
