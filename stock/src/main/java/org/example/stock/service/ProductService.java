package org.example.stock.service;


import org.example.stock.dto.ProductDto;
import org.example.stock.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    ProductDto findById(int id);

    String deleteById(int id);

    List<ProductDto> findAll();

    Product toEntity(ProductDto dto);
}
