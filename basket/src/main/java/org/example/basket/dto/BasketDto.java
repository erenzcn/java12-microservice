package org.example.basket.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDto {
    private int id;
    private int status;
    private double totalPrice;
    private int count;
    private int userId;
    private List<BasketProductDto> basketProducts;
}
