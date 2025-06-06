package com.example.LearnSpring.learnSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProductDTO {
    private Long id;
    private String name;

    public ProductDTO(Long id, String name, String description, Double value, Long category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.category_id = category_id;
    }

    private String description;
    private Double value;
    private Long category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue
            (Double price) {
        this.value = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
