package com.webstore.domain.repository;

import com.webstore.domain.Product;
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
public class SqlProductRepository implements ProductRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        HashMap<String, Object> params = new HashMap<>();
        return jdbcTemplate.query("SELECT * FROM PRODUCTS", params, new ProductMapper());
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", categoryName);
        return jdbcTemplate.query(sql, params, new ProductMapper());
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories) AND MANUFACTURER IN (:brands)";
        return jdbcTemplate.query(sql, filterParams, new ProductMapper());
    }

    @Override
    public Product getProductById(String productId) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", productId);
        return jdbcTemplate.queryForObject(sql, params, new ProductMapper());
    }

    @Override
    public void addProduct(Product newProduct) {
        String sql = "INSERT INTO PRODUCTS (ID, "
                + "NAME,"
                + "DESCRIPTION,"
                + "UNIT_PRICE,"
                + "MANUFACTURER,"
                + "CATEGORY,"
                + "CONDITION,"
                + "UNITS_IN_STOCK,"
                + "UNITS_IN_ORDER,"
                + "DISCONTINUED) "
                + "VALUES (:id, :name, :desc, :price, :manufacturer, :category," +
                " :condition, :inStock, :inOrder, :discontinued)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", newProduct.getProductId());
        params.put("name", newProduct.getName());
        params.put("desc", newProduct.getDescription());
        params.put("price", newProduct.getUnitPrice());
        params.put("manufacturer", newProduct.getManufacturer());
        params.put("category", newProduct.getCategory());
        params.put("condition", newProduct.getCondition());
        params.put("inStock", newProduct.getUnitsInStock());
        params.put("inOrder", newProduct.getUnitsInOrder());
        params.put("discontinued", newProduct.isDiscontinued());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void updateStock(String productId, long noOfUnits) {
        String sql = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("unitsInStock", noOfUnits);
        params.put("id", productId);
        jdbcTemplate.update(sql, params);
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
