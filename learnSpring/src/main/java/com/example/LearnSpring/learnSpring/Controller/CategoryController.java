package com.example.LearnSpring.learnSpring.Controller;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.Service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/categories")
public class CategoryController {
  private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
      public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
            return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
      }
      @GetMapping
    public List<CategoryDTO> getAllCategories (){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
         return categoryService.getCategoryById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);

    }
}

