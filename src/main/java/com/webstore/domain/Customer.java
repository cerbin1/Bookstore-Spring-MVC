package com.webstore.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
    @Pattern(regexp = "[A-Z][1-9]+", message = "{Pattern.Customer.customerId.validation}")
    @Size(max = 25, message = "{Pattern.Customer.customerId.validation}")
    private String customerId;

    @Size(min = 3, max = 50, message = "{Size.Customer.name.validation}")
    private String name;

    @Size(min = 3, max = 50, message = "{Size.Customer.surname.validation}")
    private String surname;

    @Size(min = 3, max = 150, message = "{Size.Customer.address.validation}")
    private String address;

    @Min(value = 0, message = "{Min.Customer.noOfOrders.validation}")
    private int noOfOrders;

    public Customer(String customerId, String name, String address, int noOfOrders) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.noOfOrders = noOfOrders;
    }

    public Customer() {

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }
}
