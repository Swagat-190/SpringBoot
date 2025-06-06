package com.example.LearnSpring.learnSpring.Service;

import com.example.LearnSpring.learnSpring.DTO.CategoryDTO;
import com.example.LearnSpring.learnSpring.DTO.ProductDTO;
import com.example.LearnSpring.learnSpring.Mapper.CategoryMapper;
import com.example.LearnSpring.learnSpring.Mapper.ProductMapper;
import com.example.LearnSpring.learnSpring.Repository.CategoryRepository;
import com.example.LearnSpring.learnSpring.Repository.ProductRepository;
import com.example.LearnSpring.learnSpring.entity.Category;
import com.example.LearnSpring.learnSpring.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO){
       Category category =  categoryRepository.findById(productDTO.getCategory_id()).orElseThrow(() -> new RuntimeException("Category Not Found"));

        Product product = ProductMapper.toProductEntity(productDTO, category );
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);


    }
    public List<ProductDTO> getAllProducts(){
       return  productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    public ProductDTO getProductById(Long id){
         Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
         return ProductMapper.toProductDTO(product);
    }
    public ProductDTO updateProduct(Long id , ProductDTO productDTO){
        Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        Category category = categoryRepository.findById(productDTO.getCategory_id()).orElseThrow(()->new RuntimeException("Category Not Found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setValue(productDTO.getValue());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product " + id +" Deleted Successfully";
    }
    public List<ProductDTO> getProductByCategoryId(Long category_id){
         return productRepository.findAllByCategory_Id(category_id).stream().map(ProductMapper::toProductDTO).toList();
    }
    public List<ProductDTO> getProductByCategoryName(String name){
        return productRepository.findALlByCategory_Name(name).stream().map(ProductMapper::toProductDTO).toList();
    }
}
