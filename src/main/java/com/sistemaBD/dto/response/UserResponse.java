package com.sistemaBD.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String dpi;
    private String firstname;
    private String lastname;
    private AddressResponse address;
    private String telNumber;
    private String email;
    private RoleResponse role;
}
