package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Oil;
import com.sistemaBD.dto.request.OilRequest;
import com.sistemaBD.dto.response.OilResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OilMapper {
    Oil toEntity(OilRequest request);
    OilResponse toResponse(Oil oil);
    void updateFromDto(OilRequest request, @MappingTarget Oil oil);
}
