package challenge_FizzBuzz;

/**
 * The solution for a FizzBuzzObject_Simple.
 * @author jacobwatson
 * @version 1.0
 * @since 01/06/2019
 */
public class SolutionFizzBuzzAnalyzer_Simple {
  /** The lower bounds of this analysis. */
  final int mBoundsLower = 1;
  /** The upper bounds of this analysis. */
  final int mBoundsUpper = 100;
  
  /** The fizz value. */
  final int mFizz = 3;
  /** The buzz value. */
  final int mBuzz = 5;
  
  
  /**
   * Analyzes the given {@code numberToAnalyze} and returns the results, in the
   * form of a FizzBuzzAnalysisResult.
   * @param numberToAnalyze The number that is to be analyzed.
   * @return Returns the results of analysis, in the form of
   *         FizzBuzzAnalysisResults.
   */
  public FizzBuzzAnalysisResult analyze(final int numberToAnalyze) {
    if (numberToAnalyze < mBoundsLower) { return FizzBuzzAnalysisResult.ErrorLowerBounds; }
    if (numberToAnalyze > mBoundsUpper) { return FizzBuzzAnalysisResult.ErrorUpperBounds; }
    
    final boolean fizz = (numberToAnalyze %
                          mFizz) == 0;
    final boolean buzz = (numberToAnalyze %
                          mBuzz) == 0;
    final boolean fizzBuzz = fizz &&
                             buzz;
    
    if (fizzBuzz) {
      return FizzBuzzAnalysisResult.FizzBuzz;
    }
    else if (fizz) {
      return FizzBuzzAnalysisResult.Fizz;
    }
    else if (buzz) {
      return FizzBuzzAnalysisResult.Buzz;
    }
    else {
      return FizzBuzzAnalysisResult.NoResponse;
    }
  }
}