package com.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


public class ProductCategoryValidator implements ConstraintValidator<ProductCategory, String> {
    private final List<String> allowedCategories = Arrays
            .asList("Laptop", "Smartphone", "Tablet", "Camera", "Peripherals", "Gadgets");

    @Override
    public void initialize(ProductCategory productCategory) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return allowedCategories.contains(s);
    }
}
