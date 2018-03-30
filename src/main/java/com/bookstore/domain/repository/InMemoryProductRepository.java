package com.bookstore.domain.repository;

import com.bookstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        HashMap<String, Object> params = new HashMap<>();
        return jdbcTemplate.query("SELECT * FROM PRODUCTS", params, new ProductMapper());
    }

    private class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product();
            product.setProductId(resultSet.getString("ID"));
            product.setName(resultSet.getString("NAME"));
            product.setDescription(resultSet.getString("DESCRIPTION"));
            product.setUnitPrice(resultSet.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(resultSet.getString("MANUFACTURER"));
            product.setCategory(resultSet.getString("CATEGORY"));
            product.setCondition(resultSet.getString("CONDITION"));
            product.setUnitsInStock(resultSet.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(resultSet.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(resultSet.getBoolean("DISCONTINUED"));
            return product;
        }
    }
}
