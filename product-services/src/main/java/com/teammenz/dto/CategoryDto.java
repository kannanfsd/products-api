package com.teammenz.dto;

import com.teammenz.entity.Product;
import lombok.Data;

import java.util.Set;
@Data
public class CategoryDto {
    private Long id;
    private String name;
    private Short priority;
}
