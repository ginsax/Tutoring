package challenge_FizzBuzz;

public class FizzBuzzAnalyzer_Moderate {

	private int fizzMultiple, buzzMultiple;
	
	/**
	 * Default FizzBuzzAnalyzer_Moderate constructor, initializes fizz multiple to 3 and buzz to 5. (matches test case)
	 */
	public FizzBuzzAnalyzer_Moderate(){
		fizzMultiple = 3;
		buzzMultiple = 5;
	}
	
	/**
	 * Select a fizz(buzz) constuctor; allows user to define fizz and buzz multiples.
	 * @param myFizz is the fizz multiple
	 * @param myBuzz is the buzz multiple
	 */
	public FizzBuzzAnalyzer_Moderate(int myFizz, int myBuzz){
		fizzMultiple = myFizz;
		buzzMultiple = myBuzz;
	}
	
	/**
	 * Analysis method. input an integer number to run a fizzbuzz test on.
	 * @param numberToAnalyze Integer number to analyze.
	 * @return Returns enumerated type response for result
	 */
	public FizzBuzzAnalysisResult analyze (int numberToAnalyze){
		FizzBuzzAnalysisResult result;
		//boolean set
		boolean aboveLowerBounds = numberToAnalyze>0;
		boolean belowUpperBounds = numberToAnalyze<=100;
		boolean isDivisibleByFizz   = numberToAnalyze%fizzMultiple == 0;
		boolean isDivisibleByBuzz   = numberToAnalyze%buzzMultiple == 0;
		
		if (!aboveLowerBounds){
			result = FizzBuzzAnalysisResult.ErrorLowerBounds;
		} else if (!belowUpperBounds) {
			result = FizzBuzzAnalysisResult.ErrorUpperBounds;
		} else if (isDivisibleByFizz) {
			if (isDivisibleByBuzz){
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