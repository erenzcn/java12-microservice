package org.example.stock.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String name;
    private Double price;
    private String description;
    private Boolean status;
    private int categoryId;
}
