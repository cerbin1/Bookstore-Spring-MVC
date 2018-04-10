package com.webstore.domain;

public class Customer {
    private String customerId;
    private String name;
    private String surname;
    private String address;
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
