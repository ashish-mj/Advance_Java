package com.rakuten.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rakuten.domain.Product;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.rakuten.service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
        return service.findAll();
}
}
