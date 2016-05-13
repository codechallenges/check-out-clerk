package com.food.codechallenge.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.food.codechallenge.model.Product;
import com.food.codechallenge.model.Receipt;

/**
 * Unit tests for TestCheckoutService.
 */
public class TestCheckoutService {
	
	  private static CheckoutService service;
	  private static List<Product> productList; 
	  
	  @BeforeClass
	  public static void init() throws Exception {
	    System.out.println("\nSetting up TestCheckoutService...");
	    service = new CheckoutService();

	    productList = new ArrayList<Product>();
		productList.add(new Product("111", "iPhone", 10.00, 3, 25.00)); 
		productList.add(new Product("222", "iPad", 20.00, 4, 70.00));
		productList.add(new Product("333", "iMac", 30.00, 5, 135.00));
		service.setPricing(productList);
	  }
 
	  @Before
	  public void beforeTest() throws Exception {
	    System.out.println("  beforeTest()...");
	  }

	  
	  @Test
	  public void testSetPricing() {
	    System.out.println("    Runnnig test => testSetPricing() ...");
    
		for(Product product : productList) {
			assertNotNull(service.getProductsCache().get(product.getProductCode()));
		}
	  }

	  @Test
	  public void testScanSucess() {
	    System.out.println("    Runnnig test => testScanSucess() ...");
	    
	    
		for(Product product : productList) {
			assertEquals("SCAN SUCCESS", service.scan(product.getProductCode()));
		}
	  }
	  
	  @Test
	  public void testScanFailure() {
	    System.out.println("    Runnnig test => testScanFailure() ...");
	    assertThat(service.scan("junk code"), CoreMatchers.containsString("SCAN ERROR"));
	  }	 
	  
	  @Test
	  public void testPrintReceiptNotNull() {
		System.out.println("    Runnnig test => testPrintReceipt() ...");	
		service.scan("111");
		service.scan("222");
		service.scan("333");		  
	    assertNotNull(service.getReceipt());
	  }
	  
	  @Test
	  public void testAggregation1() {
		System.out.println("    Runnnig test => testAggregation1() ...");
		service.scan("111");
		service.scan("222");
		service.scan("333");
		Receipt receipt = service.getReceipt();
	    assertEquals(3, receipt.getLineItems().size());
	    assertEquals(3, receipt.getItemsCount());
	    assertEquals(60.0, receipt.getTotalAmount(), 0.0);
	  }	 
	  
	  @Test
	  public void testAggregation2() {
		System.out.println("    Runnnig test => testAggregation2() ...");
		service.scan("111");
		service.scan("111");
		Receipt receipt = service.getReceipt();
		assertEquals(1, receipt.getLineItems().size());
	    assertEquals(2, receipt.getItemsCount());
	    assertEquals(20.0, receipt.getTotalAmount(), 0.0);
	  }

	  @Test
	  public void testAggregation3() {
		System.out.println("    Runnnig test => testAggregation3() ...");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		Receipt receipt = service.getReceipt();
		assertEquals(1, receipt.getLineItems().size());
	    assertEquals(3, receipt.getItemsCount());
	    assertEquals(25.0, receipt.getTotalAmount(), 0.0);
	  }
	  
 
	  @Test
	  public void testAggregation4() {
		System.out.println("    Runnnig test => testAggregation4() ...");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		Receipt receipt = service.getReceipt();
		assertEquals(2, receipt.getLineItems().size());
	    assertEquals(4, receipt.getItemsCount());
	    assertEquals(35.0, receipt.getTotalAmount(), 0.0);
	  }
	  
	  
	  @Test
	  public void testAggregation5() {
		System.out.println("    Runnnig test => testAggregation5() ...");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		Receipt receipt = service.getReceipt();
		assertEquals(2, receipt.getLineItems().size());
	    assertEquals(5, receipt.getItemsCount());
	    assertEquals(45.0, receipt.getTotalAmount(), 0.0);
	  }	  
	  
	  @Test
	  public void testAggregation6() {
		System.out.println("    Runnnig test => testAggregation6() ...");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		service.scan("111");
		Receipt receipt = service.getReceipt();
		assertEquals(3, receipt.getLineItems().size());
	    assertEquals(7, receipt.getItemsCount());
	    assertEquals(60.0, receipt.getTotalAmount(), 0.0);
	  }	  
	  
	  @After
	  public void afterTest() throws Exception {
	    System.out.println("  afterTest()...");
	    service.setReceipt(null);
	  }
	  
	  @AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("Tearing down TestCheckoutService...\n");
	    service = null;
	    productList = null;
	  }
}
