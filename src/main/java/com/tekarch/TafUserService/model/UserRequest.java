package com.tekarch.TafUserService.model;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;
    private String email;
    private String phone;
}
