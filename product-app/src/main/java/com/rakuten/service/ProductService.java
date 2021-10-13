package com.rakuten.service;

import java.util.List;

import com.rakuten.domain.Product;


public interface ProductService {

	int addProduct(Product toBeAdded);

	void removeExisting(int id);

	Product findById(int id);

	List<Product> findAll();

}
