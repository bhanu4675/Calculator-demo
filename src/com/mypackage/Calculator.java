package com.mypackage;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {
	
	private String delimiter;
	private String numbers;
	
	private Calculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}
	
	private int sum() {
		return Arrays.stream(numbers.split(delimiter))
				.mapToInt(Integer::parseInt)
				.sum();
	}
	
	
	public static int add(String input) {
		if(input.isEmpty()) 
			return 0;
		
		return parseInt(input).sum();
		
	}

	private static Calculator parseInt(String input) {
		
		if(input.startsWith("//")) {
			String[] parts = input.split("\n",2);
			input = parts[1];
			return new Calculator(parts[0].substring(2),input);
		}else{
			return new Calculator(",|\n", input);
		}
	}
	

}


