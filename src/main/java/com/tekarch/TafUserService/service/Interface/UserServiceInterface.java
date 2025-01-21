package com.tekarch.TafUserService.service.Interface;

import com.tekarch.TafUserService.model.UserRequest;
import com.tekarch.TafUserService.model.UserResponse;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {

    UserResponse createUser(UserRequest requestBooking);
    UserResponse getUserById(Long userId);
    ResponseEntity<UserRequest> updateUser(UserRequest flights, Long userId);
}
