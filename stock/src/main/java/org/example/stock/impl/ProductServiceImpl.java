package org.example.stock.impl;


import lombok.RequiredArgsConstructor;
import org.example.stock.dto.ProductDto;
import org.example.stock.entity.Product;
import org.example.stock.exception.StockException;
import org.example.stock.repository.ProductRepository;
import org.example.stock.response.BaseResponse;
import org.example.stock.service.CategoryService;
import org.example.stock.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;

    @Override
    public ProductDto save(ProductDto productDto) {
        return toDto(repository.save(toEntity(productDto)));
    }

    @Override
    public ProductDto findProductById(int id) {
        return toDto(repository.findById(id).orElseThrow(()->
                new StockException(new BaseResponse(3001, "Product not found"))));
    }

    @Override
    public String deleteById(int id) {
        Product product=repository.findById(id).orElseThrow(()->
                new StockException(new BaseResponse(3001, "Product not found")));
        repository.delete(product);
        return "Product named " + product.getName() +" has been deleted.";
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    ProductDto toDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .status(product.getStatus())
                .categoryId(product.getCategory().getCategoryId())
                .build();
    }

    @Override
    public Product toEntity(ProductDto dto){
        Product product=new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.getStatus());
        product.setDescription(dto.getDescription());
        product.setCategory(categoryService.toEntity(categoryService.findById(dto.getCategoryId())));
        return product;
    }
}
