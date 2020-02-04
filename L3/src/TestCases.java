import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCases {

	//Switch which line is commented out in order to test the correct vs broken code
	//TestingFunctions functions = new BlackBoxCorrect();
	//TestingFunctions functions = new BlackBoxIncorrect();
	TestingFunctions functions = new MyFunctions();
	
	/**
	 * This is a simple validity check for the method greatestCommonDivisor. Checks that the method
	 * returns the correct result for a known GCD problem gcd(2,4) = 2
	 */
	@Test
	public void testGCD() {
		assertEquals("Error: should return 2", 2, functions.greatestCommonDivisor(2, 4));
	}
	
	
	/**
	 * This is a simple check of the reverseWindow method. Checks if the method will reverse the entire contents
	 * of the passed array correctly.
	 */
	@Test
	public void testReverseWindow() {
		int[] array = {1,2,3,4,5,6};
		int[] swapArray = {1,5,4,3,2,6};
		
		functions.reverseWindow(array, 1, 5);
		
		assertArrayEquals(array, swapArray, "Error: Swapped Array is not the expected array");
	}
	
	@Test
	public void testReverseWindowOdd() {
		int[] array = {1,2,3,4,5,6};
		int[] swapArray = {1,2,5,4,3,6};
		
		functions.reverseWindow(array, 2, 5);
		
		assertArrayEquals(array, swapArray, "Error: Swapped Array is not the expected array");
	}

	//For completion, write additonal tests as described in the lab documentation.
	
	@Test
	public void testGCDFirstNeg()
	{
		assertEquals("Error: a negative arguement is present.", -1, functions.greatestCommonDivisor(-1, 8));
	} 
	
	@Test
	public void testGCDSecondNeg()
	{
		assertEquals("Error: a negative arguement is present.", -1, functions.greatestCommonDivisor(1, -8));
	} 
	
	@Test
	public void testGCDMultipleFactors()
	{
		assertEquals("Error: should return 6", 6, functions.greatestCommonDivisor(6, 12374382));
	}
	
	@Test
	public void testReverseWindowFlippedIndex() {
		
		int[] array = {1,2,3,4,5,6};
		int[] swapArray = {1,5,4,3,2,6};
		
		functions.reverseWindow(array, 5, 1);
		
		
		assertArrayEquals(array, swapArray, "Error: Swapped Array is not the expected array");
	}
	
	@Test
	public void testGCDNoFactors()
	{
		assertEquals("Error: should return 1", 1, functions.greatestCommonDivisor(3, 5));
	}
	
	@Test
	public void testGCDSameNum()
	{
		assertEquals("Error: should return 11", 11, functions.greatestCommonDivisor(11, 11));
	}
	
	@Test
	public void testGCDZero()
	{
		assertEquals("Error: should return 11", 11, functions.greatestCommonDivisor(0, 11));
	}
}



