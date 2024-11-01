package com.teammenz.dto;

import com.teammenz.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Schema(
        name = "Product",
        description = "Schema to hold Product information"
)
@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long categoryId;
    private String categoryName;
    private int priority;
}
