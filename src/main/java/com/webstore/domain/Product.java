package com.webstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@XmlRootElement
public class Product {
    @Size(max = 25, message = "{Size.Product.productId.validation}")
    @Pattern(regexp = "P[1-9]+", message = "{Pattern.Product.productId.validation}")
    private String productId;

    @Size(min = 3, max = 100, message = "{Size.Product.name.validation}")
    private String name;

    @Min(value = 0, message = "{Min.Product.unitPrice.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;

    @Size(max = 250, message = "{Size.Product.description.validation}")
    private String description;

    @Size(min = 3, max = 50, message = "{Size.Product.manufacturer.validation}")
    private String manufacturer;

    @Size(min = 3, max = 50, message = "{Size.Product.category.validation}")
    private String category;

    @Min(value = 0, message = "{Min.Product.unitsInStock.validation}")
    @Max(value = 1000, message = "{Max.Product.unitsInStock.validation}")
    private long unitsInStock;

    @Min(value = 0, message = "{Min.Product.unitsInOrder.validation}")
    @Max(value = 1000, message = "{Max.Product.unitsInOrder.validation}")
    private long unitsInOrder;

    private boolean discontinued;

    @Size(max = 50)
    private String condition;

    @JsonIgnore
    private MultipartFile productImage;
    @JsonIgnore
    private MultipartFile productManualFile;

    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Product(String productId, String name, BigDecimal unitPrice, String description, long unitsInStock) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.unitsInStock = unitsInStock;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    @XmlTransient
    public MultipartFile getProductManualFile() {
        return productManualFile;
    }

    public void setProductManualFile(MultipartFile productManualFile) {
        this.productManualFile = productManualFile;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (productId == null) {
            return other.productId == null;
        } else return productId.equals(other.productId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
}
