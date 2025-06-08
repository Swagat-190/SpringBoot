package com.example.LearnSpring.learnSpring.Controller;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.DTO.ProductDTO;
import com.example.LearnSpring.learnSpring.Service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Production API",
        description = "create , delete,update for Product"
)
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/{id}")
    public ProductDTO getProductById( @PathVariable Long id){
        return productService.getProductById(id);
    }
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id , @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id , productDTO);
    }
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
      return productService.deleteProduct(id);

    }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/by/{category_id}")
    public List<ProductDTO> getAllProductByCategoryId(@PathVariable Long category_id){
       return  productService.getProductByCategoryId(category_id);


    }
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/byName/{name}")
    public List<ProductDTO> getAllProductByCategoryId(@PathVariable String name){
        return  productService.getProductByCategoryName(name);
    }
}
