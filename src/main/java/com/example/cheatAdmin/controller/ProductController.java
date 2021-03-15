package com.example.cheatAdmin.controller;

import com.example.cheatAdmin.dto.ProductRequest;
import com.example.cheatAdmin.dto.ProductResponse;
import com.example.cheatAdmin.service.ProductService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //상품 등록
    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.created(URI.create("/products/" + productResponse.getId())).build();
    }

    //상품 조회(특정상품)
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductOne(@PathVariable Long id) {
        ProductResponse productResponse = productService.findProductOne(id);
        return ResponseEntity.ok().body(productResponse);
    }

    //상품 조회(리스트)
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findProductAll() {
        List<ProductResponse> productResponse = productService.findProduct();
        return ResponseEntity.ok().body(productResponse);
    }

    //상품 수정
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        productService.updateProduct(id, productRequest);
        return ResponseEntity.ok().build();
    }

    //상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
