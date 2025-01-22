package com.tekarch.TafUserService.resttemplate;

import com.tekarch.TafUserService.model.UserRequest;
import com.tekarch.TafUserService.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.base.url}")
    private final String BASE_URL;

    public UserRestTemplate(@Value("${api.base.url}") String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    public UserResponse createFlight(UserRequest requestUser){
        UserResponse response =restTemplate.postForObject(BASE_URL+"/register",requestUser,UserResponse.class);
        System.out.println("create flight:"+response);
        return response;
    }

    public UserResponse getUserById(Long userId){
        return restTemplate.getForObject(BASE_URL+"/{userId}",UserResponse.class,userId);
    }

    public ResponseEntity<UserRequest> updateUser(Long userId, UserRequest updatedUser){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRequest> requestEntity=new HttpEntity<>(updatedUser,headers);
        return restTemplate.exchange(BASE_URL+"/{userId}", HttpMethod.PUT,requestEntity,UserRequest.class,userId);
    }
}
