package org.example.basket.impl;

import org.example.basket.response.UserResponse;
import org.example.basket.service.AuthFeignCallableApi;
import org.example.basket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AuthFeignCallableApi authFeignCallableApi;

    @Override
    public UserResponse findUserById(int id) {
        return authFeignCallableApi.find(id);
    }
}
