package com.webstore.domain.repository;

import com.webstore.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SqlCustomerRepository implements CustomerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SqlCustomerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public void addCustomer(Customer newCustomer) {
        String sql = "INSERT INTO CUSTOMERS ("
                + "ID, "
                + "NAME,"
                + "SURNAME,"
                + "ADDRESS,"
                + "NO_OF_ORDERS) "
                + "VALUES (:id, :name, :surname, :address, :noOfOrders)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", newCustomer.getCustomerId());
        params.put("name", newCustomer.getName());
        params.put("surname", newCustomer.getSurname());
        params.put("address", newCustomer.getAddress());
        params.put("noOfOrders", newCustomer.getNoOfOrders());
        jdbcTemplate.update(sql, params);
    }

    private class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("ID"));
            customer.setName(resultSet.getString("NAME"));
            customer.setSurname(resultSet.getString("SURNAME"));
            customer.setAddress(resultSet.getString("ADDRESS"));
            customer.setNoOfOrders(resultSet.getInt("NO_OF_ORDERS"));
            return customer;
        }
    }
}
