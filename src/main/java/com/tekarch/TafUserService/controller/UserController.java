package com.tekarch.TafUserService.controller;

import com.tekarch.TafUserService.model.UserRequest;
import com.tekarch.TafUserService.model.UserResponse;
import com.tekarch.TafUserService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl UserService;

    @PostMapping(path="/create")
    public ResponseEntity<UserResponse> createFlight(@RequestBody UserRequest userRequest) {
        UserResponse flightResponse = UserService.createUser(userRequest);
        return new ResponseEntity<>(flightResponse, HttpStatus.CREATED);
    }

    @GetMapping(path="/getUser/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        UserResponse flightResponse = UserService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(flightResponse);
    }

    @PutMapping(path="/updateUser/{userId}")
    public ResponseEntity<ResponseEntity<UserRequest>> updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest){
        ResponseEntity<UserRequest> userResponse = UserService.updateUser(userRequest, userId);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

}
