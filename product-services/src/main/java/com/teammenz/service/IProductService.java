package com.teammenz.service;

import com.teammenz.dto.ProductDto;
import com.teammenz.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    boolean createProduct(ProductDto productDto);

    boolean updateProduct(Long id, ProductDto productDto);

    boolean deleteProduct(Long id);

    List<ProductDto> getProductsByCategoryId(Long categoryId);
}
