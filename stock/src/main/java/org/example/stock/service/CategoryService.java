package org.example.stock.service;


import org.example.stock.dto.CategoryDto;
import org.example.stock.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(int id);
    String deleteById(int id);

    List<CategoryDto> findAll();

    Category toEntity(CategoryDto dto);
}
