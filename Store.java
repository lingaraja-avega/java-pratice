package com.avega.training.pojo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.avega.training.dao.ProductDao;
import com.avega.training.daoImpl.ProductDaoImpl;
import com.avega.training.exception.InsufficientQuantityException;
import com.avega.training.exception.ProductNotFoundException;
import com.avega.training.util.DBUtil;

public class Store {
	public static Logger logger = Logger.getLogger(Store.class.getName());
	List<Product> listOfProducts;
	ProductDao productDao = new ProductDaoImpl();

	public Store() {

	}

	public Store(List<Product> listOfProducts) {
		super();
		this.listOfProducts = listOfProducts;
	}

	public List<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	@Override
	public String toString() {
		return "Store [listOfProducts=" + listOfProducts + "]";
	}

	public double sellItem(String productCode, int qtyRequired)
			throws SQLException, InsufficientQuantityException, ProductNotFoundException, IOException {
		double sellAmount = 0;
		boolean isProductAvaiable = false;
		for (Product prod : listOfProducts) {
			if (prod.getProductId().equalsIgnoreCase(productCode)) {
				isProductAvaiable = true;
				if (prod.getQuantityOnHand() >= qtyRequired) {
					sellAmount = prod.getPrice() * prod.getQuantityOnHand();
					prod.setQuantityOnHand(prod.getQuantityOnHand() - qtyRequired);
					productDao.updateProduct(DBUtil.getConnection(), prod);
					if (prod.getQuantityOnHand() <= 10) {
						uploadDatabaseToExcel("D:\\Test\\products.xlsx", prod);
						logger.info("Excell Sheet Updated");
					}

				} else
					throw new InsufficientQuantityException(
							prod.getProductName() + " quantity is lesser than requirement");
			}
		}
		if (!isProductAvaiable)
			throw new ProductNotFoundException("Product is not in store");
		return sellAmount;
	}

	public void updateStock(String productCode, int arrivedQty) throws ProductNotFoundException {
		boolean isAvaiable = false;
		for (Product prod : listOfProducts) {
			if (prod.getProductId().equalsIgnoreCase(productCode)) {
				isAvaiable = true;
				try {
					prod.setQuantityOnHand(prod.getQuantityOnHand() + arrivedQty);
					productDao.updateProduct(DBUtil.getConnection(), prod);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				logger.info("Stock succesfully updated");
			}
		}

		if (!isAvaiable)
			throw new ProductNotFoundException(productCode);
	}

	public void loadProductsToWordDocument(List<Product> products) {
		XWPFDocument document = new XWPFDocument();
		try (OutputStream fo = new FileOutputStream("D:\\Test\\first.docx")) {
			XWPFTable tab = document.createTable();
			XWPFTableRow row = tab.getRow(0);
			row.getCell(0).setText("Product Name");
			row.addNewTableCell().setText("Price");
			row.addNewTableCell().setText("Quantity on Hands");
			row.addNewTableCell().setText("Reorder Level");
			row.addNewTableCell().setText("Reorder Quantity");
			for (Product product : products) {
				row = tab.createRow();
				row.getCell(0).setText(product.getProductName());
				row.getCell(1).setText("" + product.getPrice());
				row.getCell(2).setText("" + product.getQuantityOnHand());
				row.getCell(3).setText("" + product.getReorderLevel());
				row.getCell(4).setText("" + product.getReorderQty());
			}
			document.write(fo);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void uploadDatabaseToExcel(String filePath, Product product) throws IOException {
		FileInputStream fn = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fn);
		Sheet sheet = workbook.getSheetAt(0);
		int count = sheet.getLastRowNum();
		Row row = sheet.createRow(count + 1);
		row.createCell(0).setCellValue(product.getProductId());
		row.createCell(1).setCellValue(product.getProductName());
		row.createCell(2).setCellValue(product.getPrice());
		row.createCell(3).setCellValue(product.getQuantityOnHand());
		row.createCell(4).setCellValue(product.getReorderLevel());
		row.createCell(5).setCellValue(product.getReorderQty());
		fn.close();
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
			fileOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
