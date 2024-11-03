package com.teammenz.controller;

import com.teammenz.constant.ProductConstant;
import com.teammenz.dto.ProductDto;
import com.teammenz.dto.ResponseDto;
import com.teammenz.entity.Product;
import com.teammenz.service.impl.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "Team Menz Panel-Task for Products API Services",
    description = "TEAM MENZ - Panel task Backend as Java17, Hibernate and SpringBoot"
)
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/api/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductsController {

    private ProductService productService;

    @GetMapping()
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseDto(ProductConstant.STATUS_201, ProductConstant.MESSAGE_201));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        boolean isUpdated = productService.updateProduct(id, productDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ProductConstant.STATUS_200, ProductConstant.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ProductConstant.STATUS_417, ProductConstant.MESSAGE_417_UPDATE));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ProductConstant.STATUS_200, ProductConstant.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ProductConstant.STATUS_417, ProductConstant.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/category")
    public List<ProductDto> getProductsByCategoryId(@RequestParam Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
