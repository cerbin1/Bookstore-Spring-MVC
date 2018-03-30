package com.bookstore.domain.repository;

import com.bookstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P123", "Iphone", new BigDecimal(1200), "New best phone!", 200));
        products.add(new Product("R254", "Samsung Vacuum Cleaner", new BigDecimal(1200), "Small and quiet.", 1000));
        return products;
    }
}
