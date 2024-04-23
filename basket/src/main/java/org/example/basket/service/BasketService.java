package org.example.basket.service;


import org.example.basket.dto.BasketDto;
import org.example.basket.response.ProductResponse;
import org.example.basket.response.UserResponse;

public interface BasketService {
    BasketDto save(BasketDto basketDto);

    UserResponse test(int id);

    ProductResponse test2(int id);
}
