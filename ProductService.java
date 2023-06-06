package com.avega.training.service;

import java.sql.SQLException;
import java.util.List;

import com.avega.training.pojo.Product;

public interface ProductService {

	List<Product> findAllProducts() throws SQLException;

	Product findProductById(String productId) throws SQLException;

	boolean addProduct(Product product) throws SQLException;

	boolean deleteProduct(String productId) throws SQLException;

	boolean updateProduct(Product product) throws SQLException;

}
