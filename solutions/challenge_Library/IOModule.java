package challenge_Library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class IOModule {
	private Alert mErrorAlert;

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
	
	public Alert getErrorAlert() {
		return mErrorAlert;
	}
}