package org.example.basket.service;


import org.example.basket.dto.BasketDto;
import org.example.basket.response.BaseResponse;
import org.example.basket.response.UserResponse;

import java.util.Optional;

public interface BasketService {
    BasketDto save(BasketDto basketDto);

    UserResponse test(int id);
}
