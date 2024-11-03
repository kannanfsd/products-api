package com.teammenz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammenz.dto.CategoryDto;
import com.teammenz.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Short priority;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;

    public CategoryDto getCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);
        categoryDto.setPriority(priority);
        return categoryDto;
    }
}
