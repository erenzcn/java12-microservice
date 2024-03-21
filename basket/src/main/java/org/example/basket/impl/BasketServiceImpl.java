package org.example.basket.impl;


import lombok.RequiredArgsConstructor;
import org.example.basket.dto.BasketDto;
import org.example.basket.dto.BasketProductDto;
import org.example.basket.entity.Basket;
import org.example.basket.entity.BasketProduct;
import org.example.basket.repository.BasketRepository;
import org.example.basket.response.ProductResponse;
import org.example.basket.response.UserResponse;
import org.example.basket.service.BasketProductService;
import org.example.basket.service.BasketService;
import org.example.basket.service.ProductService;
import org.example.basket.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository repository;
    private final BasketProductService basketProductService;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public BasketDto save(BasketDto basketDto) {
        UserResponse user = userService.findUserById(basketDto.getUserId());
        Basket basket = repository.findBasketByUserIdAndStatus(user.getId(), 0);
        if (basket == null) {
            return thereIsNoBasket(basketDto);
        } else {
            return thereIsBasket(basket, basketDto);
        }
    }

    private BasketDto thereIsBasket(Basket basket, BasketDto basketDto) {
        List<BasketProduct> basketProducts = basket.getBasketProducts();
        BasketProduct basketProduct = basketProductService.findByBasketIdAndProductId(basket.getId(), basketDto.getBasketProducts().get(0).getProductId());
        ProductResponse product = productService.findProduct(basketDto.getBasketProducts().get(0).getProductId());
        if (basketProduct == null) {
            basketProduct = basketProductService.save(createBasketProduct(basketDto.getBasketProducts(), basket, product.getPrice()));
            basketProducts.add(basketProduct);
        } else {
            for (BasketProductDto basketProductDto : basketDto.getBasketProducts()) {
                basketProduct.setCount(basketProduct.getCount() + basketProductDto.getCount());
                basketProduct.setTotalPrice(calculateTotalPrice(product.getPrice(), basketProduct.getCount()));
                basketProduct = basketProductService.save(basketProduct);
            }
        }

        basket.setBasketProducts(basketProducts);
        basket.setTotalPrice(calculateTotalPriceOfBasket(basketProducts));
        return toDto(basket);
    }

    private BasketDto thereIsNoBasket(BasketDto basketDto) {
        Basket basket = new Basket();
        basket.setStatus(0);
        basket.setUserId(basketDto.getUserId());
        List<BasketProduct> basketProducts = new ArrayList<>();
        ProductResponse product = productService.findProduct(basketDto.getBasketProducts().get(0).getProductId());
        basketProductService.save(createBasketProduct(basketDto.getBasketProducts(), basket, product.getPrice()));
        basket.setBasketProducts(basketProducts);
        basket.setTotalPrice(calculateTotalPriceOfBasket(basketProducts));
        basket = repository.save(basket);
        return toDto(basket);
    }

    private Double calculateTotalPriceOfBasket(List<BasketProduct> basketProducts) {
        return basketProducts.stream()
                .mapToDouble(BasketProduct::getTotalPrice)
                .sum();
    }

    private BasketProduct createBasketProduct(List<BasketProductDto> basketProducts ,Basket basket, Double price) {
        BasketProduct basketProduct = new BasketProduct();
        basketProducts.forEach(basketProductDto -> {
            basketProduct.setProductId(basketProductDto.getProductId());
            basketProduct.setBasket(basket);
            basketProduct.setCount(basketProductDto.getCount() + basketProduct.getCount());
            basketProduct.setTotalPrice(calculateTotalPrice(price, basketProduct.getCount()));
        });
        return basketProduct;
    }

    private double calculateTotalPrice(Double price, int count) {
        return price * count;
    }


    private BasketDto toDto(Basket basket) {
        List<BasketProductDto> basketProducts = basket.getBasketProducts().stream()
                .map(basketProduct -> BasketProductDto.builder()
                        .id(basketProduct.getId())
                        .productId(basketProduct.getProductId())
                        .count(basketProduct.getCount())
                        .totalPrice(basketProduct.getTotalPrice())
                        .basketId(basketProduct.getBasket().getId())
                        .build())
                .collect(Collectors.toList());

        return BasketDto.builder()
                .id(basket.getId())
                .status(basket.getStatus())
                .totalPrice(basket.getTotalPrice())
                .userId(basket.getUserId())
                .basketProducts(basketProducts)
                .build();
    }

}
