package challenge_Interface;

// TODO: Auto-generated Javadoc
/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
class Coordinates {
	/** The default value given to new coordinate positions. Value is 0. */
	private final int defaultValue = 0;
	
	/** The X coordinate of the object. */
	private int positionX;
	/** The Y coordinate of the object.	*/
	private int positionY;
	/** The Z coordinate of the object. */
	private int positionZ;
	
	
	/**
	 * Initializes the X and Y coordinates with the given {@code positionX} and
	 * {@code positionY} parameters. The Z position is set to the default value.
	 * @param positionX The value to be set as the X position.
	 * @param positionY The value to be set as the Y position.
	 */
	Coordinates(final int positionX, 
	            final int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = defaultValue;
	}
	/**
	 * Initializes the X, Y, and Z coordinates with the given {@code positionX}, 
	 * {@code positionY}, and {@code positionZ} parameters.
	 * @param positionX The value to be set as the X position.
	 * @param positionY The value to be set as the Y position.
	 * @param positionZ The value to be set as the Z position.
	 */
	Coordinates(final int positionX, 
	            final int positionY, 
	            final int positionZ) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
	}
	
	/**
	 * Returns the current X position of the object.
	 * @return Returns the X position of the object.
	 */
	int getPositionX() {
		return positionX;
	}
	/**
	 * Sets the X position to the given {@code newPositionX}.
	 * @param newPositionX the new X position.
	 */
	void setPositionX(final int newPositionX) {
		positionX = newPositionX;
	}
	
	/**
	 * Returns the current Y position of the object.
	 * @return Returns the Y position of the object.
	 */
	int getPositionY() {
		return positionY;
	}
	/**
	 * Sets the Y position to the given {@code newPositionY}.
	 * @param newPositionY the new Y position.
	 */
	void setPositionY(final int newPositionY) {
		positionY = newPositionY;
	}
	
	/**
	 * Returns the current Z position of the object.
	 * @return Returns the Z position of the object.
	 */
	int getPositionZ() {
		return positionZ;
	}
	/**
	 * Sets the Z position to the given {@code newPositionZ}.
	 * @param newPositionZ the new Z position.
	 */
	void setPositionZ(final int newPositionZ) {
		positionZ = newPositionZ;
	}
}