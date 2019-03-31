package challenge_Interface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The Class MovementObjectSimpleTest.
 */
public class MovementObjectSimpleTest {

	/** The default zero value. */
	private final int defaultZeroValue = 0;

	/**
	 * Tests that the object can move.
	 */
	@Test
	public void test_MovementObjectSimple_CanMove() {
		final Movement movement = new MovementObjectSimple();
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
	 * Tests for the coordinates of a MovementObjectSimple being non-null.
	 */
	@Test
	public void test_MovementObjectSimple_CoordinatesAreNotNull() {
		final Movement movement = new MovementObjectSimple();

		assertNotNull("Tests for the coordinates of a MovementObjectSimple being non-null.", movement.getCoordinates());
	}

	/**
	 * Tests that the default X coordinate of a MovementObjectSimple is equal to 2.
	 */
	@Test
	public void test_MovementObjectSimple_DefaultXCoordinateIsEqual() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates coordinates = movement.getCoordinates();

		final int expected = 2;
		final int actual = coordinates.getPositionX();
		assertEquals("Tests that the default X coordinate of a MovementObjectSimple is equal to 2.", expected, actual);
	}

	/**
	 * Tests that the default Y coordinate of a MovementObjectSimple is equal to 4.
	 */
	@Test
	public void test_MovementObjectSimple_DefaultYCoordinateIsEqual() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates coordinates = movement.getCoordinates();

		final int expected = 4;
		final int actual = coordinates.getPositionY();
		assertEquals("Tests that the default Y coordinate of a MovementObjectSimple is equal to 4.", expected, actual);
	}

	/**
	 * Tests that the display string includes the position of the object.
	 */
	@Test
	public void test_MovementObjectSimple_DisplayStringIncludesCoordinates() {
		final Movement movement = new MovementObjectSimple();
		final String actual = movement.createDisplayString();

		final String expected = "A simple object to demonstrate movement [2, 4]";
		assertEquals("Tests that the display string includes the position of the object.", expected, actual);
	}

	/**
	 * Tests that the display string is not null.
	 */
	@Test
	public void test_MovementObjectSimple_DisplayStringIsNotNull() {
		final Movement movement = new MovementObjectSimple();

		assertNotNull("Tests that the display string is not null.", movement.createDisplayString());
	}

	/**
	 * Tests that the object moves exactly 1 in both the x and y directions.
	 */
	@Test
	public void test_MovementObjectSimple_MovesExactly() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates movementCoordinates = movement.getCoordinates();

		final int x = movementCoordinates.getPositionX();
		final int y = movementCoordinates.getPositionY();

		movement.move();

		final int newX = movementCoordinates.getPositionX();
		final int newY = movementCoordinates.getPositionY();

		assertEquals("Tests that the object moves exactly 1 in the X direction.", newX, x + 1);
		assertEquals("Tests that the object moves exactly 1 in the Y direction.", newY, y + 1);
	}

	/**
	 * Tests for a MovementObjectSimple being non-null.
	 */
	@Test
	public void test_MovementObjectSimple_NotNull() {
		final Movement movement = new MovementObjectSimple();

		assertNotNull("Tests for a MovementObjectSimple being non-null.", movement);
	}

	/**
	 * Tests for the X coordinate of a MovementObjectSimple being non-zero.
	 */
	@Test
	public void test_MovementObjectSimple_XCoordinateIsNonZero() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates coordinates = movement.getCoordinates();

		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionX();
		assertNotEquals("Tests for the X coordinate of a MovementObjectSimple being non-zero.", expected, actual);
	}

	/**
	 * Tests for the Y coordinate of a MovementObjectSimple being non-zero.
	 */
	@Test
	public void test_MovementObjectSimple_YCoordinateIsNonZero() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates coordinates = movement.getCoordinates();

		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionY();
		assertNotEquals("Tests for the Y coordinate of a MovementObjectSimple being non-zero.", expected, actual);
	}

	/**
	 * Tests for the Z coordinate of a MovementObjectSimple being zero.
	 */
	@Test
	public void test_MovementObjectSimple_ZCoordinateIsZero() {
		final Movement movement = new MovementObjectSimple();
		final Coordinates coordinates = movement.getCoordinates();

		final int expected = defaultZeroValue;
		final int actual = coordinates.getPositionZ();
		assertEquals("Tests for the Z coordinate of a MovementObjectSimple being zero.", expected, actual);
	}

}