package com.rakuten.dal;

import java.util.List;

import com.rakuten.domain.Product;

public interface ProductDAO {
	
	public Product save(Product toBeSaved);
	public Product findById(int id);
	public List<Product> findAll();
	public void deleteById(int id);

}
