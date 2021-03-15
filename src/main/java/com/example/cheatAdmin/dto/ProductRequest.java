package com.example.cheatAdmin.dto;

import java.math.BigDecimal;

public class ProductRequest {
    private Long categoryId;
    private Long brandId;
    private String name;
    private String code;
    private BigDecimal price;

    public ProductRequest() {
    }

    public ProductRequest(Long categoryId, Long brandId, String name, String code, BigDecimal price) {
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
