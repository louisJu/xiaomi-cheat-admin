package com.example.cheatAdmin.repository;

import com.example.cheatAdmin.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
