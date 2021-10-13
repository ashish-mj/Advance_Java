package com.rakuten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = SpringApplication.run(ProductAppApplication.class, args);
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		ui.createProductWithUI();
	}

}
