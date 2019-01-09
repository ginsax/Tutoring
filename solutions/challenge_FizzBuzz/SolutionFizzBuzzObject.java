package challenge_FizzBuzz;

public class SolutionFizzBuzzObject implements Comparable<SolutionFizzBuzzObject>{
	private int mValue;
	private String mMessage;
	
	/**
	 * Constructor of the FizzBuzzObject. Takes an integer for its value, as well as a 
	 * String to be displayed as a message.
	 * @param value Integer value that represents the value of this FizzBuzzObject.
	 * @param message String message that will be returned for this object. 
	 */
	public SolutionFizzBuzzObject(final int value, 
						  final String message) {
		mValue = value;
		mMessage = message;
	}
	
	/**
	 * Returns the value of this FizzBuzzObject.
	 * @return Returns the value of this FizzBuzzObject.
	 */
	public int getValue() {
		return mValue;
	}
	/**
	 * Returns the String message of this FizzBuzzObject.
	 * @return Returns the message of this FizzBuzzObject.
	 */
	public String getMessage() {
		return mMessage;
	}

	
	@Override
	public int compareTo(SolutionFizzBuzzObject otherFizzBuzzObject) {
		final int valueThis = mValue;
		final int valueOther = otherFizzBuzzObject.getValue();
		final String messageThis = mMessage;
		final String messageOther = otherFizzBuzzObject.getMessage();
		
		if (valueThis < valueOther) 		return -1;
		else if (valueThis > valueOther) 	return  1;
		else return messageThis.compareTo(messageOther);
	}
	
	@Override
	public String toString() {
		return String.format("FizzBuzzObject[%d, %s]", mValue, mMessage);
	}
}