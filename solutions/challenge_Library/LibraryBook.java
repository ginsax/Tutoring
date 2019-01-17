package challenge_Library;

import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * The object that represents a book. This class will be used to display a book 
 * and its various properties in a table.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public class LibraryBook implements Comparable<LibraryBook> {
	final String DEFAULT_ISBN = "000-0000000000";
	final String DEFAULT_TITLE = "No Book Title";
	final String DEFAULT_AUTHOR = "No Author";
	final String DEFAULT_SERIES = "No Series";
	final int DEFAULT_PUBLISHING_YEAR = 0000;
	final int DEFAULT_STOCK =  -1;
	
	private String mSortingTitle;
	
	/** The number of in stock copies of this book. */
	private final IntegerProperty mNumberOfCopiesInStock = new SimpleIntegerProperty();
	/** The total number of copies of this book. */
	private final IntegerProperty mNumberOfCopiesTotal = new SimpleIntegerProperty();
	/** The year this book was published. */
	private final IntegerProperty mPublishingYear = new SimpleIntegerProperty();
	
	/** The author of this book. */
	private final StringProperty mAuthor 	= new SimpleStringProperty();
	/** The ISBN identifier of this book. */
	private final StringProperty mISBN 	= new SimpleStringProperty();
	/** The name of this book's series - if any. */
	private final ObjectProperty<BookSeriesInformation> mSeries 	= new SimpleObjectProperty<BookSeriesInformation>();
	/** The title of this book. */
	private final StringProperty mTitle 	= new SimpleStringProperty();

	/** The intended audience of this book. */
	private final ObjectProperty<Audience> mAudience = new SimpleObjectProperty<Audience>();
	/** The genre of this book. */
	private final ObjectProperty<Genre> mGenre = new SimpleObjectProperty<Genre>();
	/** The fictionality of this book. */
	private final ObjectProperty<Fictionality> mFictionality = new SimpleObjectProperty<Fictionality>();
	/** The unique identifier assigned to this book. */
	private final ObjectProperty<UUID> mID = new SimpleObjectProperty<UUID>();
	

	/** Creates a new LibraryObject, instantiating the fields with default values. */
	public LibraryBook() {
		mID.set(UUID.randomUUID());
		
		mISBN		.set(DEFAULT_ISBN);
		mTitle		.set(DEFAULT_TITLE);
		mAuthor.set(DEFAULT_AUTHOR);
		
		parseSeriesFrom									(null);
		parseGenreFrom									(null);
		parseAudienceFrom								(null);
		parsePublishingYearFrom					(null);
		parseFictionalityFrom							(null);
		parseNumberOfInStockCopiesFrom	(null, -1);
		parseTotalNumberOfCopiesFrom 		(null, -1);
		
		mSortingTitle = sortingTitle();
	}
  /**
   * Creates a new LibraryObject, instantiating it with the various fields 
   * within the {@code parsedResults}. The unique identifier is randomised at 
   * this point.
   * @param parsedResults The parsed results that will be used to instantiate 
   * the new LibraryObject.
   */
	public LibraryBook(final String[] parsedResults) {
		int index = 0;
		
		mID.set(UUID.randomUUID());
		
		mISBN		.set(parsedResults[index++].toUpperCase());
		mTitle		.set(parsedResults[index++]);
		mAuthor.set(parsedResults[index++]);
		
		parseSeriesFrom									(parsedResults[index++]);
		parseGenreFrom									(parsedResults[index++]);
		parseAudienceFrom								(parsedResults[index++]);
		parsePublishingYearFrom					(parsedResults[index++]);
		parseFictionalityFrom							(parsedResults[index++]);
		parseNumberOfInStockCopiesFrom	(parsedResults, index++);
		parseTotalNumberOfCopiesFrom 		(parsedResults, index++);
		
		mSortingTitle = sortingTitle();
	}
	

/**
   * Parses the given {@code parsedResult} to determine the series - if any - 
   * this book has a position in.
   * @param parsedResult The parsed results that will be used to determine the  
   * series - if any - this book has a position in.
   */
	private void parseSeriesFrom(final String parsedResult) {
		mSeries.set(new BookSeriesInformation(parsedResult));
	}
  /**
   * Parses the given {@code parsedResult} to determine the genre of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * genre of this book.
   */
	private void parseGenreFrom(final String parsedResult) {
		Genre genre;
		
		try {
			genre = Genre.valueOf(parsedResult) ;
		}
		catch(NullPointerException | IllegalArgumentException e) {
			genre = Genre.DefaultGenre;
		}
		
		mGenre.set(genre);
	}
  /**
   * Parses the given {@code parsedResult} to determine the intended audience 
   * of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * intended audience of this book.
   */
	private void parseAudienceFrom(final String parsedResult) {
		Audience audience;
		
		try {
			audience = Audience.valueOf(parsedResult) ;
		}
		catch(NullPointerException | IllegalArgumentException e) {
			audience = Audience.DefaultAudience;
		}
		
		mAudience.set(audience);
	}
  /**
   * Parses the given {@code parsedResult} to determine the year this book was 
   * published.
   * @param parsedResult The parsed results that will be used to determine the  
   * year this book was published.
   */
	private void parsePublishingYearFrom(final String parsedResult) {
		int publishingYear;
		
		try {
			publishingYear = Integer.parseInt(parsedResult);			
		} 
		catch(NumberFormatException e) {
			publishingYear = DEFAULT_PUBLISHING_YEAR;		
		}
		
		mPublishingYear.set(publishingYear);
	}
  /**
   * Parses the given {@code parsedResult} to determine the fictionality of 
   * copies of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * fictionality of this book.
   */
	private void parseFictionalityFrom(final String parsedResult) {
		Fictionality fictionality;
		
		try {
			fictionality = Fictionality.valueOf(parsedResult) ;
		}
		catch(NullPointerException | IllegalArgumentException e) {
			fictionality = Fictionality.DefaultFictionality;
		}
		
		mFictionality.set(fictionality);
	}
  /**
   * Parses the given {@code parsedResults} to determine the number of copies 
   * of this book that are in stock.
   * @param parsedResults The parsed results that will be used to determine the 
   * number of copies of this book that are in stock.
   * @param index The index to use with the parsed results. Needs to be passed 
   * in to avoid handling {@link IndexOutOfBoundsException 
   * IndexOutOfBoundsExceptions}.
   */
	private void parseNumberOfInStockCopiesFrom(final String[] parsedResults, final int index) {
		int stock;
		
		try {
			stock = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			stock = DEFAULT_STOCK;
		}
		
		mNumberOfCopiesInStock.set(stock);
	}
	/**
	 * Parses the given {@code parsedResults} to determine the total number of 
	 * copies of this book.
	 * @param parsedResults The parsed results that will be used to determine the 
	 * total number of copies of this book.
	 * @param index The index to use with the parsed results. Needs to be passed 
	 * in to avoid handling {@link IndexOutOfBoundsException 
	 * IndexOutOfBoundsExceptions}.
	 */
	private void parseTotalNumberOfCopiesFrom(final String[] parsedResults, final int index) {
		int totalNumberOfCopies;
		
		try {
			totalNumberOfCopies = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			totalNumberOfCopies = DEFAULT_STOCK;
		}
		
		mNumberOfCopiesTotal.set(totalNumberOfCopies);
	}
	

	/**
	 * Gets the fictionality of this book. 'True' values indicate the book is 
	 * fictional, while 'False' values indicate it is nonfiction.
	 * @return Returns the fictionality of this book.
	 */
	public ObjectProperty<Fictionality> fictionalityProperty() {
	  return mFictionality;
	}
	
	/**
	 * Gets the number of in stock copies of this book.
	 * @return Returns the number of in stock copies of this book.
	 */
	public IntegerProperty numberOfCopiesInStockProperty() {
	  return mNumberOfCopiesInStock;
	}
	/**
	 * Gets the total number of copies of this book.
	 * @return Returns the total number of copies of this book.
	 */
	public IntegerProperty numberOfCopiesTotalProperty() {
	  return mNumberOfCopiesTotal;
	}
	/**
	 * Gets the year this book was published - as an integer.
	 * @return Returns the year this book was published - as an integer.
	 */
	public IntegerProperty publishingYearProperty() {
	  return mPublishingYear;
	}
	
	/**
	 * Gets the author of this book.
	 * @return Returns the author of this book.
	 */
	public StringProperty authorProperty() {
	  return mAuthor;
	}
	/**
	 * Gets the ISBN identifier of this book.
	 * @return Returns the ISBN identifier of this book.
	 */
	public StringProperty isbnProperty() {
		return mISBN;
	}
	/**
	 * Gets the name of this book's series - if any.
	 * @return Returns the name of this book's series - if any.
	 */
	public ObservableValue<BookSeriesInformation> seriesProperty() {
		return mSeries;
	}
	/**
	 * Gets the title of this book.
	 * @return Returns the title of this book.
	 */
	public StringProperty titleProperty() {
		return mTitle;
	}
	
	/**
	 * Gets the intended audience of this book.
	 * @return Returns the intended audience of this book.
	 */
	public ObjectProperty<Audience> audienceProperty() {
	  return mAudience;
	}
	/**
	 * Gets the genre of this book.
	 * @return Returns the genre of this book.
	 */
	public ObjectProperty<Genre> genreProperty() {
	  return mGenre;
	}
	/**
	 * Gets the unique identifier assigned to this book. 
	 * @return Returns the unique identifier assigned to this book. 
	 */
	public ObjectProperty<UUID> idProperty() {
		return mID;
	}
	
	/**
	 * Gets the number of in stock copies of this book.
	 * @return Returns the number of in stock copies of this book.
	 */
	public int getNumberOfCopiesInStock() {
	  return mNumberOfCopiesInStock.get();
	}
	/**
	 * Gets the total number of copies of this book.
	 * @return Returns the total number of copies of this book.
	 */
	public int getNumberOfCopiesTotal() {
	  return mNumberOfCopiesTotal.get();
	}
	/**
	 * Gets the year this book was published - as an integer.
	 * @return Returns the year this book was published - as an integer.
	 */
	public int getPublishingYear() {
	  return mPublishingYear.get();
	}
	
	/**
	 * Gets the author of this book.
	 * @return Returns the author of this book.
	 */
	public String getAuthor() {
	  return mAuthor.get();
	}
	/**
	 * Gets the ISBN identifier of this book.
	 * @return Returns the ISBN identifier of this book.
	 */
	public String getISBN() {
		return mISBN.get();
	}
	/**
	 * Gets the name of this book's series - if any.
	 * @return Returns the name of this book's series - if any.
	 */
	public String getSeries() {
		return mSeries.get().seriesProperty().get();
	}
	/**
	 * Gets the title of this book.
	 * @return Returns the title of this book.
	 */
	public String getTitle() {
		return mTitle.get();
	}
	
	/**
	 * Gets the intended audience of this book.
	 * @return Returns the intended audience of this book.
	 */
	public Audience getAudience() {
	  return mAudience.get();
	}
	/**
	 * Gets the fictionality of this book.
	 * @return Returns the fictionality of this book.
	 */
	public Fictionality getFictionality() {
	  return mFictionality.get();
	}
	/**
	 * Gets the genre of this book.
	 * @return Returns the genre of this book.
	 */
	public Genre getGenre() {
	  return mGenre.get();
	}
	/**
	 * Gets the unique identifier assigned to this book. 
	 * @return Returns the unique identifier assigned to this book. 
	 */
	public UUID getID() {
	  return mID.get();
	}

	
	@Override
	public String toString() {
		String seriesInformation = mSeries.get().getSeriesInformationString();
		
		// check if the series information is going to be used.
		seriesInformation = mSeries.get().isPartOfASeries() ? seriesInformation : "";
		
		return String.format("%s [%s] (%d)%s by %s. %s %s - %s. [%d/%d] copies in stock.", 
												mTitle.get(), 
												mISBN.get(), 
												mPublishingYear.get(), 
												seriesInformation, 
												mAuthor.get(), 
												mAudience.get().toString(), 
												mGenre.get().toString(), 
												mFictionality.get(), 
												mNumberOfCopiesInStock.get(), 
												mNumberOfCopiesTotal.get());
	}
	
	/**
	 * Creates a title for this book that has been stripped of leading articles.
	 * @return Returns a title for this book that has been stripped of leading 
	 * articles.
	 */
	private String sortingTitle() {
		String sortingTitle = mTitle.get();
		
		final int indexFirstSpace = sortingTitle.indexOf(" ");
		
		if (indexFirstSpace > 0) {
			final String firstWord = sortingTitle.substring(0, indexFirstSpace);
			if (firstWord.equalsIgnoreCase("a") || 
					firstWord.equalsIgnoreCase("an") || 
					firstWord.equalsIgnoreCase("the")) { 
				sortingTitle = sortingTitle.substring(indexFirstSpace);
			}
		}
		return sortingTitle;
	}
	
	@Override
	public int compareTo(final LibraryBook otherBook) {
		final int comparisonTitle 		= sortingTitle().compareTo(otherBook.sortingTitle());
		final int comparisonAuthor 	= getAuthor().compareTo(otherBook.getAuthor());
		final int comparisonSeries 	= mSeries.get().seriesProperty().get().compareTo(otherBook.mSeries.get().seriesProperty().get());
		
		final int[] comparators = new int[] { 
				comparisonAuthor, 
				comparisonTitle, 
				comparisonSeries, 
				};
		
		for(int comparator : comparators) {
			if (comparator != 0) return comparator;
		}
		
		return 0;
	}
}