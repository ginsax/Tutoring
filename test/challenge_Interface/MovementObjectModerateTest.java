package challenge_Interface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import challenge_Interface.Coordinates;
import challenge_Interface.Movement;
import challenge_Interface.MovementObjectModerate;

/**
 * Run this class as a 'JUnit Test Case'.
 * @author jacob.watson
 * @since 12/26/2018
 */
public class MovementObjectModerateTest {
	private final int defaultZeroValue = 0;

	/**
	 * Tests for a MovementObject_Moderate being non-null.
	 */
	@Test
	public void test_MovementObject_Moderate_NotNull() {
		final Movement movement = new MovementObjectModerate();
		
		assertNotNull("Tests for a MovementObject_Moderate being non-null.", movement);
	}
	
	/**
	 * Tests for the coordinates of a MovementObject_Moderate being non-null.
	 */
	@Test
	public void test_MovementObject_Moderate_CoordinatesAreNotNull() {
		final Movement movement = new MovementObjectModerate();
		
		assertNotNull("Tests for the coordinates of a MovementObject_Moderate being non-null.", movement.getCoordinates());
	}
	
	/**
	 * Tests for the default X coordinate of a MovementObject_Moderate being non-zero.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultXCoordinateIsNotZero() {
		final Movement movement = new MovementObjectModerate();
		final Coordinates coordinates = movement.getCoordinates();
		
		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionX();
		assertNotEquals("Tests for the X coordinate of a MovementObject_Moderate being non-zero.", expected, actual);
	}
	/**
	 * Tests for the default Y coordinate of a MovementObject_Moderate being non-zero.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultYCoordinateIsNotZero() {
		final Movement movement = new MovementObjectModerate();
		final Coordinates coordinates = movement.getCoordinates();
		
		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionY();
		assertNotEquals("Tests for the Y coordinate of a MovementObject_Moderate being non-zero.", expected, actual);
	}
	/**
	 * Tests for the default Z coordinate of a MovementObject_Moderate being non-zero.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultZCoordinateIsNotZero() {
		final Movement movement = new MovementObjectModerate();
		final Coordinates coordinates = movement.getCoordinates();
		
		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionZ();
		assertNotEquals("Tests for the Z coordinate of a MovementObject_Moderate being non-zero.", expected, actual);
	}
	
	/**
	 * Tests that the X coordinate of a MovementObject_Moderate can be set.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultXCoordinateCanBeSet() {
		final Movement 		movement 	= new MovementObjectModerate(5, 7, 10);
		final Coordinates 	coordinates = movement.getCoordinates();
		
		final int expected = 5;
		final int actual = coordinates.getPositionX();
		
		assertEquals("Tests that the X coordinate of a MovementObject_Moderate can be set.", expected, actual);
	}
	/**
	 * Tests that the Y coordinate of a MovementObject_Moderate can be set.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultYCoordinateCanBeSet() {
		final Movement 		movement 	= new MovementObjectModerate(1, 2, 3);
		final Coordinates 	coordinates = movement.getCoordinates();
		
		final int expected 	= 2;
		final int actual 	= coordinates.getPositionY();
		
		assertEquals("Tests that the Y coordinate of a MovementObject_Moderate can be set.", expected, actual);
	}
	/**
	 * Tests that the Z coordinate of a MovementObject_Moderate can be set.
	 */
	@Test
	public void test_MovementObject_Moderate_DefaultZCoordinateCanBeSet() {
		final Movement 		movement 	= new MovementObjectModerate(10, 12, 13);
		final Coordinates 	coordinates = movement.getCoordinates();
		
		final int expected 	= 13;
		final int actual 	= coordinates.getPositionZ();
		
		assertEquals("Tests that the Z coordinate of a MovementObject_Moderate can be set.", expected, actual);
	}

	/**
	 * Tests that the display string is not null.
	 */
	@Test
	public void test_MovementObjectModerate_DisplayStringIsNotNull() {
		final Movement movement = new MovementObjectModerate();
		
		assertNotNull("Tests that the display string is not null.", movement.createDisplayString());
	}
	/**
	 * Tests that the display string includes the default position of the object.
	 */
	@Test
	public void test_MovementObjectModerate_DisplayStringIncludesCoordinates() {
		final Movement 	movement 	= new MovementObjectModerate();
		final String 	actual 		= movement.createDisplayString();
		
		final String expected = "A moderately complex object to demonstrate movement [3, 4, 5][12, 20, 15]";
		assertEquals("Tests that the display string includes the position of the object.", expected, actual);
	}
	
	/**
	 * Tests that the object can move.
	 */
	@Test
	public void test_MovementObjectModerate_CanMove() {
		final Movement movement = new MovementObjectModerate();
		final Coordinates movementCoordinates = movement.getCoordinates();
		
		final int x = movementCoordinates.getPositionX();
		final int y = movementCoordinates.getPositionY();
		
		movement.move();
		
		final int newX = movementCoordinates.getPositionX();
		final int newY = movementCoordinates.getPositionY();
		
		assertNotEquals("Tests that the object can move in the X direction.", x, newX);
		assertNotEquals("Tests that the object can move in the Y direction.", y, newY);
	}
	/**
	 * Tests that the object moves in multiples of the of the default value in the x, y, and z directions.
	 */
	@Test
	public void test_MovementObjectModerate_MovesExactly() {
		final int multiplier = 5;
		final Movement movement = new MovementObjectModerate();
		final Coordinates movementCoordinates = movement.getCoordinates();
		
		final int expectedX = (int) Math.pow(movementCoordinates.getPositionX(), multiplier + 1);
		final int expectedY = (int) Math.pow(movementCoordinates.getPositionY(), multiplier + 1);
		final int expectedZ = (int) Math.pow(movementCoordinates.getPositionZ(), multiplier + 1);
		
		int actualX = movementCoordinates.getPositionX();
		int actualY = movementCoordinates.getPositionY();
		int actualZ = movementCoordinates.getPositionZ();
		
		for(int i = 0; i < multiplier; i++) {
			movement.move();
			
			actualX = movementCoordinates.getPositionX();
			actualY = movementCoordinates.getPositionY();
			actualZ = movementCoordinates.getPositionZ();
		}
		
		assertEquals("Tests that the object moves in multiples of 3 in the X direction.", expectedX, actualX);
		assertEquals("Tests that the object moves in multiples of 4 in the Y direction.", expectedY, actualY);
		assertEquals("Tests that the object moves in multiples of 5 in the Z direction.", expectedZ, actualZ);
	}
	
}