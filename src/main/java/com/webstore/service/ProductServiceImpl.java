package com.webstore.service;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.getProductsByCategory(categoryName);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public void addProduct(Product newProduct) {
        productRepository.addProduct(newProduct);
    }

    @Override
    public void updateAllStock() {
        List<Product> products = productRepository.getAllProducts();
        products.forEach(product -> {
            long unitsInStock = product.getUnitsInStock();
            if (unitsInStock < 500) {
                productRepository.updateStock(product.getProductId(), unitsInStock + 500);
            }
        });
    }
}
