package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * 
 * @author jacobwatson
 * @since 12/26/2018
 */
public class MovementObjectModerate implements Movement {
	
	/** The m mod coordinates. */
	Coordinates mModCoordinates;
	
	// In the test document, the last test says that the intention of the program
	// is to move in each direction as such y=(x/y/zMove)^(iteration)
	// this set of default values represents the base of the power function. Each
	// will need to be created depending on how the movement object
	/** The z move. */
	// is initialized (default coordinates or not).
	int xMove, yMove, zMove;
	
	
	/**
	 * Default constructor. Default coordinates per test document.
	 */
	public MovementObjectModerate() {
		// default coordinates to match test class. Set default Move() power
		// function bases.
		mModCoordinates = new Coordinates(3, 4, 5);
		xMove = 3;
		yMove = 4;
		zMove = 5;
	}
	
	public MovementObjectModerate(final int x, final int y, final int z) {
		mModCoordinates = new Coordinates(x, y, z);
		xMove = x;
		yMove = y;
		zMove = z;
	}
	
	/**
	 * Format for this item to match what test case is looking for.
	 */
	@Override
	public String createDisplayString() {
		// Create string intro.
		final String displayString1 = "A moderately complex object to demonstrate movement [";
		// Create modified movement coordinates (per test case specification).
		final int xMod = xMove * yMove;
		final int yMod = yMove * zMove;
		final int zMod = zMove * xMove;
		// Assemble final string.
		final String displayString = displayString1 + xMove + ", " + yMove + ", "
		    + zMove + "][" + xMod + ", " + yMod + ", " + zMod + "]";
		return displayString;
	}
	
	/**
	 * Returns Coordinates object, per test case.
	 *
	 * @return the coordinates
	 */
	@Override
	public Coordinates getCoordinates() {
		return mModCoordinates;
	}
	
	/**
	 * Per test document, the idea for the Move() method is to move as a power
	 * function.
	 **/
	@Override
	public void move() {
		final int currentX = mModCoordinates.getPositionX();
		final int currentY = mModCoordinates.getPositionY();
		final int currentZ = mModCoordinates.getPositionZ();
		mModCoordinates.setPositionX(currentX * xMove);
		mModCoordinates.setPositionY(currentY * yMove);
		mModCoordinates.setPositionZ(currentZ * zMove);
	}
}