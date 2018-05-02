package com.webstore.validator;

import com.webstore.config.WebApplicationContextConfig;
import com.webstore.domain.Product;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebApplicationContextConfig.class)
@WebAppConfiguration
public class ProductValidatorTest {
    @Autowired
    private ProductValidator productValidator;

    @Test
    public void shouldProductBeInvalidWhenHaveWrongCategory() {
        // given
        Product product = getDefaultProduct();
        product.setCategory("lorem");
        BindException bindException = new BindException(product, " product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Incorrect product category."));
    }

    @Test
    public void shouldProductBeInvalidWhenProductWithSameIdExists() {
        // given
        Product product = getDefaultProduct();
        product.setProductId("P1234");
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("A product already exists with this product id."));
    }


    @Test
    public void shouldProductBeInvalidWhenIdIsInvalid() {
        // given
        Product product = getDefaultProduct();
        product.setProductId(RandomStringUtils.random(30));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(2, bindException.getErrorCount());
        String localizedMessage = bindException.getLocalizedMessage();
        assertTrue(localizedMessage
                .contains("Invalid product Id. It should be minimum 2 characters to maximum 25 characters long."));
        assertTrue(localizedMessage
                .contains("Invalid product ID. It should start with character P followed by number."));
    }

    @Test
    public void shouldProductBeInvalidWhenNameIsTooShort() {
        // given
        Product product = getDefaultProduct();
        product.setName("");
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid product name. It should be minimum 3 characters to maximum 100 characters long."));
    }

    @Test
    public void shouldProductBeInvalidWhenNameIsTooLong() {
        // given
        Product product = getDefaultProduct();
        product.setName(RandomStringUtils.random(150));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid product name. It should be minimum 3 characters to maximum 100 characters long."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitPriceIsNull() {
        // given
        Product product = getDefaultProduct();
        product.setUnitPrice(null);
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Unit price is Invalid. It cannot be empty."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitPriceIsInvalid() {
        // given
        Product product = getDefaultProduct();
        product.setUnitPrice(new BigDecimal(123456789.123));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Unit price is Invalid. It can have maximum of 8 digit integer and 2 digit fraction."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitPriceIsNegative() {
        // given
        Product product = getDefaultProduct();
        product.setUnitPrice(new BigDecimal(-150));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Unit price is Invalid. It cannot have negative values."));
    }

    @Test
    public void shouldProductBeInvalidWhenDescriptionIsTooLong() {
        // given
        Product product = getDefaultProduct();
        product.setDescription(RandomStringUtils.random(251));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid product description. It should be maximum 250 characters long."));
    }

    @Test
    public void shouldProductBeInvalidWhenManufacturerIsTooShort() {
        // given
        Product product = getDefaultProduct();
        product.setManufacturer("fo");
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid manufacturer name. It should be minimum 3 characters to maximum 50 characters long."));
    }

    @Test
    public void shouldProductBeInvalidWhenManufacturerIsTooLong() {
        // given
        Product product = getDefaultProduct();
        product.setManufacturer(RandomStringUtils.random(51));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid manufacturer name. It should be minimum 3 characters to maximum 50 characters long."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitsInStockIsNegative() {
        // given
        Product product = getDefaultProduct();
        product.setUnitsInStock(-1);
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Units in stock must be 0 at least."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitsInStockIsTooMany() {
        // given
        Product product = getDefaultProduct();
        product.setUnitsInStock(1001);
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Units in stock must be 1000 at most."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitsInOrderIsNegative() {
        // given
        Product product = getDefaultProduct();
        product.setUnitsInOrder(-1);
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Units in order must be 0 at least."));
    }

    @Test
    public void shouldProductBeInvalidWhenUnitsInOrderIsTooMany() {
        // given
        Product product = getDefaultProduct();
        product.setUnitsInOrder(1001);
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Units in order must be 1000 at most."));
    }

    @Test
    public void shouldProductBeInvalidWhenConditionIsTooLong() {
        // given
        Product product = getDefaultProduct();
        product.setCondition(RandomStringUtils.random(51));
        BindException bindException = new BindException(product, "product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException
                .getLocalizedMessage()
                .contains("Invalid product condition. It should be maximum 50 characters long."));
    }

    @Test
    public void shouldProductBeValidWhenHaveCorrectData() {
        // given
        Product product = new Product();
        product.setProductId("P999");
        product.setName("foo");
        product.setUnitPrice(new BigDecimal(100));
        product.setDescription("foo");
        product.setManufacturer("foo");
        product.setCategory("Laptop");
        product.setUnitsInStock(10);
        product.setUnitsInOrder(10);
        product.setCondition("New");
        BindException bindException = new BindException(product, " product");

        // when
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        // then
        assertEquals(0, bindException.getErrorCount());
    }

    private Product getDefaultProduct() {
        Product product = new Product();
        product.setCategory("Laptop");
        product.setUnitPrice(new BigDecimal(10));
        return product;
    }
}
