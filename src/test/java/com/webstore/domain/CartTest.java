package com.webstore.domain;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartTest {
    @Test
    public void shouldGetItemByProductId() {
        // given
        String productId = "123";
        Product product = new Product(productId, "1", new BigDecimal(123));

        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItemToFind = new CartItem("1");
        cartItemToFind.setProduct(product);
        cartItems.add(cartItemToFind);

        Cart cart = getDefaultCart();
        cart.setCartItems(cartItems);

        // when
        CartItem cartItem = cart.getItemByProductId(productId);

        // then
        assertEquals(cartItemToFind, cartItem);
    }

    @Test
    public void shouldReturnNullWhenItemByProductIdNotFound() {
        // given
        Cart cart = getDefaultCart();
        cart.setCartItems(new ArrayList<>());

        // when
        CartItem cartItem = cart.getItemByProductId("123");

        // then
        assertNull(cartItem);
    }

    @Test
    public void shouldUpdateTotalPriceOfCartItems() {
        // given
        List<CartItem> cartItems = getCartItemWithProducts();
        Cart cart = getDefaultCart();
        cart.setCartItems(cartItems);

        // when
        BigDecimal grandTotal = cart.getGrandTotal();

        // then
        assertEquals(new BigDecimal(3500), grandTotal);

    }

    private List<CartItem> getCartItemWithProducts() {
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartITem1 = new CartItem("1");
        cartITem1.setProduct(new Product("1", "a1", new BigDecimal(500)));
        CartItem cartITem2 = new CartItem("2");
        cartITem2.setProduct(new Product("2", "a2", new BigDecimal(1000)));
        CartItem cartITem3 = new CartItem("3");
        cartITem3.setProduct(new Product("3", "a3", new BigDecimal(2000)));
        cartItems.add(cartITem1);
        cartItems.add(cartITem2);
        cartItems.add(cartITem3);
        return cartItems;
    }

    private Cart getDefaultCart() {
        return new Cart("1");
    }
}
