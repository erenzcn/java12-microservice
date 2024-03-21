package org.example.basket.service;

import org.example.basket.response.ProductResponse;

public interface ProductService {
    ProductResponse findProduct(int id);
}
