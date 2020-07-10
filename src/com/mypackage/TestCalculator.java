package com.mypackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculator {
	
	@Test
	public void testEmptyString() {
		assertEquals(0 , Calculator.add(""));
	}
	
	@Test 
	public void testSingleNumber() {
		assertEquals(1 , Calculator.add("1"));
	}
	
	@Test
	public void testSumOfTwoNumbersByComma() {
		assertEquals(5 , Calculator.add("2,3"));
	}
	
	@Test
	public void testSumOfThreeNumbersByComma() {
		assertEquals(6 , Calculator.add("1,2,3"));
	}
	
	@Test
	public void testSumDelimitedByNewLine() {
		assertEquals(3 , Calculator.add("1\n2"));
	}
	
	@Test
	public void testSumDelimitedByCommaAndNewLine() {
		assertEquals(6 , Calculator.add("1\n2,3"));
	}
	
	@Test
	public void testSpecifiedDelimiter() {
		assertEquals(3 , Calculator.add("//;\n1;2"));
	}
	
	@Test
	public void testSpecifiedDelimiterByUnderscore() {
		assertEquals(6 , Calculator.add("//_\n1_2_3"));
	}
	
	

}
