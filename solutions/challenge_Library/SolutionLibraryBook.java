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
public class SolutionLibraryBook implements Comparable<SolutionLibraryBook> {
	
	/**
	 * A title that can be used to sort books while ignoring leading words such as
	 * 'a', 'an', & 'the'.
	 */
	private String mSortingTitle;
	
	/** The number of in stock copies of this book. */
	private final IntegerProperty	mNumberOfCopiesInStock	= new SimpleIntegerProperty();
	/** The total number of copies of this book. */
	private final IntegerProperty	mNumberOfCopiesTotal		= new SimpleIntegerProperty();
	/** The year this book was published. */
	private final IntegerProperty	mPublishingYear					= new SimpleIntegerProperty();
	
	/** The author of this book. */
	private final StringProperty							mAuthor	= new SimpleStringProperty();
	/** The ISBN identifier of this book. */
	private final StringProperty							mISBN		= new SimpleStringProperty();
	/** The name of this book's series - if any. */
	private final ObjectProperty<BookSeries>	mSeries	= new SimpleObjectProperty<>();
	/** The title of this book. */
	private final StringProperty							mTitle	= new SimpleStringProperty();
	
	/** The intended audience of this book. */
	private final ObjectProperty<Audience>			mAudience			= new SimpleObjectProperty<>();
	/** The genre of this book. */
	private final ObjectProperty<Genre>					mGenre				= new SimpleObjectProperty<>();
	/** The fictionality of this book. */
	private final ObjectProperty<Fictionality>	mFictionality	= new SimpleObjectProperty<>();
	/** The unique identifier assigned to this book. */
	private final ObjectProperty<UUID>					mID						= new SimpleObjectProperty<>();
	
	
	/**
	 * Creates a new LibraryObject, instantiating the fields with default values.
	 */
	public SolutionLibraryBook() {
		mID.set(UUID.randomUUID());
		
		mISBN.set(CommonConstants.DEFAULT_ISBN);
		mTitle.set(CommonConstants.DEFAULT_TITLE);
		mAuthor.set(CommonConstants.DEFAULT_AUTHOR);
		mSeries.set(new BookSeries());
		mGenre.set(CommonConstants.DEFAULT_GENRE);
		mAudience.set(CommonConstants.DEFAULT_AUDIENCE);
		mPublishingYear.set(CommonConstants.DEFAULT_PUBLISHING_YEAR);
		mFictionality.set(CommonConstants.DEFAULT_FICTIONALITY);
		mNumberOfCopiesInStock.set(CommonConstants.DEFAULT_STOCK);
		mNumberOfCopiesTotal.set(CommonConstants.DEFAULT_STOCK);
		
		postSetupInitialization();
	}
	
	/**
	 * Creates a new LibraryObject, instantiating the fields with the given data.
	 * @param isbn The unique international number assigned to this book.
	 * @param title The title of this book.
	 * @param author The author of this book.
	 * @param series The series information of this book.
	 * @param genre The genre of this book.
	 * @param audience The audience of this book.
	 * @param publishingYear The year this book was published.
	 * @param fictionality The fictionality of this book.
	 * @param numberOfCopiesInStock The number of copies of this book that are
	 *          currently in stock.
	 * @param numberOfCopiesTotal The total number of copies of this book.
	 */
	public SolutionLibraryBook(final String isbn,
	                           final String title,
	                           final String author,
	                           final BookSeries series,
	                           final Genre genre,
	                           final Audience audience,
	                           final int publishingYear,
	                           final Fictionality fictionality,
	                           final int numberOfCopiesInStock,
	                           final int numberOfCopiesTotal) {
		mID.set(UUID.randomUUID());
		
		mISBN.set(isbn);
		mTitle.set(title);
		mAuthor.set(author);
		mSeries.set(series);
		mGenre.set(genre);
		mAudience.set(audience);
		mPublishingYear.set(publishingYear);
		mFictionality.set(fictionality);
		mNumberOfCopiesInStock.set(numberOfCopiesInStock);
		mNumberOfCopiesTotal.set(numberOfCopiesTotal);
		
		postSetupInitialization();
	}
	
	/**
	 * Gets the intended audience of this book.
	 * @return Returns the intended audience of this book.
	 */
	public ObjectProperty<Audience> audienceProperty() {
		return mAudience;
	}
	
	/**
	 * Gets the author of this book.
	 * @return Returns the author of this book.
	 */
	public StringProperty authorProperty() {
		return mAuthor;
	}
	
	@Override
	public int compareTo(final SolutionLibraryBook otherBook) {
		final int comparisonAuthor = getAuthor().compareTo(otherBook.getAuthor());
		final int comparisonSeries = mSeries.get().seriesProperty().get()
		    .compareTo(otherBook.mSeries.get().seriesProperty().get());
		final int comparisonTitle = mSortingTitle
		    .compareTo(otherBook.mSortingTitle);
		
		final int[] comparators = new int[] {
		    comparisonAuthor, comparisonSeries, comparisonTitle,
		};
		
		for (final int comparator : comparators) {
			if (comparator != 0) {
				return comparator;
			}
		}
		
		return 0;
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
	 * Gets the genre of this book.
	 * @return Returns the genre of this book.
	 */
	public ObjectProperty<Genre> genreProperty() {
		return mGenre;
	}
	
	/**
	 * Gets the intended audience of this book.
	 * @return Returns the intended audience of this book.
	 */
	public Audience getAudience() {
		return mAudience.get();
	}
	
	/**
	 * Gets the author of this book.
	 * @return Returns the author of this book.
	 */
	public String getAuthor() {
		return mAuthor.get();
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
	
	/**
	 * Gets the ISBN identifier of this book.
	 * @return Returns the ISBN identifier of this book.
	 */
	public String getISBN() {
		return mISBN.get();
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
	 * Gets the unique identifier assigned to this book.
	 * @return Returns the unique identifier assigned to this book.
	 */
	public ObjectProperty<UUID> idProperty() {
		return mID;
	}
	
	/**
	 * Gets the ISBN identifier of this book.
	 * @return Returns the ISBN identifier of this book.
	 */
	public StringProperty isbnProperty() {
		return mISBN;
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
	
	/** Creates the sorting string as well as determine if it is in stock. */
	private void postSetupInitialization() {
		mSortingTitle = sortingTitle();
	}
	
	/**
	 * Gets the year this book was published - as an integer.
	 * @return Returns the year this book was published - as an integer.
	 */
	public IntegerProperty publishingYearProperty() {
		return mPublishingYear;
	}
	
	/**
	 * Gets the name of this book's series - if any.
	 * @return Returns the name of this book's series - if any.
	 */
	public ObservableValue<BookSeries> seriesProperty() {
		return mSeries;
	}
	
	/**
	 * Creates a title for this book that has been stripped of leading articles.
	 * @return Returns a title for this book that has been stripped of leading
	 *         articles.
	 */
	private String sortingTitle() {
		String sortingTitle = mTitle.get();
		
		final int indexFirstSpace = sortingTitle.indexOf(" ");
		
		if (indexFirstSpace > 0) {
			final String firstWord = sortingTitle.substring(0,
			                                                indexFirstSpace);
			if (firstWord.equalsIgnoreCase("a") || firstWord.equalsIgnoreCase("an") ||
			    firstWord.equalsIgnoreCase("the")) {
				
				sortingTitle = sortingTitle.substring(indexFirstSpace + 1);
			}
		}
		
		return sortingTitle;
	}
	
	/**
	 * Gets the title of this book.
	 * @return Returns the title of this book.
	 */
	public StringProperty titleProperty() {
		return mTitle;
	}
	
	@Override
	public String toString() {
		String seriesInformation = mSeries.get().getSeriesInformationString();
		
		// check if the series information is going to be used.
		seriesInformation = mSeries.get().isPartOfASeries()
		                                                    ? seriesInformation
		                                                    : "";
		
		return String
		    .format("%s [%s] (%d)%s by %s. %s %s - %s. [%d/%d] copies in stock.",
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
}