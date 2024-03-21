package org.example.basket.service;


import org.example.basket.entity.BasketProduct;

public interface BasketProductService {
    BasketProduct save(BasketProduct basketProduct);
    BasketProduct findByBasketIdAndProductId(int basketId,int productId);
}
