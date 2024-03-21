package org.example.basket.repository;


import org.example.basket.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    Basket findBasketByUserIdAndStatus(int userId,int status);
}
