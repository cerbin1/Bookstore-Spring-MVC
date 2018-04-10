package com.webstore.service;

import com.webstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(String customerId);

    void addCustomer(Customer newCustomer);
}
