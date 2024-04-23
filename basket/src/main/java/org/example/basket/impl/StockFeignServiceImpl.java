package org.example.basket.impl;

import lombok.RequiredArgsConstructor;
import org.example.basket.exception.BasketException;
import org.example.basket.response.BaseResponse;
import org.example.basket.response.ProductResponse;
import org.example.basket.service.StockFeignCallableApi;
import org.example.basket.service.StockFeignIntegration;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockFeignServiceImpl implements StockFeignIntegration {

    private final StockFeignCallableApi stockFeignCallableApi;

    @Override
    public ProductResponse findProductById(int id) {
        ProductResponse response = stockFeignCallableApi.findProductById(id);
        if (response.getId() != 0){
            return response;
        } else {
            throw new BasketException(new BaseResponse(response.getCode(), response.getMessage()));
        }
    }
}
