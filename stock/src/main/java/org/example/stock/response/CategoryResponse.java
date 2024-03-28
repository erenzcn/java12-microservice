package org.example.stock.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    private int categoryId;
    private String name;
    private String description;
    private Boolean status;
}
