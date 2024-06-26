package org.example.stock.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private Double price;
    private String description;
    private Boolean status;
    private int categoryId;
}
