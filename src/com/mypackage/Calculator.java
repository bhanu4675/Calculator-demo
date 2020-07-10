package com.mypackage;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {
	
	public static int add(String input) {
		if(input.isEmpty()) 
			return 0;
		
		Stream<String> numbers = Arrays.stream(input.split(",|\n"));
		return numbers.mapToInt(Integer::parseInt).sum();
		}
	

}

