package com.sistemaBD.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String dpi;
    private String firstname;
    private String lastname;
    private Integer addressId;
    private String telNumber;
    private String email;
    private Integer roleId;
}
