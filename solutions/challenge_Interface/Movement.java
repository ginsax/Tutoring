package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
interface Movement {
  
  /**
   * Returns a display string - specific to the object.
   * @return Returns an object-specific display string.
   */
  String createDisplayString();
  
  /**
   * Returns the coordinates of the object.
   * @return Returns the coordinates of the object.
   */
  Coordinates getCoordinates();
  
  /**
   * Moves the object (modifies its X, Y, and/or Z coordinates).
   */
  void move();
}