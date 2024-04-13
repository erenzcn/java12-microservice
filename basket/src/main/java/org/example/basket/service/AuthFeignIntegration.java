package org.example.basket.service;

import org.example.basket.response.UserResponse;

public interface AuthFeignIntegration {
    UserResponse findUserById(int id);
}
