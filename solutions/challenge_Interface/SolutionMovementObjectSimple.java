package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public class SolutionMovementObjectSimple implements Movement {

  /** The display string header. */
	private final String mDisplayStringHeader = "A simple object to demonstrate movement";

  /** The coordinates object. */
	private Coordinates mCoordinates;

  /**
   * Default constructor of a new SolutionMovementObjectSimple. Instantiates 
   * the coordinates object with the default values of [x = 2] & [y = 4].
   */
	public SolutionMovementObjectSimple() {
		mCoordinates = new Coordinates(2, 4);
	}
	
	@Override
	public void move() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		
		mCoordinates.setPositionX(x + 1);
		mCoordinates.setPositionY(y + 1);
	}
	
	/* (non-Javadoc)
	 * @see challenge_Interface.Movement#getCoordinates()
	 */
	@Override
	public Coordinates getCoordinates() {
		return mCoordinates;
	}
	
	@Override
	public String createDisplayString() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		
		return String.format("%s [%d, %d]", mDisplayStringHeader, x, y);
	}
}