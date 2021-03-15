package com.example.cheatAdmin.dto;

public class BrandRequest {
    private String name;
    private String imagePath;

    protected BrandRequest() {
    }

    public BrandRequest(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
