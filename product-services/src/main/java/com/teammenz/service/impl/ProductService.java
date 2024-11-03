package com.teammenz.service.impl;

import com.teammenz.dto.ProductDto;
import com.teammenz.entity.Category;
import com.teammenz.entity.Product;
import com.teammenz.exception.ResourceNotFoundException;
import com.teammenz.repository.ProductRepository;
import com.teammenz.service.IProductService;
import com.teammenz.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    @Autowired
    private NotificationService notificationService;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(Product::getProductDto).orElseThrow(
                () -> new ResourceNotFoundException("Products", "ProductId", "Not found")
        );
    }

    public boolean createProduct(ProductDto productDto) {
        boolean isCreated = false;
        Optional<Category> optionalCategory = categoryService.getCategoryById(productDto.getCategoryId());
        if(optionalCategory.isPresent()) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setQuantity(productDto.getQuantity());
            product.setCategory(optionalCategory.get());
            productRepository.save(product);
            isCreated = true;
        }
        return isCreated;
    }

    public boolean updateProduct(Long id, ProductDto productDto) {
        boolean isUpdated = false;
        Optional<Category> optionalCategory = categoryService.getCategoryById(productDto.getCategoryId());
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "ProductId", "Not found")
        );
        if(product!=null && optionalCategory.isPresent()) {
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            product.setCategory(optionalCategory.get());
            productRepository.save(product);
            isUpdated = true;
        }
        return isUpdated;
    }

    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "ProductId", "Not found")
        );
        if(product!=null) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(Product::getProductDto).collect(Collectors.toList());
    }
}
