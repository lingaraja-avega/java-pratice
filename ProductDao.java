package com.avega.training.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.avega.training.pojo.Product;

public interface ProductDao {

	List<Product> getAllProducts(Connection connection) throws SQLException;

	Product getProductById(Connection connection, String productId) throws SQLException;

	boolean addProduct(Connection connection, Product product) throws SQLException;

	boolean deleteProduct(Connection connection, String productId) throws SQLException;

	boolean updateProduct(Connection connection, Product product) throws SQLException;
}
