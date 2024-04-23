package org.example.basket.service;

import org.example.basket.response.ProductResponse;

public interface StockFeignIntegration {
    ProductResponse findProductById(int id);
}
