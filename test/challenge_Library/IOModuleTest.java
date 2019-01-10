package challenge_Library;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.ObservableList;

public class IOModuleTest { 
	private IOModule mIOModule;
	
	@Before
	public void setupIOModule() {
		mIOModule = new IOModule();
	}
	
	/** Tests that IOModule is not null. */
	@Test 
	public void test_IOModule_IsNotNull() {
		assertNotNull(mIOModule);
	}
	
	/** Tests that IOModule will return a list that is not null when an empty file name is given. */
	@Test 
	public void test_IOModule_ReturnedListIsNotNullWhenEmptyFileNameIsGiven() {
		final ObservableList<LibraryBook> retrievedBooks = mIOModule.retrieveBooksFromFile("");
		
		assertNotNull(retrievedBooks);
	}
	/** Tests that IOModule will return an empty list when an empty file name is given. */
	@Test 
	public void test_IOModule_ReturnedListIsNotEmptyWhenEmptyFileNameIsGiven() {
		final ObservableList<LibraryBook> retrievedBooks = mIOModule.retrieveBooksFromFile("");
		
		assertTrue("Tests that IOModule will return an empty list when an empty file name is given.", retrievedBooks.isEmpty());
	}
	
	/** Tests that IOModule will throw a NullPointerException if an invalid file name is given. */
	@Test 
	public void test_IOModule_ThrowsNullPointerExceptionWhenFileNameIsInvalid() {
		mIOModule.retrieveBooksFromFile("Test.cs v");
		mIOModule.getErrorAlert().close();
	}
	/** Tests that IOModule will throw a IOException if an incorrect file name is given. */
	@Test 
	public void test_IOModule_ThrowsIOExceptionWhenFileNameIsIncorrect() {
		mIOModule.retrieveBooksFromFile("Incorrect file name");
		mIOModule.getErrorAlert().close();
	}	
	
	/** Tests that IOModule will retrieve books from a file as expected when a correct file name is given. */
	@Test 
	public void test_IOModule_RetrievedListIsNotNullWhenFileNameIsCorrect() {
		ObservableList<LibraryBook> retrievedBooks = mIOModule.retrieveBooksFromFile("Test.csv");
		
		assertNotNull("Tests that IOModule will retrieve books from a file as expected when a correct file name is given.", retrievedBooks);
	}
	/** Tests that IOModule will retrieve books from a file as expected when a correct file name is given. */
	@Test 
	public void test_IOModule_RetrievesListAsExpectedWhenFileNameIsCorrect() {
		ObservableList<LibraryBook> retrievedBooks = mIOModule.retrieveBooksFromFile("Test.csv");
		
		assertFalse("Tests that IOModule will retrieve books from a file as expected when a correct file name is given.", retrievedBooks.isEmpty());
	}
}