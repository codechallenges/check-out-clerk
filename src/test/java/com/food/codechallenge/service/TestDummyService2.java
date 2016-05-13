package com.food.codechallenge.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for TestDummyService2.
 */
public class TestDummyService2 {
	
	  @BeforeClass
	  public static void init() throws Exception {
	    System.out.println("\nSetting up TestDummyService2...");
	  }
	 

	 
	  @Before
	  public void beforeTest() throws Exception {
	    System.out.println("  beforeTest()...");
	  }

	  @Test
	  public void dummyMethod() {
		System.out.println("    Runnnig test => dummyMethod() ...");		  
	    assertTrue(new DummyService2().dummyMethod(true));
	    assertFalse(new DummyService2().dummyMethod(false));
	  }

	  @After
	  public void afterTest() throws Exception {
	    System.out.println("  afterTest()...");
	  }		  
	  
	  @AfterClass
	  public static void destroy() throws Exception {
	    System.out.println("Tearing down TestDummyService2...\n");
	  }
  
}
