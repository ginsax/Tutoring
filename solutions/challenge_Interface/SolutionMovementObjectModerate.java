package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public class SolutionMovementObjectModerate implements Movement {
	
	/** The default X value. */
	private final int	defaultX	= 3;
	/** The default Y value. */
	private final int	defaultY	= 4;
	/** The default Z value. */
	private final int	defaultZ	= 5;
	
	/** The display string header. */
	private final String mDisplayStringHeader
	    = "A moderately complex object to demonstrate movement";
	
	/** The coordinates object. */
	private final Coordinates mCoordinates;
	
	
	/**
	 * Default constructor of a new SolutionMovementObjectModerate. Instantiates
	 * the coordinates object with the default x, y, & z values.
	 */
	public SolutionMovementObjectModerate() {
		mCoordinates
		    = new Coordinates(defaultX,
		                      defaultY,
		                      defaultZ);
	}
	
	/**
	 * Alternate constructor of a new SolutionMovementObjectModerate. Allows for
	 * the setting of the coordinates object with the given {@code x}, {@code y},
	 * & {@code z} values.
	 * @param x The value that will set as the coordinates object's x position.
	 * @param y The value that will set as the coordinates object's y position.
	 * @param z The value that will set as the coordinates object's z position.
	 */
	public SolutionMovementObjectModerate(final int x,
	                                      final int y,
	                                      final int z) {
		mCoordinates
		    = new Coordinates(x,
		                      y,
		                      z);
	}
	
	@Override
	public String createDisplayString() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		final int z = mCoordinates.getPositionZ();
		
		final int modifiedX = (x * y);
		final int modifiedY = (y * z);
		final int modifiedZ = (z * x);
		
		return String.format("%s [%d, %d, %d][%d, %d, %d]",
		                     mDisplayStringHeader,
		                     x,
		                     y,
		                     z,
		                     modifiedX,
		                     modifiedY,
		                     modifiedZ);
	}
	
	/*
	 * (non-Javadoc)
	 * @see challenge_Interface.Movement#getCoordinates()
	 */
	@Override
	public Coordinates getCoordinates() {
		return mCoordinates;
	}
	
	@Override
	public void move() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		final int z = mCoordinates.getPositionZ();
		
		mCoordinates.setPositionX(x * defaultX);
		mCoordinates.setPositionY(y * defaultY);
		mCoordinates.setPositionZ(z * defaultZ);
	}
}