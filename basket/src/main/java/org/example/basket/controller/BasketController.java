package org.example.basket.controller;

import lombok.RequiredArgsConstructor;
import org.example.basket.dto.BasketDto;
import org.example.basket.dto.BasketProductDto;
import org.example.basket.request.BasketRequest;
import org.example.basket.response.BasketResponse;
import org.example.basket.response.UserResponse;
import org.example.basket.service.BasketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;


    @PostMapping
    public BasketResponse addBasket(@RequestBody BasketRequest basketRequest) {
        return toResponse(service.save(toDto(basketRequest)));
    }

    @GetMapping("/{id}")
    public UserResponse test(@PathVariable int id) {
        return service.test(id);
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
        List<BasketProductDto> basketProductDtoList = List.of(
                BasketProductDto.builder()
                        .productId(request.getProductId())
                        .count(request.getCount())
                        .build()
        );
        return BasketDto.builder()
                .userId(request.getUserId())
                .count(request.getCount())
                .basketProducts(basketProductDtoList)
                .build();
    }
}
