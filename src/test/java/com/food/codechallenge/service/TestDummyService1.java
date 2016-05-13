package com.food.codechallenge.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for TestDummyService2.
 */
public class TestDummyService1 {
	
	  @BeforeClass
	  public static void init() throws Exception {
	    System.out.println("\nSetting up TestDummyService1...");
	  }
	 

	 
	  @Before
	  public void beforeTest() throws Exception {
	    System.out.println("  beforeTest()...");
	  }

	  
	  @Test
	  public void dummyMethod() {
		System.out.println("    Runnnig test => dummyMethod() ...");
	    assertTrue(new DummyService1().dummyMethod(true));
	    assertFalse(new DummyService1().dummyMethod(false));
	  }
 
	  @After
	  public void afterTest() throws Exception {
	    System.out.println("  afterTest()...");
	  }		  
	  
	  @AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("Tearing down TestDummyService1...\n");
	  }
  
}
