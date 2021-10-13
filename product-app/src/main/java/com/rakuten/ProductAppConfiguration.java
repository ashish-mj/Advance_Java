package com.rakuten;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rakuten.dal.ProductDAO;
import com.rakuten.dal.ProductDAOInMemImpl;
import com.rakuten.service.ProductService;
import com.rakuten.service.ProductServiceImpl;
import com.rakuten.ui.ProductConsoleUI;

@Configuration
public class ProductAppConfiguration {
	
	@Bean
	public ProductDAO daoObj() {
		ProductDAOInMemImpl dao = new ProductDAOInMemImpl();
		return dao;
	}
	
	@Bean
	public ProductService serviceObj() {
		ProductServiceImpl service = new ProductServiceImpl();
		service.setDao(daoObj());
		return service;
	}
	
	@Bean
	public ProductConsoleUI uiObj() {
		ProductConsoleUI ui = new ProductConsoleUI();
		ui.setService(serviceObj());
		return ui;
	}

}
