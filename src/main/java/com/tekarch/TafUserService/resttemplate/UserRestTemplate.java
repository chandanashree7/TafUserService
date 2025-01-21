package com.tekarch.TafUserService.resttemplate;

import com.tekarch.TafUserService.model.UserRequest;
import com.tekarch.TafUserService.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL="http://localhost:8083/api";

    public UserResponse createFlight(UserRequest requestUser){
        String url=BASE_URL+"/users/register";
        UserResponse response = restTemplate.postForObject(url,requestUser, UserResponse.class);
        System.out.println("User response:"+response);
        return response;
    }

    public UserResponse getUserById(Long userId){
        String url=BASE_URL+"/users/{userId}";
        System.out.println("Get User url:"+url);
        return restTemplate.getForObject(url,UserResponse.class,userId);
    }

    public ResponseEntity<UserRequest> updateUser(Long userId, UserRequest updatedUser){
        String url=BASE_URL+"/users/{userId}";
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRequest> requestEntity=new HttpEntity<>(updatedUser,headers);
        return restTemplate.exchange(url, HttpMethod.PUT,requestEntity,UserRequest.class,userId);
    }
}
