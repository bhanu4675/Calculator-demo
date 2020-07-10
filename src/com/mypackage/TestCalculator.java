package com.mypackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculator {
	
	@Test
	public void testEmptyString() {
		assertEquals(0 , Calculator.add(""));
	}

}
