package challenge_Library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookIO {

	public LibraryObject[] retrieveBooksFromFile(final String filePath) {
		
		final LibraryObject[] retrievedBooks = populateBooks(filePath);
		
		return retrievedBooks;
	}
	
	private LibraryObject[] populateBooks(final String filePath) {
		final ArrayList<LibraryObject> retrievedBooks = new ArrayList<LibraryObject>();
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						BookIO.class.getResourceAsStream(filePath)))) {
			
			final String delimiter = ",";
			String line;
			
			while((line = reader.readLine()) != null) {
				final String[] parsedResults = line.split(delimiter);
				
				retrievedBooks.add(new LibraryObject(parsedResults));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LibraryObject[] objects = new LibraryObject[10];
		objects = retrievedBooks.toArray(objects);
		
		return objects;
	}
}