package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {
	private KataStringCalculator ksc = new KataStringCalculator();
	@Test 
	public void ifStringIsEmptyReturnZero() {
		Assert.assertEquals(0, ksc.add(""));
	}
	@Test 
	public void ifStringContainsSingleNumberReturnNumber() {
		Assert.assertEquals(1, ksc.add("1"));
	}
	//@Test 
	//public void ifStringContainsTwoNumbersReturnSum() {
		//Assert.assertEquals(3, ksc.add("1,2"));
	//}
	@Test 
	public void ifStringContainsMultipleNumbersReturnSum() {
		Assert.assertEquals(24, ksc.add("5,7,12"));
	}
}
