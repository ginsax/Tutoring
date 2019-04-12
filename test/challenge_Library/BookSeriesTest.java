package challenge_Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class that is intended to test the {@link BookSeries} class}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/18/2019
 */
public class BookSeriesTest {
	
	/** The book series that is to be tested. */
	private BookSeries mBookSeries;
	
	
	/** Initializes the BookSeries. Required to wipe all old information. */
	@Before
	public void setupBookSeries() {
		mBookSeries = new BookSeries();
	}
	
	/**
	 * Tests that a book series compares to another book series as equal if - and
	 * only if - the title, position within, and total number of books in series
	 * are all the same.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_Equally()
	                                                                   throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 1|3");
		mBookSeries = new BookSeries("Test Series 1|3");
		
		final int expected = 0;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as equal if - and only if - the title, position within, and total number of books in series are all the same.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as greater than if
	 * the position within is greater than the other book series position.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_GreaterThanPosition()
	                                                                               throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 1|3");
		mBookSeries = new BookSeries("Test Series 2|3");
		
		final int expected = 1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as greater than if the position within the series is greater than the other book series position.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as greater than if
	 * the title is greater than the other book series title.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_GreaterThanTitle()
	                                                                            throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Serier 1|3");
		mBookSeries = new BookSeries("Test Series 1|3");
		
		final int expected = 1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as greater than if the title is greater than the other book series title.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as greater than if
	 * the total number of books in the series are greater than the total number
	 * of books in the other book series.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_GreaterThanTotal()
	                                                                            throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 1|2");
		mBookSeries = new BookSeries("Test Series 1|3");
		
		final int expected = 1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as greater than if the total number of books in the series are greater than the total number of books in the other book series.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as less than if
	 * the position within is less than the other book series position.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_LessThanPosition()
	                                                                            throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 2|3");
		mBookSeries = new BookSeries("Test Series 1|3");
		
		final int expected = -1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as less than if the position within the series is less than the other book series position.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as less than if
	 * the title is less than the other book series title.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_LessThanTitle()
	                                                                         throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 1|3");
		mBookSeries = new BookSeries("Test Serier 1|3");
		
		final int expected = -1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as less than if the title is less than the other book series title.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series compares to another book series as less than if
	 * the total number of books in the series are less than the total number of
	 * books in the other book series.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_ComparesTo_AnotherBookSeries_LessThanTotal()
	                                                                         throws InvalidBookSeriesNameException {
		final BookSeries otherBookSeries = new BookSeries("Test Series 1|3");
		mBookSeries = new BookSeries("Test Series 1|2");
		
		final int expected = -1;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series compares to another book series as less than if the total number of books in the series are less than the total number of books in the other book series.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the information string of a book series is not an empty string.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_InformationString_IsNotEmpty()
	                                                           throws InvalidBookSeriesNameException {
		mBookSeries = new BookSeries("Test Book Series 1|1");
		final String expected = "";
		final String actual = mBookSeries.getSeriesInformationString();
		
		assertNotEquals("Tests that the information string of a book series is not an empty string.",
		                expected,
		                actual);
	}
	
	/**
	 * Tests that the information string of a book series can handle a floating
	 * point number.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_InformationString_IsNotString()
	                                                            throws InvalidBookSeriesNameException {
		mBookSeries = new BookSeries("Test Book Series 1.50|2");
		final String expected = ", book 1.5/2 of Test Book Series";
		final String actual = mBookSeries.getSeriesInformationString();
		
		assertEquals("Tests that the information string of a book series can handle a floating point number.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series is considered as part of a series.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test
	public void test_BookSeries_IsPartOfSeries()
	                                             throws InvalidBookSeriesNameException {
		mBookSeries = new BookSeries("Test Book Series 1|1");
		
		assertTrue("Tests that a book series is considered as part of a series.",
		           mBookSeries.isPartOfASeries());
	}
	
	/**
	 * Tests that a book series handles when a series name is not null, but is
	 * missing a '|'.
	 */
	@Test
	public void test_BookSeries_Name_HandlesIncompleteName() {
		try {
			mBookSeries = new BookSeries("No Series ");
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = mBookSeries.toString();
		
		assertEquals("Tests that the series name of a book series handles when a series name is not null, but is missing a '|'.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series handles when a series name is invalid.
	 * @throws InvalidBookSeriesNameException
	 */
	@Test (expected = InvalidBookSeriesNameException.class)
	public void test_BookSeries_Name_HandlesInvalidName()
	                                                      throws InvalidBookSeriesNameException {
		mBookSeries = new BookSeries("Test p|p");
	}
	
	/** Tests that the series name of a book series handles a null value. */
	@Test
	public void test_BookSeries_Name_HandlesNullName() {
		try {
			mBookSeries = new BookSeries(null);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = mBookSeries.toString();
		
		assertEquals("Tests that the series name of a book series handles a null value.",
		             expected,
		             actual);
	}
	
	/** Tests that the series name of a book series has the correct value. */
	@Test
	public void test_BookSeries_Name_HasCorrectValue() {
		final String title = "John's Washboard Abs";
		
		try {
			mBookSeries = new BookSeries(title + " 0|0");
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected = title;
		final String actual = mBookSeries.toString();
		
		assertEquals("Tests that the series name of a book series has the correct value.",
		             expected,
		             actual);
	}
	
	/** Tests that the book series class has no public non-final fields. */
	@Test
	public void test_BookSeriesReflection_NoPublicNonFinalFields() {
		final Field[] declaredFields = BookSeries.class.getDeclaredFields();
		
		for (final Field field : declaredFields) {
			if (!field.isSynthetic() && Modifier.isPublic(field.getModifiers()) &&
			    !Modifier.isFinal(field.getModifiers())) {
				
				final String message
				    = String.format("Field %s can only be public if it is also final.",
				                    field.getName());
				assertFalse(message,
				            Modifier.isStatic(field.getModifiers()));
			}
		}
	}
	
	/** Tests that the book series class has no static fields. */
	@Test
	public void test_BookSeriesReflection_NoStaticFields() {
		final Field[] declaredFields = BookSeries.class.getDeclaredFields();
		
		for (final Field field : declaredFields) {
			if (!field.isSynthetic()) {
				final String message = String.format("Field %s can't be static.",
				                                     field.getName());
				
				assertFalse(message,
				            Modifier.isStatic(field.getModifiers()));
			}
		}
	}
	
	/** Tests that the book series class has no static methods. */
	@Test
	public void test_BookSeriesReflection_NoStaticMethods() {
		final Method[] declaredMethods = BookSeries.class.getDeclaredMethods();
		
		for (final Method method : declaredMethods) {
			if (!method.isSynthetic()) {
				final String message = String.format("Method %s can't be static.",
				                                     method.getName());
				
				assertFalse(message,
				            Modifier.isStatic(method.getModifiers()));
			}
		}
	}
	
	/**
	 * Tests that a book series created with the default constructor compares to
	 * another default book series as equal, as long as the title is the same.
	 */
	@Test
	public void test_DefaultBookSeries_ComparesTo_AnotherDefaultBookSeries_Equally() {
		final BookSeries otherBookSeries = new BookSeries();
		
		final int expected = 0;
		final int actual = mBookSeries.compareTo(otherBookSeries);
		
		assertEquals("Tests that a book series created with the default constructor compares to another default book series as equal, as long as the title is the same.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the information string of a book series created with the default
	 * constructor is an empty string.
	 */
	@Test
	public void test_DefaultBookSeries_InformationString_IsEmptyString() {
		final String expected = "";
		final String actual = mBookSeries.getSeriesInformationString();
		
		assertEquals("Tests that the information string of a book series created with the default constructor is an empty string.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that a book series created with the default constructor is not
	 * considered as part of a series.
	 */
	@Test
	public void test_DefaultBookSeries_IsNotPartOfSeries() {
		assertFalse("Tests that a book series created with the default constructor is not considered as part of a series.",
		            mBookSeries.isPartOfASeries());
	}
	
	/**
	 * Tests that the series name of a book series created with the default
	 * constructor has the correct value.
	 */
	@Test
	public void test_DefaultBookSeries_Name_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = mBookSeries.toString();
		
		assertEquals("Tests that the series name of a book series created with the default constructor has the correct value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the series name of a book series created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultBookSeries_Name_IsNotNull() {
		assertNotNull("Tests that the series name of a book series created with the default constructor is not null.",
		              mBookSeries.toString());
	}
	
	/**
	 * Tests that the series property of a book series created with the default
	 * constructor has the correct value.
	 */
	@Test
	public void test_DefaultBookSeries_SeriesProperty_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = mBookSeries.seriesProperty().get();
		
		assertEquals("Tests that the series property of a book series created with the default constructor is not null.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the series property of a book series created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultBookSeries_SeriesProperty_IsNotNull() {
		assertNotNull("Tests that the series property of a book series created with the default constructor is not null.",
		              mBookSeries.seriesProperty());
	}
	
}