package com.example.LearnSpring.learnSpring.Controller;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.Exception.CategoryAlreadyExistException;
import com.example.LearnSpring.learnSpring.Service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Production API",
        description = "create , delete,update for Category"
)
@RestController

@RequestMapping("/api/categories")
public class CategoryController {
  private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
      public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));
      }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
      @GetMapping
    public List<CategoryDTO> getAllCategories (){
        return categoryService.getAllCategories();
    }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
         return categoryService.getCategoryById(id);

    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);

    }
}

