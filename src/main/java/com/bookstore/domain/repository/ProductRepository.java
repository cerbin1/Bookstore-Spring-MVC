package com.bookstore.domain.repository;

import com.bookstore.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String categoryName);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
