package org.example.stock.controller;

import lombok.RequiredArgsConstructor;
import org.example.stock.dto.ProductDto;
import org.example.stock.request.ProductRequest;
import org.example.stock.response.ProductResponse;
import org.example.stock.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest){
        return toResponse(service.save(toDto(productRequest)));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }

    @GetMapping("/get-all")
    public List<ProductResponse> getAll(){
        return service.findAll().stream().map(this::toResponse).toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable int id){
        return toResponse(service.findById(id));
    }

    public ProductDto toDto(ProductRequest productRequest){
        return ProductDto.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .status(productRequest.getStatus())
                .categoryId(productRequest.getCategoryId())
                .build();
    }

    public ProductResponse toResponse(ProductDto dto){
        return ProductResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .categoryId(dto.getCategoryId())
                .build();
    }
}
