package com.example.LearnSpring.learnSpring.Repository;

import com.example.LearnSpring.learnSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    List<Product> findAllByCategory_Id(Long categoryId);
    List<Product> findALlByCategory_Name(String name);

}
