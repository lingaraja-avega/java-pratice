package com.avega.training.client;

import java.io.IOException;
import java.sql.SQLException;

import com.avega.training.exception.InsufficientQuantityException;
import com.avega.training.exception.ProductNotFoundException;
import com.avega.training.pojo.Store;
import com.avega.training.service.ProductService;
import com.avega.training.serviceImpl.ProductServiceImpl;

public class TestClient {

	public static void main(String[] args) throws SQLException, InsufficientQuantityException, ProductNotFoundException, IOException {

		ProductService productService = new ProductServiceImpl();
		Store store = new Store();
		store.setListOfProducts(productService.findAllProducts());
//		store.updateStock("P103", 30);
//		store.sellItem("P102", 20);
		
		
		

	}
}
