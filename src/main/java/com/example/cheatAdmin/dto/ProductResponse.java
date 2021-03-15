package com.example.cheatAdmin.dto;


import com.example.cheatAdmin.domain.Category;
import com.example.cheatAdmin.domain.Product;
import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String name;
    private String code;
    private BigDecimal price;
    private BrandResponse brandResponse;
    private CategoryResponse categoryResponse;

    protected ProductResponse() {
    }

    public ProductResponse(Long id, String name, String code, BigDecimal price, BrandResponse brandResponse,
                           CategoryResponse categoryResponse) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.brandResponse = brandResponse;
        this.categoryResponse = categoryResponse;
    }

    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                                   product.getCode(), product.getPrice(),
                                   BrandResponse.of(product.getBrand()),
                                   CategoryResponse.of(product.getCategory())
        );
    }

    public Long getId() {
        return id;
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

    public BrandResponse getBrandResponse() {
        return brandResponse;
    }

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }
}
