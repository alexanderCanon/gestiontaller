package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Country;
import com.sistemaBD.dto.request.CountryRequest;
import com.sistemaBD.dto.response.CountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryRequest request);
    CountryResponse toResponse(Country country);
    void updateFromDto(CountryRequest request, @MappingTarget Country country);
}
