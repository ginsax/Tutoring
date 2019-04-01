package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public class MovementObjectSimple implements Movement {
	
	/** The coordinates. */
	// Initialize Coordinates sub-object to operate in conjunction with Movement
	// object.
	Coordinates coordinates;
	
	
	public MovementObjectSimple() {
		// Populate Coordinates object per test case expectation.
		coordinates
		    = new Coordinates(2,
		                      4);
	}
	
	/**
	 * Returns a display string - specific to the object. (this method does not
	 * print when called)
	 **/
	@Override
	public String createDisplayString() {
		// Create string "intro" bit.
		final String intro = "A simple object to demonstrate movement [";
		// Tie data into string intro to create main string.
		final String Alpha
		    = intro + coordinates.getPositionX() + ", " +
		      coordinates.getPositionY() + "]";
		return Alpha;
	}
	
	/**
	 * Returns internal Coordinates object related to MovementObjectSimple object.
	 * @return the coordinates
	 */
	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	/**
	 * Increases X & Y Coordinates by 1.
	 **/
	@Override
	public void move() {
		coordinates.setPositionX(coordinates.getPositionX() + 1);
		coordinates.setPositionY(coordinates.getPositionY() + 1);
	}
}