package challenge_FizzBuzz;

/**
 * The Class FizzBuzzAnalyzer_Moderate.
 */
public class FizzBuzzAnalyzer_Moderate {
	
	/** The buzz multiple. */
	private final int fizzMultiple, buzzMultiple;
	
	
	/**
	 * Default FizzBuzzAnalyzer_Moderate constructor, initializes fizz multiple to
	 * 3 and buzz to 5. (matches test case)
	 */
	public FizzBuzzAnalyzer_Moderate() {
		fizzMultiple = 3;
		buzzMultiple = 5;
	}
	
	/**
	 * Select a fizz(buzz) constuctor; allows user to define fizz and buzz
	 * multiples.
	 * 
	 * @param myFizz
	 *          is the fizz multiple
	 * @param myBuzz
	 *          is the buzz multiple
	 */
	public FizzBuzzAnalyzer_Moderate(final int myFizz, final int myBuzz) {
		fizzMultiple = myFizz;
		buzzMultiple = myBuzz;
	}
	
	/**
	 * Analysis method. input an integer number to run a fizzbuzz test on.
	 * 
	 * @param numberToAnalyze
	 *          Integer number to analyze.
	 * @return Returns enumerated type response for result
	 */
	public FizzBuzzAnalysisResult analyze(final int numberToAnalyze) {
		FizzBuzzAnalysisResult result;
		// boolean set
		final boolean aboveLowerBounds = numberToAnalyze > 0;
		final boolean belowUpperBounds = numberToAnalyze <= 100;
		final boolean isDivisibleByFizz = (numberToAnalyze % fizzMultiple) == 0;
		final boolean isDivisibleByBuzz = (numberToAnalyze % buzzMultiple) == 0;
		
		if (!aboveLowerBounds) {
			result = FizzBuzzAnalysisResult.ErrorLowerBounds;
		} else if (!belowUpperBounds) {
			result = FizzBuzzAnalysisResult.ErrorUpperBounds;
		} else if (isDivisibleByFizz) {
			if (isDivisibleByBuzz) {
				result = FizzBuzzAnalysisResult.FizzBuzz;
			} else {
				result = FizzBuzzAnalysisResult.Fizz;
			}
		} else if (isDivisibleByBuzz) {
			result = FizzBuzzAnalysisResult.Buzz;
		} else {
			result = FizzBuzzAnalysisResult.NoResponse;
		}
		
		return result;
	}
	
}
