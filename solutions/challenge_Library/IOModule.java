package challenge_Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

// TODO: Auto-generated Javadoc
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
			int index;
			
			while((line = reader.readLine()) != null) {
				final String[] parsedResults = line.split(delimiter);
				index = 0;
				
		    final String isbn                   = parseISBNFrom(parsedResults[index++]);
		    final String title                  = parseTitleFrom(parsedResults[index++]);
		    final String author                 = parseAuthorFrom(parsedResults[index++]);
		    final BookSeriesInformation series  = parseSeriesFrom(parsedResults[index++]);
		    final Genre genre                   = parseGenreFrom(parsedResults[index++]);
		    final Audience audience             = parseAudienceFrom(parsedResults[index++]);
		    final int publishingYear            = parsePublishingYearFrom(parsedResults[index++]);
		    final Fictionality fictionality     = parseFictionalityFrom(parsedResults[index++]);
		    final int numberOfCopiesInStock     = parseNumberOfCopiesInStockFrom(parsedResults, index++);
		    final int numberOfCopiesTotal       = parseNumberOfCopiesTotalFrom(parsedResults, index++);
		    
		    final LibraryBook libraryBook = new LibraryBook(isbn, 
		                                                    title, 
		                                                    author, 
		                                                    series, 
		                                                    genre, 
		                                                    audience, 
		                                                    publishingYear, 
		                                                    fictionality, 
		                                                    numberOfCopiesInStock, 
		                                                    numberOfCopiesTotal);
		    
				retrievedBooks.add(libraryBook);
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
   * Parses the given {@code parsedResult} to determine the ISBN of a book.
   * @param parsedResult The parsed results that will be used to determine the  
   * ISBN of a book.
   * @return Returns the ISBN of a book.
   */
  private String parseISBNFrom(final String parsedResult) {
    String isbn;
    
    try {
      isbn = parsedResult;
    }
    catch(NullPointerException | IllegalArgumentException e) {
      isbn = CommonConstants.DEFAULT_ISBN;
    }
    
    return isbn;
  }
  /**
   * Parses the given {@code parsedResult} to determine the title of a book.
   * @param parsedResult The parsed results that will be used to determine the  
   * title of a book.
   * @return Returns the title of a book.
   */
  private String parseTitleFrom(final String parsedResult) {
    String title;
    
    try {
      title = parsedResult;
    }
    catch(NullPointerException | IllegalArgumentException e) {
      title = CommonConstants.DEFAULT_TITLE;
    }
    
    return title;
  }
	/**
   * Parses the given {@code parsedResult} to determine the author of a book.
   * @param parsedResult The parsed results that will be used to determine the  
   * author of a book.
   * @return Returns the author of a book.
   */
  private String parseAuthorFrom(final String parsedResult) {
    String author;
    
    try {
      author = parsedResult;
    }
    catch(NullPointerException | IllegalArgumentException e) {
      author = CommonConstants.DEFAULT_AUTHOR;
    }
    
    return author;
  }
	/**
	 * Parses the given {@code parsedResult} to determine the series - if any - 
	 * a book has a position in.
	 * @param parsedResult The parsed results that will be used to determine the  
	 * series - if any - a book has a position in.
	 * @return Returns the book series information of this book.
	 */
	private BookSeriesInformation parseSeriesFrom(final String parsedResult) {
	  return new BookSeriesInformation(parsedResult);
	}
	/**
	 * Parses the given {@code parsedResult} to determine the genre of a book.
	 * @param parsedResult The parsed results that will be used to determine the  
	 * genre of a book.
	 * @return Returns the genre of a book.
	 */
	private Genre parseGenreFrom(final String parsedResult) {
	  Genre genre;
	  
	  try {
	    genre = Genre.valueOf(parsedResult) ;
	  }
	  catch(NullPointerException | IllegalArgumentException e) {
	    genre = CommonConstants.DEFAULT_GENRE;
	  }
	  
	  return genre;
	}
	/**
	 * Parses the given {@code parsedResult} to determine the intended audience 
	 * of a book.
	 * @param parsedResult The parsed results that will be used to determine the  
	 * intended audience of a book.
	 * @return Returns the intended audience of a book.
	 */
	private Audience parseAudienceFrom(final String parsedResult) {
	  Audience audience;
	  
	  try {
	    audience = Audience.valueOf(parsedResult) ;
	  }
	  catch(NullPointerException | IllegalArgumentException e) {
	    audience = CommonConstants.DEFAULT_AUDIENCE;
	  }
	  
	  return audience;
	}
	/**
	 * Parses the given {@code parsedResult} to determine the year a book was 
	 * published.
	 * @param parsedResult The parsed results that will be used to determine the  
	 * year a book was published.
	 * @return Returns the year a book was published.
	 */
	private int parsePublishingYearFrom(final String parsedResult) {
	  int publishingYear;
	  
	  try {
	    publishingYear = Integer.parseInt(parsedResult);      
	  } 
	  catch(NumberFormatException e) {
	    publishingYear = CommonConstants.DEFAULT_PUBLISHING_YEAR;   
	  }
	  
	  return publishingYear;
	}
	/**
	 * Parses the given {@code parsedResult} to determine the fictionality of 
	 * copies of a book.
	 * @param parsedResult The parsed results that will be used to determine the  
	 * fictionality of a book.
	 * @return Returns the fictionality of a book.
	 */
	private Fictionality parseFictionalityFrom(final String parsedResult) {
	  Fictionality fictionality;
	  
	  try {
	    fictionality = Fictionality.valueOf(parsedResult) ;
	  }
	  catch(NullPointerException | IllegalArgumentException e) {
	    fictionality = CommonConstants.DEFAULT_FICTIONALITY;
	  }
	  
	  return fictionality;
	}
	/**
	 * Parses the given {@code parsedResults} to determine the number of copies 
	 * of a book that are in stock.
	 * @param parsedResults The parsed results that will be used to determine the 
	 * number of copies of a book that are in stock.
	 * @param index The index to use with the parsed results. Needs to be passed 
	 * in to avoid handling {@link IndexOutOfBoundsException 
	 * IndexOutOfBoundsExceptions}.
	 * @return Returns the number of copies of a book that are in stock.
	 */
	private int parseNumberOfCopiesInStockFrom(final String[] parsedResults, final int index) {
	  int numberOfCopiesInStock;
	  
	  try {
	    numberOfCopiesInStock = Integer.parseInt(parsedResults[index]);
	  } 
	  catch(Exception e) {
	    numberOfCopiesInStock = CommonConstants.DEFAULT_STOCK;
	  }
	  
	  return numberOfCopiesInStock;
	}
	/**
	 * Parses the given {@code parsedResults} to determine the total number of 
	 * copies of a book.
	 * @param parsedResults The parsed results that will be used to determine the 
	 * total number of copies of a book.
	 * @param index The index to use with the parsed results. Needs to be passed 
	 * in to avoid handling {@link IndexOutOfBoundsException 
	 * IndexOutOfBoundsExceptions}.
	 * @return Returns the total number of copies of a book.
	 */
	private int parseNumberOfCopiesTotalFrom(final String[] parsedResults, final int index) {
	  int numberOfCopiesTotal;
	  
	  try {
	    numberOfCopiesTotal = Integer.parseInt(parsedResults[index]);
	  } 
	  catch(Exception e) {
	    numberOfCopiesTotal = CommonConstants.DEFAULT_STOCK;
	  }
	  
	  return numberOfCopiesTotal;
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