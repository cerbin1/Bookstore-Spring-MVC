package com.bookstore.domain.repository;

import com.bookstore.domain.Customer;
import com.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    @Autowired
    private CustomerService customerService;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("c145", "John", "Sunny St. 198", 12));
        customers.add(new Customer("c76", "Roger", "Long St. 1", 8));
        customers.add(new Customer("c12", "Ann", "Petersburg St. 154", 1));
        customers.add(new Customer("c215", "Melisande", "Bakery St. 15", 3));
        return customers;
    }
}
