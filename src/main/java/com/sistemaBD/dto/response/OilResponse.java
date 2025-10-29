package com.sistemaBD.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OilResponse {
    private Integer id;
    private String name;
    private String type;
    private Integer price;
}
