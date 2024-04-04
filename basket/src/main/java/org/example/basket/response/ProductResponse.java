package org.example.basket.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private int id;
    private String name;
    private Double price;
    private String description;
    private Boolean status;
    private int categoryId;
}
