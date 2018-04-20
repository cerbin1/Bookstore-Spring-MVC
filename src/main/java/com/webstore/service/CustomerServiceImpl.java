package com.webstore.service;

import com.webstore.domain.Customer;
import com.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public void addCustomer(Customer newCustomer) {
        customerRepository.addCustomer(newCustomer);
    }
}
