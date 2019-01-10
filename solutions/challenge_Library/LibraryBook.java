package challenge_Library;

import java.util.Random;
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
  
  /** The fictionality of this book. */
  private final StringProperty mFictionality = new SimpleStringProperty();
	
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
	/** The unique identifier assigned to this book. */
	private final ObjectProperty<UUID> mID = new SimpleObjectProperty<UUID>();
	
	
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
		
		parseSeriesFrom									(parsedResults[index]);
//		parsePositionInSeriesFrom					(parsedResults[index++]);
		parseGenreFrom									(parsedResults[index++]);
		parseAudienceFrom								(parsedResults[index++]);
		parsePublishingYearFrom					(parsedResults[index++]);
		parseFictionalityFrom							(parsedResults[index++]);
		parseNumberOfInStockCopiesFrom	(parsedResults, index++);
		parseTotalNumberOfCopiesFrom 		(parsedResults, index++);
	}
	
	
  /**
   * Parses the given {@code parsedResult} to determine the series - if any - 
   * this book has a position in.
   * @param parsedResult The parsed results that will be used to determine the  
   * series - if any - this book has a position in.
   */
	private void parseSeriesFrom               (final String parsedResult) {
		String series;
		
		try {
			series = parsedResult;
		}
		catch (IndexOutOfBoundsException e) {
			series = "";
		}
		
		mSeries.set(new BookSeriesInformation(series));
	}
  /**
   * Parses the given {@code parsedResult} to determine the genre of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * genre of this book.
   */
	private void parseGenreFrom	               (final String parsedResult) {
		Genre genre;
		
		try {
			genre = Genre.valueOf(parsedResult) ;
		}
		catch(IllegalArgumentException e) {
			final int i = new Random().nextInt(Genre.values().length);
			genre = Genre.values()[i];
		}
		
		mGenre.set(genre);
	}
  /**
   * Parses the given {@code parsedResult} to determine the intended audience 
   * of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * intended audience of this book.
   */
	private void parseAudienceFrom	           (final String parsedResult) {
		Audience audience;
		
		try {
			audience = Audience.valueOf(parsedResult) ;
		}
		catch(IllegalArgumentException e) {
			final int i = new Random().nextInt(Audience.values().length);
			audience = Audience.values()[i];
		}
		
		mAudience.set(audience);
	}
  /**
   * Parses the given {@code parsedResult} to determine the year this book was 
   * published.
   * @param parsedResult The parsed results that will be used to determine the  
   * year this book was published.
   */
	private void parsePublishingYearFrom       (final String parsedResult) {
		int publishingYear;
		
		try {
			publishingYear = Integer.parseInt(parsedResult);			
		} 
		catch(NumberFormatException e) {
			publishingYear = new Random().nextInt(119) + 1900;			
		}
		
		mPublishingYear.set(publishingYear);
	}
  /**
   * Parses the given {@code parsedResult} to determine the fictionality of 
   * copies of this book.
   * @param parsedResult The parsed results that will be used to determine the  
   * fictionality of this book.
   */
	private void parseFictionalityFrom         (final String parsedResult) {
		if(parsedResult.equalsIgnoreCase("fiction")) mFictionality.set("Fiction");
		else if(parsedResult.equalsIgnoreCase("nonfiction")) mFictionality.set("Nonfiction");
		else mFictionality.set("Error parsing file.");
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
	private void parseNumberOfInStockCopiesFrom(final String[] parsedResults, 
	                                            final int index) {
		int stock;
		
		try {
			stock = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			stock = new Random().nextInt(10);
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
	private void parseTotalNumberOfCopiesFrom  (final String[] parsedResults, 
														 	                final int index) {
		int totalNumberOfCopies;
		
		try {
			totalNumberOfCopies = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			totalNumberOfCopies = mNumberOfCopiesInStock.get() + new Random().nextInt(5);
		}
		
		mNumberOfCopiesTotal.set(totalNumberOfCopies);
	}
	

	/**
	 * Gets the fictionality of this book. 'True' values indicate the book is 
	 * fictional, while 'False' values indicate it is nonfiction.
	 * @return Returns the fictionality of this book.
	 */
	public StringProperty fictionalityProperty() {
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
	 * Gets the fictionality of this book.
	 * @return Returns the fictionality of this book.
	 */
	public String getFictionality() {
	  return mFictionality.get();
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
		seriesInformation = mSeries.get().isPartOfASeries() ? "" : seriesInformation;
		
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
				comparisonSeries, 
				comparisonAuthor, 
				comparisonTitle, };
		
		for(int comparator : comparators) {
			if (comparator != 0) return comparator;
		}
		
		return 0;
	}
}