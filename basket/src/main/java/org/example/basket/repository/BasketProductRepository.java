package org.example.basket.repository;


import org.example.basket.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Integer> {
    BasketProduct findBasketProductByBasket_IdAndProductId(int basketId,int productId);
}
