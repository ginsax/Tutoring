package challenge_FizzBuzz;

import static org.junit.Assert.*;

import org.junit.Test;

import challenge_FizzBuzz.FizzBuzzAnalyzer_Difficult;
import challenge_FizzBuzz.FizzBuzzObject;

public class FizzBuzzTest_Difficult {
	final String messageDefault = "No Response";
	private FizzBuzzAnalyzer_Difficult mFizzBuzzAnalyzer;
	
	
	/**
	 * Tests that the number 1 (one) is the lowest lower bounds possible.
	 */
	@Test
	public void test_One_IsLowestLowerBounds() {
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		final int expected = 1;
		final int actual = mFizzBuzzAnalyzer.getBoundsLower();
		assertEquals("Tests that the number 1 (one) is the lowest bounds possible.", expected, actual);
	}
	/**
	 * Tests that the number 1000 (one thousand) is the highest lower bounds possible.
	 */
	@Test
	public void test_OneThousand_IsHighestLowerBounds() {
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		final int expected = 1000;
		final int actual = mFizzBuzzAnalyzer.getBoundsLower();
		assertEquals("Tests that the number 1000 (one thousand) is the highest lower bounds possible.", expected, actual);
	}
	/**
	 * Tests that the number 1 (one) is the lowest upper bounds possible.
	 */
	@Test
	public void test_One_IsLowestUpperBounds() {
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, Integer.MIN_VALUE);
		
		final int expected = 1;
		final int actual = mFizzBuzzAnalyzer.getBoundsUpper();
		assertEquals("Tests that the number 1 (one) is the lowest upper bounds possible.", expected, actual);
	}
	/**
	 * Tests that the number 1000 (one thousand) is the highest upper bounds possible.
	 */
	@Test
	public void test_OneThousand_IsHighestUpperBounds() {
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		final int expected = 1000;
		final int actual = mFizzBuzzAnalyzer.getBoundsUpper();
		assertEquals("Tests that the number 1000 (one thousand) is the highest upper bounds possible.", expected, actual);
	}
	
	/**
	 * Tests that a FizzBuzzObject with a value of 1 will return 'Fizz' repeated 1000 times.
	 */
	@Test
	public void test_OneThousandIterations() {
		final FizzBuzzObject fizzBuzzObject = new FizzBuzzObject(1, "Fizz");
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		String expected = fizzBuzzObject.getMessage();
		
		for(int i = 1; i < 1000; i++) {
			expected += fizzBuzzObject.getMessage();
		}
		
		final String actual = mFizzBuzzAnalyzer.analyze(fizzBuzzObject);
		assertEquals("Tests that a FizzBuzzObject with a value of 1 will return \"Fizz\" repeated 1000 times.", expected, actual);
	}
	/**
	 * Tests that FizzBuzzObject[1, 'Fizz'] & FizzBuzzObject[2, 'Buzz']  return correctly.
	 */
	@Test
	public void test_TwoObjects_1Fizz_2Buzz() {
		final FizzBuzzObject fizzBuzzObject_a = new FizzBuzzObject(1, "Fizz");
		final FizzBuzzObject fizzBuzzObject_b = new FizzBuzzObject(2, "Buzz");
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, 10);
		
		final String expected = "FizzFizzBuzzFizzFizzBuzzFizzFizzBuzzFizzFizzBuzzFizzFizzBuzz";
		
		final String actual = mFizzBuzzAnalyzer.analyze(fizzBuzzObject_a, fizzBuzzObject_b);
		assertEquals("Tests that FizzBuzzObject[1, 'Fizz'] & FizzBuzzObject[2, 'Buzz']  return correctly.", expected, actual);
	}
	/**
	 * Tests that FizzBuzzObject[1, 'Fizz'] & FizzBuzzObject[2, 'Buzz']  sort & return correctly.
	 */
	@Test
	public void test_TwoObjects_2Buzz_1Fizz() {
		final FizzBuzzObject fizzBuzzObject_a = new FizzBuzzObject(1, "Fizz");
		final FizzBuzzObject fizzBuzzObject_b = new FizzBuzzObject(2, "Buzz");
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, 10);
		
		final String expected = "FizzFizzBuzzFizzFizzBuzzFizzFizzBuzzFizzFizzBuzzFizzFizzBuzz";
		
		final String actual = mFizzBuzzAnalyzer.analyze(fizzBuzzObject_b, fizzBuzzObject_a);
		assertEquals("Tests that FizzBuzzObject[1, 'Fizz'] & FizzBuzzObject[2, 'Buzz']  return correctly.", expected, actual);
	}
	
	/**
	 * Tests that 2 similar objects sort together & return correctly.
	 */
	@Test
	public void test_2SimilarObjects() {
		final FizzBuzzObject fizzBuzzObject_a = new FizzBuzzObject(1, "Dude");
		final FizzBuzzObject fizzBuzzObject_b = new FizzBuzzObject(1, "Dude");
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, 5);
		
		final String expected = "DudeDudeDudeDudeDudeDudeDudeDudeDudeDude";
		final String actual = mFizzBuzzAnalyzer.analyze(fizzBuzzObject_a, 
														fizzBuzzObject_b);
		assertEquals("Tests that 2 similar objects sort together & return correctly.", expected, actual);
	}
	/**
	 * Tests that 6 FizzBuzzObjects sort & return correctly.
	 */
	@Test
	public void test_6Objects() {
		final FizzBuzzObject fizzBuzzObject_a = new FizzBuzzObject(550, "I");
		final FizzBuzzObject fizzBuzzObject_b = new FizzBuzzObject(220, "Why");
		final FizzBuzzObject fizzBuzzObject_c = new FizzBuzzObject(130, "Bro");
		final FizzBuzzObject fizzBuzzObject_d = new FizzBuzzObject(770, "Doing");
		final FizzBuzzObject fizzBuzzObject_e = new FizzBuzzObject(690, "This");
		final FizzBuzzObject fizzBuzzObject_f = new FizzBuzzObject(350, "Am");
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Difficult(Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		final String expected = "BroWhyBroAmBroWhyBroIBroWhyThisAmDoingBroWhyBro";
		final String actual = mFizzBuzzAnalyzer.analyze(fizzBuzzObject_a, 
														fizzBuzzObject_b, 
														fizzBuzzObject_c, 
														fizzBuzzObject_d, 
														fizzBuzzObject_e, 
														fizzBuzzObject_f);
		assertEquals("Tests that 6 FizzBuzzObjects sort & return correctly.", expected, actual);
	}
	
	/**
	 * Tests that a FizzBuzzObject overrides 'toString()' method.
	 */
	@Test
	public void test_OverridesToString() {
		final FizzBuzzObject fizzBuzzObject = new FizzBuzzObject(1, "Test");
		
		final String expected = "FizzBuzzObject[1, Test]";
		final String actual = fizzBuzzObject.toString();
		assertEquals("Tests that a FizzBuzzObject overrides 'toString()' method.", expected, actual);
	}
}