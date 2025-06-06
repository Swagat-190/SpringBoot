package com.example.LearnSpring.learnSpring.Repository;

import com.example.LearnSpring.learnSpring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
