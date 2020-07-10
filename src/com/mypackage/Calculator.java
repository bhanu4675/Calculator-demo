package com.mypackage;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {
	
	private String delimiter;
	private String numbers;
	
	private Calculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}
	
	private int sum() {
		ensureNonNegativeNumbers();
		return getNumber().sum();
	}
	
	private void ensureNonNegativeNumbers() {
		// TODO Auto-generated method stub
		String negativeNumberSequence = getNumber().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if(!negativeNumberSequence.isEmpty()) {
			throw new IllegalArgumentException("Negative number : " + negativeNumberSequence);
		}
	}

	private IntStream getNumber() {
		
		if(numbers.isEmpty()) {
			return IntStream.empty();
		}else {
			return Stream.of(numbers.split(delimiter))
				.mapToInt(Integer::parseInt).map(n -> n % 1000);
		}
	}
	
	
	public static int add(String input) {
		
		return parseInt(input).sum();
	}

	private static Calculator parseInt(String input) {
		
		if(input.startsWith("//")) {
			String[] parts = input.split("\n",2);
			input = parts[1];
			return new Calculator(parts[0].substring(2),parts[1]);
		}else{
			return new Calculator(",|\n", input);
		}
	}
	

}
