package org.example.stock.controller;


import lombok.RequiredArgsConstructor;
import org.example.stock.dto.CategoryDto;
import org.example.stock.request.CategoryRequest;
import org.example.stock.response.CategoryResponse;
import org.example.stock.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest categoryRequest){
        return toResponse(service.save(toDto(categoryRequest)));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return service.deleteById(id);
    }

    @GetMapping("/get-all")
    public List<CategoryResponse> getAll(){
        return service.findAll().stream().map(this::toResponse).toList();
    }
    private CategoryResponse toResponse(CategoryDto dto){
        return CategoryResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .products(dto.getProducts())
                .build();
    }

    private CategoryDto toDto(CategoryRequest categoryRequest){
        return CategoryDto.builder()
                .name(categoryRequest.getName())
                .build();
    }
}
