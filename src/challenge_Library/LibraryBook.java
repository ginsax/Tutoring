package challenge_Library;

import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The object that represents a book. This class will be used to display a book
 * and its various properties in a table.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public class LibraryBook implements Comparable<LibraryBook> {
	
	/**
	 * A title that can be used to sort books while ignoring leading words such as
	 * 'a', 'an', & 'the'.
	 */
	private final String mSortingTitle;
	
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
	public LibraryBook() {
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
		
		mSortingTitle = sortingTitle(mTitle);
	}
	
	public LibraryBook(final String IBNS,
	                   final String tittle,
	                   final String auThor,
	                   final BookSeries Siries,
	                   final Genre genre,
	                   final Audience populationTarget,
	                   final int publishingYear,
	                   final Fictionality fictionality,
	                   final int stock,
	                   final int totalStock) {
		mID.set(UUID.randomUUID());
		
		mISBN.set(IBNS);
		mTitle.set(tittle);
		mAuthor.set(auThor);
		mSeries.set(Siries);
		mGenre.set(genre);
		mAudience.set(populationTarget);
		mPublishingYear.set(publishingYear);
		mFictionality.set(fictionality);
		mNumberOfCopiesInStock.set(stock);
		mNumberOfCopiesTotal.set(totalStock);
		
		mSortingTitle = sortingTitle(mTitle);
	}
	
	public ObjectProperty<Audience> audienceProperty() {
		return mAudience;
	}
	
	public StringProperty authorProperty() {
		return mAuthor;
	}
	
	@Override
	public int compareTo(final LibraryBook dummyBook) {
		final int testah = mSortingTitle.compareTo(dummyBook.mSortingTitle);
		/*
		 * if (testah == 0) { return 0; } int actualTestah =
		 * testah/Math.abs(testah); return actualTestah;
		 */
		return testah;
	}
	
	public ObjectProperty<Fictionality> fictionalityProperty() {
		return mFictionality;
	}
	
	public ObjectProperty<Genre> genreProperty() {
		return mGenre;
	}
	
	public Audience getAudience() {
		return mAudience.get();
	}
	
	public String getAuthor() {
		return mAuthor.get();
	}
	
	public Fictionality getFictionality() {
		return mFictionality.get();
	}
	
	public Genre getGenre() {
		return mGenre.getValue();
	}
	
	public UUID getID() {
		return mID.getValue();
	}
	
	public String getISBN() {
		return mISBN.get();
	}
	
	public int getNumberOfCopiesInStock() {
		return mNumberOfCopiesInStock.get();
	}
	
	public int getNumberOfCopiesTotal() {
		return mNumberOfCopiesTotal.get();
	}
	
	public int getPublishingYear() {
		return mPublishingYear.get();
	}
	
	public String getSeries() {
		return mSeries.get().toString();
	}
	
	public String getTitle() {
		return mTitle.get().toString();
	}
	
	public ObjectProperty<UUID> idProperty() {
		return mID;
	}
	
	public StringProperty isbnProperty() {
		return mISBN;
	}
	
	public IntegerProperty numberOfCopiesInStockProperty() {
		return mNumberOfCopiesInStock;
	}
	
	public IntegerProperty numberOfCopiesTotalProperty() {
		return mNumberOfCopiesTotal;
	}
	
	public IntegerProperty publishingYearProperty() {
		return mPublishingYear;
	}
	
	public ObjectProperty<BookSeries> seriesProperty() {
		return mSeries;
	}
	
	private String sortingTitle(final StringProperty actualTitle) {
		final String sortTitle = actualTitle.get().trim();
		/*
		 * if (sortTitle.length()>3) { if (sortTitle.substring(0,
		 * 2).toLowerCase()=="the") {
		 * sortTitle=sortTitle.trim().substring(3).trim(); } else if
		 * (sortTitle.substring(0,1).toLowerCase() == "an") { sortTitle =
		 * sortTitle.trim().substring(2).trim(); } else if
		 * (sortTitle.substring(0,0).toLowerCase() == "a") { sortTitle =
		 * sortTitle.trim().substring(1).trim(); } }
		 */
		return sortTitle;
	}
	
	public StringProperty titleProperty() {
		return mTitle;
	}
	
	@Override
	public String toString() {
		// The Emperor's Soul [978-1616960926] (2012) by Brandon Sanderson. Adult
		// Fantasy - Fiction. [2/3] copies in stock.
		final String returnString = getTitle() + " [" + getISBN() + "] (" +
		                            getPublishingYear() + ")" +
		                            seriesProperty().get()
		                                .getSeriesInformationString() +
		                            " by " + getAuthor() + ". " + getAudience() +
		                            " " + getGenre() + " - " + getFictionality() +
		                            ". [" + getNumberOfCopiesInStock() + "/" +
		                            getNumberOfCopiesTotal() + "] copies in stock.";
		return returnString;
	}
	
}