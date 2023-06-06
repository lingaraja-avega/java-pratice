package com.avega.training.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.avega.training.dao.ProductDao;
import com.avega.training.pojo.Product;

public class ProductDaoImpl implements ProductDao {
	PreparedStatement ps = null;

	@Override
	public List<Product> getAllProducts(Connection connection) throws SQLException {
		String query = "SELECT * FROM product";
		ps = connection.prepareStatement(query);
		List<Product> products = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Product product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			products.add(product);
		}
		return products;
	}

	@Override
	public Product getProductById(Connection connection, String productId) throws SQLException {
		String query = "SELECT * FROM product WHERE product_id = ?";
		ps = connection.prepareStatement(query);
		ps.setString(1, productId);
		ResultSet rs = ps.executeQuery();
		Product product = null;
		while (rs.next()) {
			product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		}
		return product;

	}

	@Override
	public boolean addProduct(Connection connection, Product product) throws SQLException {
		String query = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?)";
		boolean isProduct = false;
		ps = connection.prepareStatement(query);
		ps.setString(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setDouble(3, product.getPrice());
		ps.setInt(4, product.getQuantityOnHand());
		ps.setInt(5, product.getReorderLevel());
		ps.setInt(6, product.getReorderQty());
		int count = ps.executeUpdate();
		if (count > 0)
			isProduct = true;
		return isProduct;
	}

	@Override
	public boolean deleteProduct(Connection connection, String productId) throws SQLException {
		String query = "DELETE FROM product WHERE product_id = ?";
		boolean isDelete = false;
		ps = connection.prepareStatement(query);
		ps.setString(1, productId);
		int count = ps.executeUpdate();
		if (count > 0) {
			isDelete = true;
		}
		return isDelete;
	}

	@Override
	public boolean updateProduct(Connection connection, Product product) throws SQLException {
		String query = "UPDATE product SET product_name = ?, price = ?, "
				+ "qty_on_hand = ?, reorder_level = ?, reorder_qty = ? WHERE product_id = ?";
		ps = connection.prepareStatement(query);
		boolean isUpdate = false;
		ps.setString(1, product.getProductName());
		ps.setDouble(2, product.getPrice());
		ps.setInt(3, product.getQuantityOnHand());
		ps.setInt(4, product.getReorderLevel());
		ps.setInt(5, product.getReorderQty());
		ps.setString(6, product.getProductId());
		int count = ps.executeUpdate();
		if (count > 0)
			isUpdate = true;
		return isUpdate;
	}

}
