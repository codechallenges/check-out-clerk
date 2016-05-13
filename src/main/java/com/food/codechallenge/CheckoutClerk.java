package com.food.codechallenge;

import java.util.ArrayList;
import java.util.List;

import com.food.codechallenge.model.Product;
import com.food.codechallenge.service.CheckoutService;

public class CheckoutClerk {

	/**
	 * @param args
	 */
	
	private static CheckoutService service;
	
	public static void main(String[] args) {
		
		initApp(); // app started; products loaded into the memory
		
		service.scan("000");
		service.scan("222");
		service.scan("111");
		service.scan("111");
		service.scan("111");

		service.scan("222");
		service.scan("333");
		service.scan("111");
		service.scan("111");
		service.scan("333");
		
		service.printReceipt();
		
	}

	private static void initApp() {
		service = new CheckoutService();
		service.setPricing(getTestProducts());
	}

	private static List<Product> getTestProducts() {
		//Creating test data
		List<Product> productList = new ArrayList<Product>();
			productList.add(new Product("111", "iPhone", 10.00, 3, 25.00)); 
			productList.add(new Product("222", "iPad", 20.00, 4, 70.00));
			productList.add(new Product("333", "iMac", 30.00, 5, 135.00));
		return productList;
	}
}










