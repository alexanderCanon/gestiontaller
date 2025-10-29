package com.sistemaBD.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Integer countryId;
    private Integer departmentId;
    private Integer cityId;
    private String area;
    private String direction;
}
