package com.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private static final long serialVersionUID = -4546941350577482213L;
    private String id;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    BigDecimal getTotalPrice() {
        updateTotalPrice();
        return totalPrice;
    }

    private void updateTotalPrice() {
        totalPrice = product.
                getUnitPrice()
                .multiply(new BigDecimal(quantity));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 :
                id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItem other = (CartItem) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
