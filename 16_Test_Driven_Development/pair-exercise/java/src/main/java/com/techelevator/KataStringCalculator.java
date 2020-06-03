package com.techelevator;

public class KataStringCalculator {
	public int add(String numbers) {
		int result = 0;
		int sum = 0;
		if (!numbers.equals("")) {
	
		if (!numbers.contains(",")) {
			result = Integer.parseInt(numbers);
		}
		else {
			String[] numberArray = numbers.split("\\,");
			for (int i = 0; i < numberArray.length; i++) {
			  sum += Integer.parseInt(numberArray[i]); 
			  result = sum;
			}
			
			//result = Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
			}
		}
		return result;
	}
	
}
