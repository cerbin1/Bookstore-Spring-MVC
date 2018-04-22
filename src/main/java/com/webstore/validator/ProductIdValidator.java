package com.webstore.validator;

import com.webstore.domain.Product;
import com.webstore.exception.ProductNotFoundException;
import com.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
    private final ProductService productService;

    @Autowired
    public ProductIdValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void initialize(ProductId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Product product;
        try {
            product = productService.getProductById(s);
        } catch (ProductNotFoundException e) {
            return true;
        }
        return product == null;
    }
}
