package org.example.basket.controller;

import lombok.RequiredArgsConstructor;
import org.example.basket.dto.BasketDto;
import org.example.basket.request.BasketRequest;
import org.example.basket.response.BasketResponse;
import org.example.basket.service.BasketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;


    @PostMapping
    public BasketResponse addBasket(@RequestBody BasketRequest basketRequest) {
        return toResponse(service.save(toDto(basketRequest)));
    }


    private BasketResponse toResponse(BasketDto dto) {
        return BasketResponse.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .totalPrice(dto.getTotalPrice())
                .userId(dto.getUserId())
                .basketProducts(dto.getBasketProducts())
                .build();
    }

    public BasketDto toDto(BasketRequest request) {
        return BasketDto.builder()
                .userId(request.getUserId())
                .count(request.getCount())
                .id(request.getBasketId())
                .build();
    }
}
