package challenge_FizzBuzz;

/**
 * The Class FizzBuzzAnalyzer_Simple.
 */
public class FizzBuzzAnalyzer_Simple {
	// This class take in a number (assume integer input only), and outputs an
	// enumerated type "FizzBuzzAnalysisResult" depending on the number inputed.
	// The analyze method will explain outputs.
	
	public FizzBuzzAnalysisResult analyze(final int numberToAnalyze) {
		FizzBuzzAnalysisResult result;
		// boolean set
		final boolean aboveLowerBounds = numberToAnalyze > 0;
		final boolean belowUpperBounds = numberToAnalyze <= 100;
		final boolean isDivisibleBy3 = (numberToAnalyze % 3) == 0;
		final boolean isDivisibleBy5 = (numberToAnalyze % 5) == 0;
		
		if (!aboveLowerBounds) {
			result = FizzBuzzAnalysisResult.ErrorLowerBounds;
		} else if (!belowUpperBounds) {
			result = FizzBuzzAnalysisResult.ErrorUpperBounds;
		} else if (isDivisibleBy3) {
			if (isDivisibleBy5) {
				result = FizzBuzzAnalysisResult.FizzBuzz;
			} else {
				result = FizzBuzzAnalysisResult.Fizz;
			}
		} else if (isDivisibleBy5) {
			result = FizzBuzzAnalysisResult.Buzz;
		} else {
			result = FizzBuzzAnalysisResult.NoResponse;
		}
		
		return result;
	}
}
