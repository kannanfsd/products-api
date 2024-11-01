package com.teammenz.repository;

import com.teammenz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins="http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
