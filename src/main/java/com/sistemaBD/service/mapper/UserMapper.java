package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.User;
import com.sistemaBD.dto.request.UserRequest;
import com.sistemaBD.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "address", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(UserRequest request);

    UserResponse toResponse(User user);

    @Mapping(target = "address", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateFromDto(UserRequest request, @MappingTarget User user);
}
