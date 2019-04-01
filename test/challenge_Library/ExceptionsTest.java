package challenge_Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test class that is intended to test all exceptions.
 * @author jacobwatson
 * @version 1.0
 * @since 01/19/2019
 */
public class ExceptionsTest {
	
	/**
	 * Tests that a {@link EmptyFileNameException} can be created.
	 */
	@Test
	public void test_EmptyFileNameException_CanBeCreated() {
		final LibraryException exception = new EmptyFileNameException();
		assertNotNull("Tests that a EmptyFileNameException can be created.",
		              exception);
	}
	
	/**
	 * Tests that a {@link EmptyFileNameException} can have a message set.
	 */
	@Test
	public void test_EmptyFileNameException_CanHaveCustomMessage() {
		final String expected = "Test exception method.";
		final LibraryException exception = new EmptyFileNameException(expected);
		
		final String actual = exception.getMessage();
		assertEquals("Tests that a EmptyFileNameException can have a message set.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a {@link InvalidBookSeriesNameException} can be created.
	 */
	@Test
	public void test_InvalidBookSeriesNameException_CanBeCreated() {
		final LibraryException exception = new InvalidBookSeriesNameException();
		assertNotNull("Tests that a InvalidBookSeriesNameException can be created.",
		              exception);
	}
	
	/**
	 * Tests that a {@link EmptyFileNameException} can have a message set.
	 */
	@Test
	public void test_InvalidBookSeriesNameException_CanHaveCustomMessage() {
		final String expected = "Test exception method.";
		final LibraryException exception = new InvalidBookSeriesNameException(expected);
		
		final String actual = exception.getMessage();
		assertEquals("Tests that a InvalidBookSeriesNameException can have a message set.",
		             expected,
		             actual);
	}
	
}