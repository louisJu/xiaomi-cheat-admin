package com.example.cheatAdmin.dto;

public class CategoryRequest {
    private String name;
    private String description;

    protected CategoryRequest() {
    }

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
