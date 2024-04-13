package org.example.basket.impl;

import lombok.RequiredArgsConstructor;
import org.example.basket.exception.BasketException;
import org.example.basket.response.BaseResponse;
import org.example.basket.response.UserResponse;
import org.example.basket.service.AuthFeignCallableApi;
import org.example.basket.service.AuthFeignIntegration;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthFeignServiceImpl implements AuthFeignIntegration {

    private final AuthFeignCallableApi authFeignCallableApi;

    @Override
    public UserResponse findUserById(int id) {
        UserResponse response = authFeignCallableApi.find(id);
        if (response.getId() != 0){
            return response;
        } else {
            throw new BasketException(new BaseResponse(response.getCode(), response.getMessage()));
        }
    }
}
