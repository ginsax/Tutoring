package challenge_FizzBuzz;

/**
 * The Class FizzBuzzAnalyzer_Difficult.
 */
public class FizzBuzzAnalyzer_Difficult {

	/** The lower bounds. */
	private final int upperBounds, lowerBounds;

	/**
	 * Default FizzBuzzAnalyzer_Difficult constructor, initializes bounds to
	 * standard 1 through 100 (inclusive).
	 */
	public FizzBuzzAnalyzer_Difficult() {
		lowerBounds = 1;
		upperBounds = 100;
	}

	/**
	 * Bounds selector constructor; allows user to define upper and lower bounds
	 * (inclusive). Bounds must stay within 1-1000 inclusive, out of range inputs
	 * will be scaled back within range. If user inputs higher value into lower
	 * bound than upper, method will swap the two to make sense of the inputs.
	 * 
	 * @param myLower is the (inclusive) lower bound
	 * @param myUpper is the (inclusive) upper bound
	 */
	public FizzBuzzAnalyzer_Difficult(int myLower, int myUpper) {
		if (myLower > myUpper) {
			final int dummy = myLower;
			myLower = myUpper;
			myUpper = dummy;
		}
		if (myUpper > 1000) {
			myUpper = 1000;
		} else if (myUpper < 1) {
			myUpper = 1;
		}
		if (myLower > 1000) {
			myLower = 1000;
		} else if (myLower < 1) {
			myLower = 1;
		}
		lowerBounds = myLower;
		upperBounds = myUpper;
	}

	/**
	 * Analyzes a set of FizzBuzz multiple/callsign combinations between bounds set
	 * for FizzBuzzAnalyzer_Difficult object.
	 * 
	 * @param fiBu Inputs an unbounded comma separated set of FizzBuzzObject Objects
	 *             for Analysis.
	 * @return Returns a string containing undelimited callsigns in order or their
	 *         FizzBuzz multiple per integer step of the range.
	 */
	public String analyze(final FizzBuzzObject... fiBu) {
		String result = "";
		FizzBuzzObject.sortMe(fiBu);
		for (int i = lowerBounds; i <= upperBounds; i++) {
			for (final FizzBuzzObject iteratorFiBu : fiBu) {
				if ((i % iteratorFiBu.multiple) == 0) {
					result = result + iteratorFiBu.callSign;
				}
			}
		}
		return result;
	}

	/**
	 * Returns the current lower bounds of the FizzBuzzAnalyzer_Difficult object.
	 * 
	 * @return returns lower bounds.
	 */
	public int getBoundsLower() {
		return lowerBounds;
	}

	/**
	 * Returns the current upper bounds of the FizzBuzzAnalyzer_Difficult object.
	 * 
	 * @return returns upper bounds.
	 */
	public int getBoundsUpper() {
		return upperBounds;
	}

}
