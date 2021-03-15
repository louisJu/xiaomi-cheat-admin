package com.example.cheatAdmin.dto;

import com.example.cheatAdmin.domain.Category;

public class CategoryResponse {
    private Long id;

    private String name;
    private String description;

    public CategoryResponse() {
    }

    public CategoryResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getId(), category.getName(), category.getDescription());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
