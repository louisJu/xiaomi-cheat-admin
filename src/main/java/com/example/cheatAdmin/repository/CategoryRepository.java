package com.example.cheatAdmin.repository;

import com.example.cheatAdmin.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
