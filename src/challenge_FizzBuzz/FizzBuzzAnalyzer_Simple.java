package challenge_FizzBuzz;

/**
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/04/2019
 */
public class FizzBuzzAnalyzer_Simple {
	final int mBoundsLower = 1;
	final int mBoundsUpper = 100;
	final int mFizz = 3;
	final int mBuzz = 5;
	
	/**
	 * Analyzes the given {@code numberToAnalyze} and returns the results, in the form of a FizzBuzzAnalysisResult.
	 * @param numberToAnalyze The number that is to be analyzed.
	 * @return Returns the results of analysis, in the form of FizzBuzzAnalysisResults.
	 */
	public FizzBuzzAnalysisResult analyze(final int numberToAnalyze) {
		if (numberToAnalyze < mBoundsLower) return FizzBuzzAnalysisResult.ErrorLowerBounds;
		if (numberToAnalyze > mBoundsUpper) return FizzBuzzAnalysisResult.ErrorUpperBounds;
		
		final boolean fizz = numberToAnalyze % mFizz == 0;
		final boolean buzz = numberToAnalyze % mBuzz == 0;
		final boolean fizzBuzz = fizz && buzz;
		
		if (fizzBuzz) 	return FizzBuzzAnalysisResult.FizzBuzz;
		else if (fizz) 	return FizzBuzzAnalysisResult.Fizz;
		else if (buzz) 	return FizzBuzzAnalysisResult.Buzz;
		else 			return FizzBuzzAnalysisResult.NoResponse;
	}
}