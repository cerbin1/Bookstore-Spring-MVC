package com.bookstore.service;

import com.bookstore.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String categoryName);
}
