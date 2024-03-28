package org.example.stock.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private int categoryId;
    private String name;
    private String description;
    private Boolean status;
    private List<ProductDto> products;
}
