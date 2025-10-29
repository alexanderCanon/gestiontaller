package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Role;
import com.sistemaBD.dto.request.RoleRequest;
import com.sistemaBD.dto.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role role);

    void updateFromDto(RoleRequest request, @MappingTarget Role role);
}
