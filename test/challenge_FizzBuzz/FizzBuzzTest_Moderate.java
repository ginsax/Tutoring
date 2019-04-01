package challenge_FizzBuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class FizzBuzzTest_Moderate.
 */
public class FizzBuzzTest_Moderate {
	
	/** The m fizz buzz analyzer. */
	private FizzBuzzAnalyzer_Moderate mFizzBuzzAnalyzer;
	
	
	/**
	 * Tests that the number 15 (fifteen) results in 'FizzBuzz' with the default
	 * analyzer.
	 */
	@Test
	public void test_Fifteen_Returns_FizzBuzz() {
		final int numberToAnalyze = 15;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.FizzBuzz;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 15 (fifteen) results in 'FizzBuzz' with the default analyzer.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 5 (five) results in 'Fizz' if it has been set.
	 */
	@Test
	public void test_Five_CanReturn_Fizz() {
		final int numberToAnalyze = 5;
		mFizzBuzzAnalyzer
		    = new FizzBuzzAnalyzer_Moderate(5,
		                                    3);
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Fizz;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 5 (five) results in 'Fizz' if it has been set.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 5 (five) results in 'Buzz' with the default analyzer.
	 */
	@Test
	public void test_Five_Returns_Buzz() {
		final int numberToAnalyze = 5;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Buzz;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 5 (five) results in 'Buzz' with the default analyzer.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 1 (one) results in no response with the default
	 * analyzer.
	 */
	@Test
	public void test_One_Returns_NoResponse() {
		final int numberToAnalyze = 1;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.NoResponse;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 1 (one) results in no response with the default analyzer.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 101 (one hundred one) is above the upper bounds.
	 */
	@Test
	public void test_OneHundredOne_Returns_ErrorUpperBounds() {
		final int numberToAnalyze = 101;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected
		    = FizzBuzzAnalysisResult.ErrorUpperBounds;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 101 (one hundred one) is above the upper bounds.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 3 (three) results in 'Buzz' if it has been set.
	 */
	@Test
	public void test_Three_CanReturn_Buzz() {
		final int numberToAnalyze = 3;
		mFizzBuzzAnalyzer
		    = new FizzBuzzAnalyzer_Moderate(5,
		                                    3);
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Buzz;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 3 (three) results in 'Buzz' if it has been set.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 3 (three) results in 'Fizz' with the default
	 * analyzer.
	 */
	@Test
	public void test_Three_Returns_Fizz() {
		final int numberToAnalyze = 3;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.Fizz;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 3 (three) results in 'Fizz' with the default analyzer.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 2 (two) results in no response with the default
	 * analyzer.
	 */
	@Test
	public void test_Two_Returns_NoResponse() {
		final int numberToAnalyze = 2;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.NoResponse;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 2 (two) results in no response with the default analyzer.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that various combinations can result in 'FizzBuzz' if it has been
	 * set.
	 */
	@Test
	public void test_VariousCombinations_CanReturn_FizzBuzz() {
		final String errorMessage
		    = "Tests that the value of [%d] is divisible by both [%d] and [%d].";
		int numberToAnalyze = 8;
		int numberFizz = 4;
		int numberBuzz = 2;
		mFizzBuzzAnalyzer
		    = new FizzBuzzAnalyzer_Moderate(numberFizz,
		                                    numberBuzz);
		
		FizzBuzzAnalysisResult expected = FizzBuzzAnalysisResult.FizzBuzz;
		FizzBuzzAnalysisResult actual = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		assertEquals(String.format(errorMessage,
		                           numberToAnalyze,
		                           numberFizz,
		                           numberBuzz),
		             expected,
		             actual);
		
		numberToAnalyze = 22;
		numberFizz = 2;
		numberBuzz = 11;
		mFizzBuzzAnalyzer
		    = new FizzBuzzAnalyzer_Moderate(numberFizz,
		                                    numberBuzz);
		
		expected = FizzBuzzAnalysisResult.FizzBuzz;
		actual = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		assertEquals(String.format(errorMessage,
		                           numberToAnalyze,
		                           numberFizz,
		                           numberBuzz),
		             expected,
		             actual);
		
		numberToAnalyze = 54;
		numberFizz = 18;
		numberBuzz = 6;
		mFizzBuzzAnalyzer
		    = new FizzBuzzAnalyzer_Moderate(numberFizz,
		                                    numberBuzz);
		
		expected = FizzBuzzAnalysisResult.FizzBuzz;
		actual = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		assertEquals(String.format(errorMessage,
		                           numberToAnalyze,
		                           numberFizz,
		                           numberBuzz),
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number 0 (zero) is below the lower bounds.
	 */
	@Test
	public void test_Zero_Returns_ErrorLowerBounds() {
		final int numberToAnalyze = 0;
		mFizzBuzzAnalyzer = new FizzBuzzAnalyzer_Moderate();
		
		final FizzBuzzAnalysisResult expected
		    = FizzBuzzAnalysisResult.ErrorLowerBounds;
		
		final FizzBuzzAnalysisResult actual
		    = mFizzBuzzAnalyzer.analyze(numberToAnalyze);
		
		assertEquals("Tests that the number 0 (zero) is below the lower bounds.",
		             expected,
		             actual);
	}
}