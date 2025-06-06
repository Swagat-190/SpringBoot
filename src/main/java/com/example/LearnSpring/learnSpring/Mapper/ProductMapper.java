package com.example.LearnSpring.learnSpring.Mapper;

import com.example.LearnSpring.learnSpring.DTO.ProductDTO;
import com.example.LearnSpring.learnSpring.entity.Category;
import com.example.LearnSpring.learnSpring.entity.Product;

public class ProductMapper {
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        if(productDTO == null){
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setValue(productDTO.getValue());
        product.setCategory(category);
        return product;
    }public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getId(),
                product.getName(),product.getDescription(),product.getValue(),product.getCategory().getId());
    }
}
