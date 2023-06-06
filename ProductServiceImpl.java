package com.avega.training.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.avega.training.dao.ProductDao;
import com.avega.training.daoImpl.ProductDaoImpl;
import com.avega.training.pojo.Product;
import com.avega.training.service.ProductService;
import com.avega.training.util.DBUtil;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoImpl();
	Connection connection = DBUtil.getConnection();

	@Override
	public List<Product> findAllProducts() throws SQLException {
		return productDao.getAllProducts(connection);
	}

	@Override
	public Product findProductById(String productId) throws SQLException {
		return productDao.getProductById(connection, productId);
	}

	@Override
	public boolean addProduct(Product product) throws SQLException {
		return productDao.addProduct(connection, product);
	}

	@Override
	public boolean deleteProduct(String productId) throws SQLException {
		return productDao.deleteProduct(connection, productId);
	}

	@Override
	public boolean updateProduct(Product product) throws SQLException {
		return productDao.updateProduct(connection, product);
	}


	

}
