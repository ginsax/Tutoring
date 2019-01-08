package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public class MovementObjectModerateSolution implements Movement {
	private final int defaultX = 3;
	private final int defaultY = 4;
	private final int defaultZ = 5;
	private final String mDisplayStringHeader = "A moderately complex object to demonstrate movement";
	private Coordinates mCoordinates;
	
	public MovementObjectModerateSolution() {
		mCoordinates = new Coordinates(defaultX, defaultY, defaultZ);
	}
	public MovementObjectModerateSolution(final int x, final int y, final int z) {
		mCoordinates = new Coordinates(x, y, z);
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
	
	@Override
	public Coordinates getCoordinates() {
		return mCoordinates;
	}
	
	@Override
	public String createDisplayString() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		final int z = mCoordinates.getPositionZ();
		
		final int modifiedX = (x * y);
		final int modifiedY = (y * z);
		final int modifiedZ = (z * x);
		
		return String.format("%s [%d, %d, %d][%d, %d, %d]", mDisplayStringHeader, x, y, z, modifiedX, modifiedY, modifiedZ);
	}
}