package challenge_Interface;

/**
 * Use this class to implement the Interface challenge.
 * @author jacobwatson
 * @since 12/26/2018
 */
public class MovementObjectSimpleSolution implements Movement {
	private final String mDisplayStringHeader = "A simple object to demonstrate movement";
	private Coordinates mCoordinates;
	
	public MovementObjectSimpleSolution() {
		mCoordinates = new Coordinates(2, 4);
	}
	
	@Override
	public void move() {
		final int x = mCoordinates.getPositionX();
		final int y = mCoordinates.getPositionY();
		
		mCoordinates.setPositionX(x + 1);
		mCoordinates.setPositionY(y + 1);
	}
	
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