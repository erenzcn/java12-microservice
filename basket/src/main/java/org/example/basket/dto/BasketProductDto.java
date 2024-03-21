package org.example.basket.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProductDto {
    private int id;
    private int productId;
    private int count;
    private double totalPrice;
    private int basketId;

    public BasketProductDto(int productId, int count) {
        this.productId=productId;
        this.count=count;
    }
}
