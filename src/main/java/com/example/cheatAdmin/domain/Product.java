package com.example.cheatAdmin.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private String name;
    private String code;
    private BigDecimal price;
    private Boolean isDeleted = false;

    public Product() {
    }

    public Product(Category category, Brand brand, String name, String code, BigDecimal price) {
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public void changeProduct(Category category, Brand brand, String name, String code, BigDecimal price) {
        if(this.category.getId() != category.getId()) {
            this.category = category;
        }
        if(this.brand.getId() != brand.getId()) {
            this.brand = brand;
        }
        if(!(this.name.equals(name))) {
            this.name = name;
        }
        if(!(this.code.equals(code))) {
            this.code = code;
        }
        if(!(this.price != price)) {
            this.price = price;
        }
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Brand getBrand() {
        return brand;
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
