package challenge_FizzBuzz;

import java.util.Arrays;

/**
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/04/2019
 */
public class FizzBuzzAnalyzer_Difficult {
	private int mBoundsLower;
	private int mBoundsUpper;
	
	/**
	 * Constructor of the difficult Fizz Buzz Analyzer. Allows for the setting 
	 * of upper and lower bounds.
	 * @param boundsLower Lower bounds of this analysis. If the given value is 
	 * less than 0, then it is set to 0.
	 * @param boundsUpper Upper bounds of this analysis. If the given value is 
	 * greater than 1000, then it is set to 1000.
	 */
	public FizzBuzzAnalyzer_Difficult(final int boundsLower, 
									  final int boundsUpper) {
		mBoundsLower = boundsLower < 1 		? 1 		: boundsLower;
		mBoundsLower = boundsLower > 1000 	? 1000 	: mBoundsLower;
		mBoundsUpper = boundsUpper < 1 		? 1 		: boundsUpper;
		mBoundsUpper = boundsUpper > 1000 	? 1000 	: mBoundsUpper;
	}
	
	/**
	 * Returns a String message containing all the values returned by various 
	 * FizzBuzzObjects. FizzBuzzObjects will be sorted in order of their 
	 * integer 'value' property.
	 * @param fizzBuzzObjects Any number of FizzBuzzObjects to be used in this 
	 * analysis.
	 * @return Return a string message containing the values returned by the 
	 * given {@code fizzBuzzObjects}.
	 */
	public String analyze(final FizzBuzzObject... fizzBuzzObjects) {
		final String messageDefault = "No Response";
		Arrays.sort(fizzBuzzObjects);
		
		String message = messageDefault;
		
		for(int i = mBoundsLower; i <= mBoundsUpper; i++) {
			for(FizzBuzzObject fizzBuzzObject : fizzBuzzObjects) {
				if(i % fizzBuzzObject.getValue() == 0) {
					if(message == messageDefault) message = "";
					message += fizzBuzzObject.getMessage();
				}
			}
		}
		
		return message;
	}
	
	/**
	 * Returns the lower bounds.
	 * @return Returns the lower bounds.
	 */
	public int getBoundsLower() {
		return mBoundsLower;
	}
	/**
	 * Returns the upper bounds.
	 * @return Returns the upper bounds.
	 */
	public int getBoundsUpper() {
		return mBoundsUpper;
	}
}