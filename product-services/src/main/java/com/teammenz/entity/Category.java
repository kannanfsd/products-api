package com.teammenz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammenz.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Short priority;
}
