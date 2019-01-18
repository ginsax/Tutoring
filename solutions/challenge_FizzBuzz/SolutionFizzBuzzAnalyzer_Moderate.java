package challenge_FizzBuzz;

// TODO: Auto-generated Javadoc
/**
 * The solution for a FizzBuzzObject_Moderate.
 * @author jacobwatson
 * @version 1.0
 * @since 01/06/2019
 */
public class SolutionFizzBuzzAnalyzer_Moderate {
  /** The lower bounds of this analysis. */
	private final int mBoundsLower = 1; 
  /** The upper bounds of this analysis. */
	private final int mBoundsUpper = 100;
	
	/** The default fizz value. */
	private final int mDefaultFizz = 3; 
	/** The default buzz value. */
	private final int mDefaultBuzz = 5;
	
	/** The fizz value. */
	private int mFizz;
	/** The buzz value. */
	private int mBuzz;
	
	
	/**
	 * Constructor of the moderate Fizz Buzz Analyzer. Sets the value of 'Fizz' 
	 * and 'Buzz' to their default values.
	 */
	public SolutionFizzBuzzAnalyzer_Moderate() {
		mFizz = mDefaultFizz;
		mBuzz = mDefaultBuzz;
	}
	/**
	 * Constructor of the moderate Fizz Buzz Analyzer. Allows for variable 
	 * values for both the 'Fizz' and 'Buzz' fields.
	 * @param fizz First of two variables, is generally the smaller value.
	 * @param buzz Second of two variables, is usually the larger value.
	 */
	public SolutionFizzBuzzAnalyzer_Moderate(final int fizz, 
									 final int buzz) {
		mFizz = fizz;
		mBuzz = buzz;
	}
	
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