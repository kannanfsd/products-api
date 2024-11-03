package com.teammenz.controller;

import com.teammenz.dto.CategoryDto;
import com.teammenz.dto.ProductDto;
import com.teammenz.entity.Category;
import com.teammenz.entity.Product;
import com.teammenz.exception.ResourceNotFoundException;
import com.teammenz.service.impl.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "Team Menz Panel-Task for Products API Services",
        description = "TEAM MENZ - Panel task Backend as Java17, Hibernate and SpringBoot"
)
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/api/category", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CategoryController {
    private CategoryService categoryService;
    @GetMapping()
    public List<CategoryDto> getAllProducts() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getProductById(@PathVariable Long id) {
        Optional<Category> optionalCategoryDto = categoryService.getCategoryById(id);
        return optionalCategoryDto.map(Category::getCategoryDto).orElseThrow(
                () -> new ResourceNotFoundException("Products", "ProductId", "Not found")
        );
    }
}
