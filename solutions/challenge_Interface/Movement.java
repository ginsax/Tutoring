package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public interface Movement {
	
	/**
	 * Moves the object (modifies its X, Y, and/or Z coordinates).
	 */
	public void move();
	
	/**
	 * Returns the coordinates of the object.
	 * @return Returns the coordinates of the object.
	 */
	public Coordinates getCoordinates();
	
	/**
	 * Returns a display string - specific to the object.
	 * @return Returns an object-specific display string.
	 */
	public String createDisplayString();
}