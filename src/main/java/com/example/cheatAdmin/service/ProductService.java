package com.example.cheatAdmin.service;

import com.example.cheatAdmin.domain.Brand;
import com.example.cheatAdmin.domain.Category;
import com.example.cheatAdmin.domain.Product;
import com.example.cheatAdmin.repository.BrandRepository;
import com.example.cheatAdmin.repository.CategoryRepository;
import com.example.cheatAdmin.repository.ProductRepository;
import com.example.cheatAdmin.dto.ProductRequest;
import com.example.cheatAdmin.dto.ProductResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public ProductService(
        final ProductRepository productRepository,
        final CategoryRepository categoryRepository,
        final BrandRepository brandRepository
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("카테고리 정보를 찾을 수 없습니다."));
        Brand brand = brandRepository.findById(productRequest.getBrandId())
            .orElseThrow(() -> new IllegalArgumentException("브랜드 정보를 찾을 수 없습니다."));

        final Product savedProduct = productRepository.save(
            new Product(category, brand,
                        productRequest.getName(), productRequest.getCode(),
                        productRequest.getPrice())
        );
        return ProductResponse.of(savedProduct);
    }

    public ProductResponse findProductOne(Long id) {
        // findById를 이용해서 product 를 조회한다.
        // response로 감싸서 return
        final Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을 수 없습니다."));

        return ProductResponse.of(product);
    }

    public List<ProductResponse> findProduct() {
        // findAll를 이용해서 product를  전체 조회한다.
        // response로 감싸서 return
        final List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductResponse.of(product))
            .collect(Collectors.toList());
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        final Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을 수 없습니다."));

        Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("카테고리 정보를 찾을 수 없습니다."));
        Brand brand = brandRepository.findById(productRequest.getBrandId())
            .orElseThrow(() -> new IllegalArgumentException("브랜드 정보를 찾을 수 없습니다."));
        product.changeProduct(category, brand, productRequest.getName(), productRequest.getCode(),
                           productRequest.getPrice());

        return ProductResponse.of(product);
    }

    public void deleteProduct(Long id) {
        //TODO
        // 추후에 진행
        //final Product product = productRepository.findById(id).orElseThrow();
        // id를 이용해서 조회한다.
        // 삭제플래그만 바꾼다.
        // return은 안도려줘도 된다!
    }
}
