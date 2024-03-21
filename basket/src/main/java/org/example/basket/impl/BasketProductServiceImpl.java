package org.example.basket.impl;

import lombok.RequiredArgsConstructor;
import org.example.basket.entity.BasketProduct;
import org.example.basket.repository.BasketProductRepository;
import org.example.basket.service.BasketProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketProductServiceImpl implements BasketProductService {
    private final BasketProductRepository repository;

    @Override
    public BasketProduct save(BasketProduct basketProduct) {
        return repository.save(basketProduct);
    }

    @Override
    public BasketProduct findByBasketIdAndProductId(int basketId, int productId) {
        return repository.findBasketProductByBasket_IdAndProductId(basketId, productId);
    }
}
