package com.teammenz.controller;

import com.teammenz.constant.ProductConstant;
import com.teammenz.dto.ProductDto;
import com.teammenz.dto.ResponseDto;
import com.teammenz.entity.Product;
import com.teammenz.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = "/products/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductsController {

    private ProductService productService;

    @GetMapping("/fetch")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/fetch/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseDto(ProductConstant.STATUS_201, ProductConstant.MESSAGE_201));

    }

    @PutMapping("/update/{id}")
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
    @DeleteMapping("/delete/{id}")
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
}
