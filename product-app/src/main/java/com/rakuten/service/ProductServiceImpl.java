package com.rakuten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.dal.ProductDAO;
import com.rakuten.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	ProductDAO dao ;
	
	
	
	public ProductDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Product added = dao.save(toBeAdded);
			return added.getId();
		}else {
			throw new IllegalArgumentException("Product Value must be GTEQ 10k");
		}
	}
	
	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		
		if(existing.getPrice() * existing.getQoh() < 100000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product worth more than 100k, can't just be deleted!");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	
	
}
