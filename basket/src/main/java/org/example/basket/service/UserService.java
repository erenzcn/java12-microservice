package org.example.basket.service;

import org.example.basket.response.UserResponse;

public interface UserService {
    UserResponse findUserById(int id);
}
