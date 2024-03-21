package org.example.stock.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private int id;
    private String name;
    private List<ProductDto> products;
}
