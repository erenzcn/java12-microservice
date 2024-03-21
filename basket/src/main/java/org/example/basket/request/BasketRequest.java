package org.example.basket.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketRequest {
    private int userId;
    private int basketId;
    private int productId;
    private int count;
}
