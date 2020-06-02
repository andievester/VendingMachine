package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {
	KataStringCalculator stringCalculatorTest = new KataStringCalculator();
	
	@Test
	Assert.assertEquals(0, stringCalculatorTest.add(""));
	@Test
	Assert.assertEquals(1, )
}
