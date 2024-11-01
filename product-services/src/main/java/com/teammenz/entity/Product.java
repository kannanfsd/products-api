package com.teammenz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammenz.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore // @JsonIgnore is used to ignore the user field when serializing the object to JSON.
    private Category category;

    public ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);
        productDto.setCategoryId(category.getId());
        productDto.setCategoryName(category.getName());
        productDto.setPriority(category.getPriority());
        return productDto;
    }
}
