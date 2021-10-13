package com.rakuten.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.domain.Product;
import com.rakuten.service.ProductService;
import com.rakuten.service.ProductServiceImpl;


@Component
public class ProductConsoleUI {
	
	ProductService service;
	
	
	public ProductService getService() {
		return service;
	}

    @Autowired
	public void setService(ProductService service) {
		this.service = service;
	}


	public void createProductWithUI() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter a name:");
		String name = kb.nextLine();
		System.out.println("Enter a price:");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter a QoH:");
		int qoh = Integer.parseInt(kb.nextLine());
		
		Product p = new Product(name, price, qoh);
		int id = service.addProduct(p);
		
		System.out.println("Created Product with ID: "+id);
		kb.close();
		
	}

}
