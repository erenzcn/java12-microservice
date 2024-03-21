package org.example.stock.response;

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
    private int categoryId;
}
