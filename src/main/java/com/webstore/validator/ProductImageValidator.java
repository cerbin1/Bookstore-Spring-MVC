package com.webstore.validator;

import com.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductImageValidator implements Validator {
    private static final long ALLOWED_BYTES_FOR_IMAGES = 3145728;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getProductImage() != null
                && product.getProductImage().getSize() > ALLOWED_BYTES_FOR_IMAGES) {
            errors.rejectValue("productImage", "com.webstore.validator.ProductImageValidator.message");
        }
    }
}
