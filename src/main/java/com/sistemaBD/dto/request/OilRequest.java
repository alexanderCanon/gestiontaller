package com.sistemaBD.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OilRequest {
    private String name;
    private String type;
    private Integer price;
}
