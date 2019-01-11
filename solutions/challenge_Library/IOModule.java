package challenge_Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Module that is designed to parse a text file for information relevant to 
 * {@link LibraryBook LibraryBooks}. The intended delimiter is a comma (',').
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
public class IOModule {
  /** 
   * Alert that will be displayed if there is an issue with retrieving books 
   * from a file.
   * */
	private Alert mErrorAlert;
	
	
	/**
	 * Retrieves all LibraryBooks from a file using the given {@code filePath}.
	 * @param filePath String name of the file to be parsed.
	 * @return Returns an observable list of LibraryBooks.
	 */
	public ObservableList<LibraryBook> retrieveBooksFromFile(final String filePath) {
		final ObservableList<LibraryBook> retrievedBooks = FXCollections.observableArrayList();
		
		if	(filePath.isEmpty()) return retrievedBooks;
	    
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream(filePath)))) {
			
			final String delimiter = ",";
			String line;
			
			while((line = reader.readLine()) != null) {
				final String[] parsedResults = line.split(delimiter);
				
				retrievedBooks.add(new LibraryBook(parsedResults));
			}
			
		} catch (IOException | NullPointerException e) {
			String errorMessage = e.getLocalizedMessage();
			
			if (errorMessage == null || errorMessage.isEmpty()) {
				errorMessage = "An unexpected error occured during file IO.";
			}
			mErrorAlert = new Alert(AlertType.ERROR, 
					errorMessage, 
					ButtonType.OK);
			mErrorAlert.show();
		}
		
		return retrievedBooks;
	}
	
	/**
	 * Returns the alert dialog that is designed to be displayed in the event of 
	 * any IOExceptions thrown.
	 * @return Returns the error alert dialog.
	 */
	public Alert getErrorAlert() {
		return mErrorAlert;
	}
}