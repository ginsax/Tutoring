package challenge_FizzBuzz;

/**
 * The solution for a FizzBuzzObject.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/06/2019
 */
public class SolutionFizzBuzzObject implements Comparable<SolutionFizzBuzzObject> {
	/** The value of this FizzBuzzObject. */
	private final int mValue;
	/** The message this FizzBuzzObject displays. */
	private final String mMessage;

	/**
	 * Constructor of the FizzBuzzObject. Takes an integer for its value, as well as
	 * a String to be displayed as a message.
	 * 
	 * @param value   Integer value that represents the value of this
	 *                FizzBuzzObject.
	 * @param message String message that will be returned for this object.
	 */
	public SolutionFizzBuzzObject(final int value, final String message) {
		mValue = value;
		mMessage = message;
	}

	@Override
	public int compareTo(final SolutionFizzBuzzObject otherFizzBuzzObject) {
		final int valueThis = mValue;
		final int valueOther = otherFizzBuzzObject.getValue();
		final String messageThis = mMessage;
		final String messageOther = otherFizzBuzzObject.getMessage();

		if (valueThis < valueOther) {
			return -1;
		} else if (valueThis > valueOther) {
			return 1;
		} else {
			return messageThis.compareTo(messageOther);
		}
	}

	/**
	 * Returns the String message of this FizzBuzzObject.
	 * 
	 * @return Returns the message of this FizzBuzzObject.
	 */
	public String getMessage() {
		return mMessage;
	}

	/**
	 * Returns the value of this FizzBuzzObject.
	 * 
	 * @return Returns the value of this FizzBuzzObject.
	 */
	public int getValue() {
		return mValue;
	}

	@Override
	public String toString() {
		return String.format("FizzBuzzObject[%d, %s]", mValue, mMessage);
	}
}