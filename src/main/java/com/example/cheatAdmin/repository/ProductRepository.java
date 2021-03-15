package com.example.cheatAdmin.repository;

import com.example.cheatAdmin.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
