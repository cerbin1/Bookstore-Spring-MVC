package com.webstore.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CartItemTest {
    @Test
    public void shouldPriceBeEqualToProductPriceInCaseOfSingleProduct() {
        // given
        Product product = new Product("1", "a1", new BigDecimal(500));
        CartItem cartItem = new CartItem("1");
        cartItem.setProduct(product);

        // when
        BigDecimal totalPrice = cartItem.getTotalPrice();

        // then
        assertEquals(new BigDecimal(500), totalPrice);
    }

    @Test
    public void shouldCountTotalPrice() {
        // given
        Product product = new Product("1", "a1", new BigDecimal(500));
        CartItem cartItem = new CartItem("1");
        cartItem.setProduct(product);
        cartItem.setQuantity(15);

        // when
        BigDecimal totalPrice = cartItem.getTotalPrice();

        // then
        assertEquals(new BigDecimal(7500), totalPrice);
    }
}
