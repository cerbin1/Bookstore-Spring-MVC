package com.bookstore.domain.repository;

import com.bookstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();

    Customer getCustomerById(String customerId);
}
