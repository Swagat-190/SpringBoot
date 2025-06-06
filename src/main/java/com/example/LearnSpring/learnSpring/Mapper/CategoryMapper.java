package com.example.LearnSpring.learnSpring.Mapper;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.DTO.ProductDTO;
import com.example.LearnSpring.learnSpring.entity.Category;
import com.example.LearnSpring.learnSpring.entity.Product;
import java.util.stream.Collectors;

public class CategoryMapper {


    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        return new Category(categoryDTO.getId(),categoryDTO.getName());
    }
    public static CategoryDTO toCategoryDto(Category category){
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
}
