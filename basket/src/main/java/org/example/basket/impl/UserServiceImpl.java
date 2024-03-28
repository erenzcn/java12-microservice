package org.example.basket.impl;

import org.example.basket.response.UserResponse;
import org.example.basket.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse findUserById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8989/auth/users/" + id, UserResponse.class);
    }
}
