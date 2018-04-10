package com.webstore.service;

import com.webstore.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String categoryName);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);

    void addProduct(Product newProduct);

    void updateAllStock();
}
