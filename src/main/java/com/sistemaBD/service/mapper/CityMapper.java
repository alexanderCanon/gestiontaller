package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.City;
import com.sistemaBD.dto.request.CityRequest;
import com.sistemaBD.dto.response.CityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityRequest request);
    CityResponse toResponse(City city);
    void updateFromDto(CityRequest request, @MappingTarget City city);
}
