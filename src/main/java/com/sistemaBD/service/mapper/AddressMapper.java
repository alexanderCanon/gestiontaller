package com.sistemaBD.service.mapper;

import com.sistemaBD.domain.Address;
import com.sistemaBD.dto.request.AddressRequest;
import com.sistemaBD.dto.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, DepartmentMapper.class, CityMapper.class})
public interface AddressMapper {

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "city", ignore = true)
    Address toEntity(AddressRequest request);

    AddressResponse toResponse(Address address);

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "city", ignore = true)
    void updateFromDto(AddressRequest request, @MappingTarget Address address);
}
