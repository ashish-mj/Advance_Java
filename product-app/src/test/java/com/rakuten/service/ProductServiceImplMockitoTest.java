package com.rakuten.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rakuten.dal.ProductDAO;
import com.rakuten.domain.Product;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplMockitoTest {
     
	@Mock
	ProductDAO mockDAO;
	
	private static final int MIN_PRODUCT_VALUE = 10_000;
	private static final int DELETION_THRESHOLD = 100_000;
	@Test
	void addProduct_Returns_Valid_Id_When_ProductValue_GTEQ_MinVal() {
		//AAA
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		Product argToTestMethod = new Product("test", MIN_PRODUCT_VALUE, 1);
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		Product dataReturnedByMock = new Product("test", MIN_PRODUCT_VALUE, 1);
		dataReturnedByMock.setId(1);
		Mockito.when(mockDAO.save(argToTestMethod)).thenReturn(dataReturnedByMock);
		objectUnderTest.setDao(mockDAO);
		
		//Act
		int id = objectUnderTest.addProduct(argToTestMethod);
		//Assert
		assertTrue(id > 0);
	}

	@Test
	void removeExisting_Calls_DeleteById_When_ProductValue_LT_DeletionThreshold() {
		//Arrange
		ProductServiceImpl objectUnderTest = new ProductServiceImpl();
		int id = 1;
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		Product dataReturned = new Product("test", DELETION_THRESHOLD - 1, 1);
		Mockito.when(mockDAO.findById(id)).thenReturn(dataReturned);
		objectUnderTest.setDao(mockDAO);
		//Act
		objectUnderTest.removeExisting(id);
		//Assert
		Mockito.verify(mockDAO).deleteById(id);
	}
	

}
