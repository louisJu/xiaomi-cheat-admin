package com.example.cheatAdmin.dto;

import com.example.cheatAdmin.domain.Brand;

public class BrandResponse {
    private Long id;
    private String name;
    private String imagePath;

    public BrandResponse() {
    }

    public BrandResponse(Long id, String name, String imagePath) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
    }

    public static BrandResponse of(Brand brand) {
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImagePath());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
