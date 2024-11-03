package com.teammenz.mapper;

import com.teammenz.dto.ProductDto;
import com.teammenz.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public static Product mapToProduct(ProductDto productDto, Product product) {
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        return product;
    }
}

