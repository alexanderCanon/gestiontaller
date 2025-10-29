package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.ServiceEntity;
import com.sistemaBD.dto.request.ServiceRequest;
import com.sistemaBD.dto.response.ServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceEntityMapper {
    ServiceEntity toEntity(ServiceRequest request);
    ServiceResponse toResponse(ServiceEntity serviceEntity);
    void updateFromDto(ServiceRequest request, @MappingTarget ServiceEntity serviceEntity);
}
