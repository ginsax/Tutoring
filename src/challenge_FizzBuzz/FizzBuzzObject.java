package challenge_FizzBuzz;

import java.util.Arrays;

public class FizzBuzzObject implements Comparable<FizzBuzzObject>{

	// Initialize primary values
	int multiple;
	String callSign;

	//Dictates how the FizzBuzzObjects should compare against each other. Objects shall be sorted by multiple.
	public int compareTo(FizzBuzzObject obj){
		if(multiple==obj.multiple){
			return 0;
		} else if(multiple>obj.multiple){
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Static method to sort an Array of FizzBuzzObjects by multiple
	 * @param FiBu is the array of FizzBuzzObjects to be sorted
	 * @return Returns a sorted FizzBuzzObject array
	 */
	public static FizzBuzzObject[] sortMe(FizzBuzzObject[] FiBu){
		Arrays.sort(FiBu);
		return FiBu;	
	}
	
	/**
	 * Constructor for a FizzBuzzObject. This object will be used as a configuration input for a multiple/callsign combination in a fizzbuzz analysis class.
	 * @param multipleInput Dictates the multiple on which this FizzBuzzObject will refer to (in the classic example, "3" is Fizz' multiple.)
	 * @param callSignInput Dictates the callsign that the multiple will respond with (in the classic example, "Fizz" is 3's response)
	 */
	public FizzBuzzObject(int multipleInput, String callSignInput){
		this.multiple = multipleInput;
		this.callSign = callSignInput;
	}
	
	/**
	 * Returns a string containing the callsign of the object in question.
	 * @return Callsign String
	 */
	public String getMessage(){
		return this.callSign;
	}
	
	/**
	 * Returns the information contained within the object calling the method as a string.
	 */
	@Override
	public String toString(){
		String header = "FizzBuzzObject[";
		String post = "]";
		String returnString = header + Integer.toString(multiple) + ", " + callSign + post;
		return returnString;
	}
	
	
}
