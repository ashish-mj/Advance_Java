package com.rakuten.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rakuten.dal.ProductDAOInMemImpl;
import com.rakuten.domain.Product;

class ProductServiceImplTest {

	private static final int MIN_PRODUCT_VALUE = 10000;

	@Test
	void testAddProduct() {
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product p = new Product ("Test",MIN_PRODUCT_VALUE,1);
		
		ProductDAOInMemImpl dao = new ProductDAOInMemImpl();
		objectUnderTest.setDao(dao);
		
		int id = objectUnderTest.addProduct(p);
		
		assertTrue(id>0);
		
	}

}
