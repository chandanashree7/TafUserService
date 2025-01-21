package com.tekarch.TafUserService.service;

import com.tekarch.TafUserService.model.UserRequest;
import com.tekarch.TafUserService.model.UserResponse;
import com.tekarch.TafUserService.resttemplate.UserRestTemplate;
import com.tekarch.TafUserService.service.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRestTemplate userRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserResponse createUser(UserRequest user) {
        return userRestTemplate.createFlight(user);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return userRestTemplate.getUserById(userId);
    }

    @Override
    public ResponseEntity<UserRequest> updateUser(UserRequest users, Long userId) {
        return userRestTemplate.updateUser(userId,users);
    }
}
