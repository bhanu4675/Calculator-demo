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
	
	public static int add(String input) {
		if(input.isEmpty()) 
			return 0;
		
		Calculator cal;
		if(input.startsWith("//")) {
			String[] parts = input.split("\n",2);
			input = parts[1];
			cal = new Calculator(parts[0].substring(2),input);
		}else{
			cal = new Calculator(",|\n", input);
		}
		
		Stream<String> numbers = Arrays.stream(cal.numbers.split(cal.delimiter));
		return numbers.mapToInt(Integer::parseInt).sum();
		}
	

}


