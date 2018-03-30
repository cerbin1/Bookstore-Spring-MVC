package com.bookstore.domain.repository;

import com.bookstore.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
}
