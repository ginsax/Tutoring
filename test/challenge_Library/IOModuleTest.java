package challenge_Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.ObservableList;

/**
 * Test class that is intended to test an {@link IOModule}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
public class IOModuleTest {
	
	/** The IOModule that is to be tested. */
	private IOModule mIOModule;
	
	
	/**
	 * Initializes the IOModule. Required to wipe all old information.
	 */
	@Before
	public void setupIOModule() {
		mIOModule = new IOModule();
	}
	
	/**
	 * Tests that IOModule will replace an invalid book audience with the default
	 * book audience.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Audience()
	                                                    throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final Audience expected = CommonConstants.DEFAULT_AUDIENCE;
		final Audience actual = retrievedBooks.get(5).getAudience();
		
		assertEquals("Tests that IOModule will replace an invalid book audience with the default book audience.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book author with the default
	 * book author value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Author()
	                                                  throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final String expected = CommonConstants.DEFAULT_AUTHOR;
		final String actual = retrievedBooks.get(2).getAuthor();
		
		assertEquals("Tests that IOModule will replace an invalid book author with the default book author value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book fictionality with the
	 * default book fictionality.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Fictionality()
	                                                        throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final Fictionality expected = CommonConstants.DEFAULT_FICTIONALITY;
		final Fictionality actual = retrievedBooks.get(7).getFictionality();
		
		assertEquals("Tests that IOModule will replace an invalid book fictionality with the default book fictionality.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book genre with the default
	 * book genre.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Genre()
	                                                 throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final Genre expected = CommonConstants.DEFAULT_GENRE;
		final Genre actual = retrievedBooks.get(4).getGenre();
		
		assertEquals("Tests that IOModule will replace an invalid book genre with the default book genre.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid ISBN value with the default
	 * ISBN value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_ISBN()
	                                                throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final String expected = CommonConstants.DEFAULT_ISBN;
		final String actual = retrievedBooks.get(0).getISBN();
		
		assertEquals("Tests that IOModule will replace an invalid ISBN value with the default ISBN value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid number of books in stock with
	 * the default number of books in stock value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_NumberOfCopiesInStock()
	                                                                 throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final int expected = CommonConstants.DEFAULT_STOCK;
		final int actual = retrievedBooks.get(8).getNumberOfCopiesInStock();
		
		assertEquals("Tests that IOModule will replace an invalid number of books in stock with the default number of books in stock value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book total stock with the
	 * default book total stock value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_NumberOfCopiesTotal()
	                                                               throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final int expected = CommonConstants.DEFAULT_STOCK;
		final int actual = retrievedBooks.get(9).getNumberOfCopiesTotal();
		
		assertEquals("Tests that IOModule will replace an invalid book total stock with the default book total stock value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book publishing year with the
	 * default book publishing year value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_PublishingYear()
	                                                          throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final int expected = CommonConstants.DEFAULT_PUBLISHING_YEAR;
		final int actual = retrievedBooks.get(6).getPublishingYear();
		
		assertEquals("Tests that IOModule will replace an invalid book publishing year with the default book publishing year value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book series with the default
	 * book series value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Series()
	                                                  throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final String expected = CommonConstants.DEFAULT_SERIES;
		final String actual = retrievedBooks.get(3).getSeries();
		
		assertEquals("Tests that IOModule will replace an invalid book series with the default book series value.",
		             expected,
		             actual);
	}
	
	/**
	 * Tests that IOModule will replace an invalid book title with the default
	 * book title value.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_HandlesInvalid_Title()
	                                                 throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("InvalidTest.csv");
		
		final String expected = CommonConstants.DEFAULT_TITLE;
		final String actual = retrievedBooks.get(1).getTitle();
		
		assertEquals("Tests that IOModule will replace an invalid book title with the default book title value.",
		             expected,
		             actual);
	}
	
	/** Tests that IOModule is not null. */
	@Test
	public void test_IOModule_IsNotNull() {
		assertNotNull(mIOModule);
	}
	
	/**
	 * Tests that IOModule will retrieve books from a file as expected when a
	 * correct file name is given.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_RetrievedListIsNotNullWhenFileNameIsCorrect()
	                                                                        throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("Test.csv");
		
		assertNotNull("Tests that IOModule will retrieve books from a file as expected when a correct file name is given.",
		              retrievedBooks);
	}
	
	/**
	 * Tests that IOModule will retrieve books from a file as expected when a
	 * correct file name is given.
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_IOModule_RetrievesListAsExpectedWhenFileNameIsCorrect()
	                                                                         throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("Test.csv");
		
		assertFalse("Tests that IOModule will retrieve books from a file as expected when a correct file name is given.",
		            retrievedBooks.isEmpty());
	}
	
	/**
	 * Tests that IOModule will return an empty list when an empty file name is
	 * given.
	 * @throws EmptyFileNameException
	 */
	@Test (expected = EmptyFileNameException.class)
	public void test_IOModule_ReturnedListIsNotEmpty_WhenEmptyFileNameIsGiven()
	                                                                            throws EmptyFileNameException {
		mIOModule.retrieveBooksFromFile("");
	}
	
	/**
	 * Tests that IOModule will return a list that is not null when an empty file
	 * name is given.
	 * @throws EmptyFileNameException
	 */
	@Test (expected = EmptyFileNameException.class)
	public void test_IOModule_ReturnedListIsNull_WhenEmptyFileNameIsGiven()
	                                                                        throws EmptyFileNameException {
		final ObservableList<SolutionLibraryBook> retrievedBooks
		    = mIOModule.retrieveBooksFromFile("");
		
		assertNull(retrievedBooks);
	}
	
	/**
	 * Tests that IOModule will throw a EmptyFileNameException if an incorrect
	 * file name is given.
	 * @throws EmptyFileNameException
	 */
	@Test (expected = EmptyFileNameException.class)
	public void test_IOModule_ThrowsEmptyFileNameException_WhenFileNameIsIncorrect()
	                                                                                 throws EmptyFileNameException {
		mIOModule.retrieveBooksFromFile("Incorrect file name");
	}
	
	/**
	 * Tests that IOModule will throw an EmptyFileNameException if an invalid file
	 * name is given.
	 * @throws EmptyFileNameException
	 */
	@Test (expected = EmptyFileNameException.class)
	public void test_IOModule_ThrowsEmptyFileNameException_WhenFileNameIsInvalid()
	                                                                               throws EmptyFileNameException {
		mIOModule.retrieveBooksFromFile("Test.cs v");
	}
	
	/**
	 * Tests that IOModule will throw a EmptyFileNameException if a null file name
	 * is given.
	 * @throws EmptyFileNameException
	 */
	@Test (expected = EmptyFileNameException.class)
	public void test_IOModule_ThrowsEmptyFileNameException_WhenFileNameIsNull()
	                                                                            throws EmptyFileNameException {
		mIOModule.retrieveBooksFromFile(null);
	}
}