package challenge_Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class that is intended to test the {@link LibraryBook} class}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/17/2019
 */
public class LibraryBookTest {
	
	/** The library book that is to be tested. */
	private LibraryBook mLibraryBook;
	
	
	/** Initializes the LibraryBook. Required to wipe all old information. */
	@Before
	public void setupLibraryBook() {
		mLibraryBook = new LibraryBook();
	}
	
	/**
	 * Tests that the audience of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Audience_HasDefaultValue() {
		final Audience expected = Audience.DefaultAudience;
		final Audience actual = mLibraryBook.getAudience();
		
		assertEquals("Tests that the audience of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the audience of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Audience_IsNotNull() {
		assertNotNull("Tests that the ISBN of a library book created with the default constructor is not null.",
		              mLibraryBook.audienceProperty());
	}
	
	/**
	 * Tests that the author of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Author_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_AUTHOR;
		final String actual = mLibraryBook.getAuthor();
		
		assertEquals("Tests that the author of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the author of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Author_IsNotNull() {
		assertNotNull("Tests that the author of a library book created with the default constructor is not null.",
		              mLibraryBook.authorProperty());
	}
	
	/**
	 * Tests that the fictionality of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Fictionality_HasDefaultValue() {
		final Fictionality expected = Fictionality.DefaultFictionality;
		final Fictionality actual = mLibraryBook.getFictionality();
		
		assertEquals("Tests that the fictionality of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the fictionality of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Fictionality_IsNotNull() {
		assertNotNull("Tests that the fictionality of a library book created with the default constructor is not null.",
		              mLibraryBook.fictionalityProperty());
	}
	
	/**
	 * Tests that the genre of a library book created with the default constructor
	 * has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Genre_HasDefaultValue() {
		final Genre expected = Genre.DefaultGenre;
		final Genre actual = mLibraryBook.getGenre();
		
		assertEquals("Tests that the genre of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the genre of a library book created with the default constructor
	 * is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Genre_IsNotNull() {
		assertNotNull("Tests that the ISBN of a library book created with the default constructor is not null.",
		              mLibraryBook.genreProperty());
	}
	
	/**
	 * Tests that the unique ID of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_ID_HasDefaultValue() {
		assertNotNull("Tests that the unique ID of a library book created with the default constructor has the default value.",
		              mLibraryBook.getID());
	}
	
	/**
	 * Tests that the unique ID of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_ID_IsNotNull() {
		assertNotNull("Tests that the unique ID of a library book created with the default constructor is not null.",
		              mLibraryBook.idProperty());
	}
	
	/**
	 * Tests that the ISBN of a library book created with the default constructor
	 * has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_ISBN_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_ISBN;
		final String actual = mLibraryBook.getISBN();
		
		assertEquals("Tests that the ISBN of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the ISBN of a library book created with the default constructor
	 * is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_ISBN_IsNotNull() {
		assertNotNull("Tests that the ISBN of a library book created with the default constructor is not null.",
		              mLibraryBook.isbnProperty());
	}
	
	/**
	 * Tests that the number of in stock copies of a library book created with the
	 * default constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_NumberOfCopiesInStock_HasDefaultValue() {
		final int expected = CommonConstants.DEFAULT_STOCK;
		final int actual = mLibraryBook.getNumberOfCopiesInStock();
		
		assertEquals("Tests that the number of in stock copies of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number of in stock copies of a library book created with the
	 * default constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_NumberOfCopiesInStock_IsNotNull() {
		assertNotNull("Tests that the number of in stock copies of a library book created with the default constructor is not null.",
		              mLibraryBook.numberOfCopiesInStockProperty());
	}
	
	/**
	 * Tests that the number of total copies of a library book created with the
	 * default constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_NumberOfCopiesTotal_HasDefaultValue() {
		final int expected = CommonConstants.DEFAULT_STOCK;
		final int actual = mLibraryBook.getNumberOfCopiesTotal();
		
		assertEquals("Tests that the number of total copies of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number of total copies of a library book created with the
	 * default constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_NumberOfCopiesTotal_IsNotNull() {
		assertNotNull("Tests that the number of total copies of a library book created with the default constructor is not null.",
		              mLibraryBook.numberOfCopiesTotalProperty());
	}
	
	/**
	 * Tests that the publishing year of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_PublishingYear_HasDefaultValue() {
		final int expected = CommonConstants.DEFAULT_PUBLISHING_YEAR;
		final int actual = mLibraryBook.getPublishingYear();
		
		assertEquals("Tests that the publishing year of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the publishing year of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_PublishingYear_IsNotNull() {
		assertNotNull("Tests that the publishing year of a library book created with the default constructor is not null.",
		              mLibraryBook.publishingYearProperty());
	}
	
	/**
	 * Tests that the series of a library book created with the default
	 * constructor has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Series_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = mLibraryBook.getSeries();
		
		assertEquals("Tests that the series of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the series of a library book created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Series_IsNotNull() {
		assertNotNull("Tests that the series of a library book created with the default constructor is not null.",
		              mLibraryBook.seriesProperty());
	}
	
	/**
	 * Tests that the title of a library book created with the default constructor
	 * has the default value.
	 */
	@Test
	public void test_DefaultLibraryBook_Title_HasDefaultValue() {
		final String expected = CommonConstants.DEFAULT_TITLE;
		final String actual = mLibraryBook.getTitle();
		
		assertEquals("Tests that the title of a library book created with the default constructor has the default value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the title of a library book created with the default constructor
	 * is not null.
	 */
	@Test
	public void test_DefaultLibraryBook_Title_IsNotNull() {
		assertNotNull("Tests that the title of a library book created with the default constructor is not null.",
		              mLibraryBook.titleProperty());
	}
	
	/**
	 * Tests that the audience of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_Audience_HasCorrectAssignedValue() {
		mLibraryBook = new LibraryBook("978-0575097469",
		                               "Warbreaker",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Fantasy,
		                               Audience.Adult,
		                               2011,
		                               Fictionality.Fiction,
		                               1,
		                               5);
		
		final Audience expected = Audience.Adult;
		final Audience actual = mLibraryBook.getAudience();
		
		assertEquals("Tests that the audience of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the author of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_Author_HasCorrectAssignedValue() {
		mLibraryBook = new LibraryBook("978-0765383105",
		                               "Elantris",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Fantasy,
		                               Audience.Adult,
		                               2005,
		                               Fictionality.Fiction,
		                               2,
		                               3);
		
		final String expected = "Brandon Sanderson";
		final String actual = mLibraryBook.getAuthor();
		
		assertEquals("Tests that the author of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the a library book can be compared to another as expected.
	 */
	@Test
	public void test_LibraryBook_Compares_Correctly_With_SameBook() {
		LibraryBook otherBook = null;
		
		try {
			
			mLibraryBook = new LibraryBook("978-0812511819",
			                               "The Eye of the World",
			                               "Robert Jordan",
			                               new BookSeries("The Wheel of Time 1|14"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               1990,
			                               Fictionality.Fiction,
			                               1,
			                               2);
			otherBook = new LibraryBook("978-0812511819",
			                            "The Eye of the World",
			                            "Robert Jordan",
			                            new BookSeries("The Wheel of Time 1|14"),
			                            Genre.Fantasy,
			                            Audience.Adult,
			                            1990,
			                            Fictionality.Fiction,
			                            1,
			                            2);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final int expected = 0;
		final int actual = mLibraryBook.compareTo(otherBook);
		
		assertEquals("Tests that the a library book can be compared to another as expected.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the a library book can be compared to it's sequel as expected.
	 */
	@Test
	public void test_LibraryBook_Compares_Correctly_With_Sequel() {
		LibraryBook otherBook = null;
		
		try {
			mLibraryBook = new LibraryBook("978-0812511819",
			                               "The Eye of the World",
			                               "Robert Jordan",
			                               new BookSeries("The Wheel of Time 1|14"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               1990,
			                               Fictionality.Fiction,
			                               1,
			                               2);
			otherBook = new LibraryBook("978-0812517729",
			                            "The Great Hunt",
			                            "Robert Jordan",
			                            new BookSeries("The Wheel of Time 2|14"),
			                            Genre.Fantasy,
			                            Audience.Adult,
			                            1991,
			                            Fictionality.Fiction,
			                            2,
			                            2);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final int actual = mLibraryBook.compareTo(otherBook);
		final int expected = -2;
		
		assertEquals("Tests that the a library book can be compared to it's sequel as expected.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number of in stock copies of a library book has the correct
	 * assigned value.
	 */
	@Test
	public void test_LibraryBook_Fictionality_HasCorrectAssignedValue() {
		try {
			mLibraryBook = new LibraryBook("978-1524104863",
			                               "White Sand: Volume 1",
			                               "Brandon Sanderson",
			                               new BookSeries("White Sand 1|2"),
			                               Genre.Fantasy,
			                               Audience.YoungAdult,
			                               2017,
			                               Fictionality.Fiction,
			                               3,
			                               3);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final Fictionality expected = Fictionality.Fiction;
		final Fictionality actual = mLibraryBook.getFictionality();
		
		assertEquals("Tests that the number of in stock copies of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the genre of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_Genre_HasCorrectAssignedValue() {
		try {
			mLibraryBook = new LibraryBook("978-0385743570",
			                               "Steelheart",
			                               "Brandon Sanderson",
			                               new BookSeries("The Reckoners 1|4"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               2014,
			                               Fictionality.Fiction,
			                               2,
			                               5);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final Genre expected = Genre.Fantasy;
		final Genre actual = mLibraryBook.getGenre();
		
		assertEquals("Tests that the genre of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the unique ID of a library book has a unique value.
	 */
	@Test
	public void test_LibraryBook_ID_HasUniqueValue() {
		final UUID actual = mLibraryBook.getID();
		
		for (int i = 0; i < 1000; i++) {
			final UUID expected = UUID.randomUUID();
			
			assertNotEquals("Tests that the unique ID of a library book has a unique value.",
			                expected,
			                actual);
		}
		
	}
	
	/**
	 * Tests that the ISBN of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_ISBN_HasCorrectAssignedValue() {
		mLibraryBook = new LibraryBook("978-0399555770",
		                               "Skyward",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Fantasy,
		                               Audience.Adult,
		                               2018,
		                               Fictionality.Fiction,
		                               4,
		                               5);
		
		final String expected = "978-0399555770";
		final String actual = mLibraryBook.getISBN();
		
		assertEquals("Tests that the ISBN of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number of in stock copies of a library book has the correct
	 * assigned value.
	 */
	@Test
	public void test_LibraryBook_NumberOfCopiesInStock_HasCorrectAssignedValue() {
		try {
			mLibraryBook = new LibraryBook("978-0439925509",
			                               "Alcatraz versus the Evil Librarians",
			                               "Brandon Sanderson",
			                               new BookSeries("WAlcatraz versus the Evil Librarians 1|6"),
			                               Genre.Fantasy,
			                               Audience.YoungAdult,
			                               2007,
			                               Fictionality.Fiction,
			                               2,
			                               5);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final int expected = 2;
		final int actual = mLibraryBook.getNumberOfCopiesInStock();
		
		assertEquals("Tests that the number of in stock copies of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the number of total copies of a library book has the correct
	 * assigned value.
	 */
	@Test
	public void test_LibraryBook_NumberOfCopiesTotal_HasCorrectAssignedValue() {
		mLibraryBook = new LibraryBook("978-0765338440",
		                               "The Rithmatist",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Drama,
		                               Audience.YoungAdult,
		                               2012,
		                               Fictionality.Fiction,
		                               1,
		                               3);
		
		final int expected = 3;
		final int actual = mLibraryBook.getNumberOfCopiesTotal();
		
		assertEquals("Tests that the number of total copies of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the publishing year of a library book has the correct assigned
	 * value.
	 */
	@Test
	public void test_LibraryBook_PublishingYear_HasCorrectAssignedValue() {
		mLibraryBook = new LibraryBook("978-1473218055",
		                               "Arcanum Unbounded: The Cosmere Collection",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Fantasy,
		                               Audience.Adult,
		                               2017,
		                               Fictionality.Fiction,
		                               1,
		                               2);
		
		final int expected = 2017;
		final int actual = mLibraryBook.getPublishingYear();
		
		assertEquals("Tests that the publishing year of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the series of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_Series_HasCorrectAssignedValue() {
		try {
			mLibraryBook = new LibraryBook("978-0765311788",
			                               "Mistborn: The Final Empire",
			                               "Brandon Sanderson",
			                               new BookSeries("Mistborn: Era 1 1|3"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               2006,
			                               Fictionality.Fiction,
			                               4,
			                               6);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected = "Mistborn: Era 1";
		final String actual = mLibraryBook.getSeries();
		
		assertEquals("Tests that the series of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the title of a library book has the correct assigned value.
	 */
	@Test
	public void test_LibraryBook_Title_HasCorrectAssignedValue() {
		try {
			mLibraryBook = new LibraryBook("978-0765326355",
			                               "The Way of Kings",
			                               "Brandon Sanderson",
			                               new BookSeries("The Stormlight Archive 1|10"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               2010,
			                               Fictionality.Fiction,
			                               7,
			                               11);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected = "The Way of Kings";
		final String actual = mLibraryBook.getTitle();
		
		assertEquals("Tests that the title of a library book has the correct assigned value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the toString() method of a library book works as expected.
	 */
	@Test
	public void test_LibraryBook_ToString_Matches() {
		mLibraryBook = new LibraryBook("978-1616960926",
		                               "The Emperor's Soul",
		                               "Brandon Sanderson",
		                               new BookSeries(),
		                               Genre.Fantasy,
		                               Audience.Adult,
		                               2012,
		                               Fictionality.Fiction,
		                               2,
		                               3);
		
		final String expected
		    = "The Emperor's Soul [978-1616960926] (2012) by Brandon Sanderson. Adult Fantasy - Fiction. [2/3] copies in stock.";
		final String actual = mLibraryBook.toString();
		
		assertEquals("Tests that the toString() method of a library book works as expected.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the toString() method of a library book works as expected.
	 */
	@Test
	public void test_LibraryBook_ToString_Matches_WithSeries() {
		try {
			mLibraryBook = new LibraryBook("978-0812511819",
			                               "The Eye of the World",
			                               "Robert Jordan",
			                               new BookSeries("The Wheel of Time 1|14"),
			                               Genre.Fantasy,
			                               Audience.Adult,
			                               1990,
			                               Fictionality.Fiction,
			                               1,
			                               2);
		}
		catch (final InvalidBookSeriesNameException e) {
		}
		
		final String expected
		    = "The Eye of the World [978-0812511819] (1990), book 1/14 of The Wheel of Time by Robert Jordan. Adult Fantasy - Fiction. [1/2] copies in stock.";
		final String actual = mLibraryBook.toString();
		
		assertEquals("Tests that the toString() method of a library book works as expected.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that the library book class has no public non-final fields.
	 */
	@Test
	public void test_LibraryBookReflection_NoPublicNonFinalFields() {
		final Field[] declaredFields = LibraryBook.class.getDeclaredFields();
		
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
	
	/**
	 * Tests that the library book class has no static fields.
	 */
	@Test
	public void test_LibraryBookReflection_NoStaticFields() {
		final Field[] declaredFields = LibraryBook.class.getDeclaredFields();
		
		for (final Field field : declaredFields) {
			if (!field.isSynthetic()) {
				final String message = String.format("Field %s can't be static.",
				                                     field.getName());
				
				assertFalse(message,
				            Modifier.isStatic(field.getModifiers()));
			}
		}
	}
	
	/**
	 * Tests that the library book class has no static methods.
	 */
	@Test
	public void test_LibraryBookReflection_NoStaticMethods() {
		final Method[] declaredMethods = LibraryBook.class.getDeclaredMethods();
		
		for (final Method method : declaredMethods) {
			if (!method.isSynthetic()) {
				final String message = String.format("Method %s can't be static.",
				                                     method.getName());
				
				assertFalse(message,
				            Modifier.isStatic(method.getModifiers()));
			}
		}
	}
}