package com.example.LearnSpring.learnSpring.Service;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.Exception.CategoryAlreadyExistException;
import com.example.LearnSpring.learnSpring.Mapper.CategoryMapper;
import com.example.LearnSpring.learnSpring.Repository.CategoryRepository;
import com.example.LearnSpring.learnSpring.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

@Service
public class CategoryService {
    private  final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
            Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
            if (optionalCategory.isPresent()){
                throw new CategoryAlreadyExistException("Category Alrady Exists");
            }
           Category category =  CategoryMapper.toCategoryEntity(categoryDTO);
           category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }
    public List<CategoryDTO> getAllCategories(){
          return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();
    }
    public CategoryDTO getCategoryById(Long id){

       Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Foumd"));
       return CategoryMapper.toCategoryDto(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
