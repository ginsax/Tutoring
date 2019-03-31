package challenge_FizzBuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class FizzBuzzTest_Simple.
 */
public class FizzBuzzTest_Simple {
	
	/** The m fizz buzz analyzer. */
	private final FizzBuzzAnalyzer_Simple mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Simple();
	
	
	/**
	 * Superficial test used only to get code coverage.
	 */
	@Test
	public void superficialEnumCoverageTest() {
		for (final FizzBuzzAnalysisResult result : FizzBuzzAnalysisResult
		    .values()) {
			FizzBuzzAnalysisResult.valueOf(result.name());
		}
	}
	
	/**
	 * Tests that the number 15 (fifteen) results in 'FizzBuzz'.
	 */
	@Test
	public void test_Fifteen_Returns_FizzBuzz() {
		final int numberToAnalyze = 15;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.FizzBuzz;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 15 (fifteen) results in 'FizzBuzz'.",
		    expected, actual);
	}
	
	/**
	 * Tests that the number 5 (five) results in 'Buzz'.
	 */
	@Test
	public void test_Five_Returns_Buzz() {
		final int numberToAnalyze = 5;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Buzz;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 5 (five) results in 'Buzz'.", expected,
		    actual);
	}
	
	/**
	 * Tests that the number 1 (one) results in no response.
	 */
	@Test
	public void test_One_Returns_NoResponse() {
		final int numberToAnalyze = 1;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.NoResponse;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 1 (one) results in no response.",
		    expected, actual);
	}
	
	/**
	 * Tests that the number 101 (one hundred one) is above the upper bounds.
	 */
	@Test
	public void test_OneHundredOne_Returns_ErrorUpperBounds() {
		final int numberToAnalyze = 101;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.ErrorUpperBounds;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals(
		    "Tests that the number 101 (one hundred one) is above the upper bounds.",
		    expected, actual);
	}
	
	/**
	 * Tests that the number 3 (three) results in 'Fizz'.
	 */
	@Test
	public void test_Three_Returns_Fizz() {
		final int numberToAnalyze = 3;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Fizz;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 3 (three) results in 'Fizz'.", expected,
		    actual);
	}
	
	/**
	 * Tests that the number 2 (two) results in no response.
	 */
	@Test
	public void test_Two_Returns_NoResponse() {
		final int numberToAnalyze = 2;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.NoResponse;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 2 (two) results in no response.",
		    expected, actual);
	}
	
	/**
	 * Tests that the number 0 (zero) is below the lower bounds.
	 */
	@Test
	public void test_Zero_Returns_ErrorLowerBounds() {
		final int numberToAnalyze = 0;
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.ErrorLowerBounds;
		
		final FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer
		    .analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 0 (zero) is below the lower bounds.",
		    expected, actual);
	}
}