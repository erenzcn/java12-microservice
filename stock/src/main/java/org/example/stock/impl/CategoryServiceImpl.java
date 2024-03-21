package org.example.stock.impl;

import lombok.RequiredArgsConstructor;
import org.example.stock.dto.CategoryDto;
import org.example.stock.entity.Category;
import org.example.stock.repository.CategoryRepository;
import org.example.stock.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return toDto(repository.save(toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(int id) {
        return toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Category not found.")));
    }

    @Override
    public String deleteById(int id) {
        Category category=repository.findById(id).orElseThrow(()->new RuntimeException("Category not found."));
        repository.deleteById(category.getId());
        return "Category named "+category.getName()+" has been deleted.";
    }

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }


    public CategoryDto toDto(Category category){
        category.setProducts(category.getProducts());
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    @Override
    public Category toEntity(CategoryDto dto){
        Category category=new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
