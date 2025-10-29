package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Department;
import com.sistemaBD.dto.request.DepartmentRequest;
import com.sistemaBD.dto.response.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentRequest request);
    DepartmentResponse toResponse(Department department);
    void updateFromDto(DepartmentRequest request, @MappingTarget Department department);
}
