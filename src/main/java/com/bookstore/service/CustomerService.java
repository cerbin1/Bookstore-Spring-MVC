package com.bookstore.service;

import com.bookstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(String customerId);
}
