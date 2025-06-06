package com.example.LearnSpring.learnSpring.Controller;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.DTO.ProductDTO;
import com.example.LearnSpring.learnSpring.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);

    }
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")

    public ProductDTO getProductById( @PathVariable Long id){

        return productService.getProductById(id);
    }
    @PostMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id , @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id , productDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
      return productService.deleteProduct(id);

    }
    @GetMapping("/by/{category_id}")
    public List<ProductDTO> getAllProductByCategoryId(@PathVariable Long category_id){
       return  productService.getProductByCategoryId(category_id);


    }
    @GetMapping("/byName/{name}")
    public List<ProductDTO> getAllProductByCategoryId(@PathVariable String name){
        return  productService.getProductByCategoryName(name);


    }
}
