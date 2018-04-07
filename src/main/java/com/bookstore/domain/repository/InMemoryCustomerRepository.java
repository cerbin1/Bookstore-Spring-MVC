package com.bookstore.domain.repository;

import com.bookstore.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM CUSTOMERS", new CustomerMapper());
    }

    @Override
    public Customer getCustomerById(String customerId) {
        String sql = "SELECT * FROM CUSTOMERS WHERE ID = :customerId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        return jdbcTemplate.queryForObject(sql, params, new CustomerMapper());
    }

    private class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("ID"));
            customer.setName(resultSet.getString("NAME"));
            customer.setAddress(resultSet.getString("ADDRESS"));
            customer.setNoOfOrders(resultSet.getInt("ORDERS_COUNT"));
            return customer;
        }
    }
}
