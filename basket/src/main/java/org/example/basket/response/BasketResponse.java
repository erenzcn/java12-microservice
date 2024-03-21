package org.example.basket.response;

import lombok.*;
import org.example.basket.dto.BasketProductDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {
    private int id;
    private int status;
    private double totalPrice;
    private int userId;
    private List<BasketProductDto> basketProducts;
}
