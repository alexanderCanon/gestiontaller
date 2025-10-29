package com.sistemaBD.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Integer id;
    private CountryResponse country;
    private DepartmentResponse department;
    private CityResponse city;
    private String area;
    private String direction;
}
