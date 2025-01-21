package com.tekarch.TafUserService.model;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String userName;
    private String email;
    private String phone;
}
