package com.food.codechallenge.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Test Suite for All Services
 */

@RunWith(Suite.class)
@SuiteClasses({ TestCheckoutService.class, TestDummyService1.class, TestDummyService2.class })
public class TestSuite {
	
}
