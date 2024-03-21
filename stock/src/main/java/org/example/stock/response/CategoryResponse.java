package org.example.stock.response;

import lombok.*;
import org.example.stock.dto.ProductDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    private int id;
    private String name;
    private List<ProductDto> products;
}
