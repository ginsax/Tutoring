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
	
	/**
	 * A title that can be used to sort books while ignoring leading words such 
	 * as 'a', 'an', & 'the'.
	 */
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
	private final ObjectProperty<BookSeries> mSeries 	= new SimpleObjectProperty<BookSeries>();
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
	  
	  mISBN                  .set(CommonConstants.DEFAULT_ISBN);
	  mTitle                 .set(CommonConstants.DEFAULT_TITLE);
	  mAuthor                .set(CommonConstants.DEFAULT_AUTHOR);
	  mSeries                .set(new BookSeries());
	  mGenre                 .set(CommonConstants.DEFAULT_GENRE);
	  mAudience              .set(CommonConstants.DEFAULT_AUDIENCE);
	  mPublishingYear        .set(CommonConstants.DEFAULT_PUBLISHING_YEAR);
	  mFictionality          .set(CommonConstants.DEFAULT_FICTIONALITY);
	  mNumberOfCopiesInStock .set(CommonConstants.DEFAULT_STOCK);
	  mNumberOfCopiesTotal   .set(CommonConstants.DEFAULT_STOCK);
	  
	  mSortingTitle = sortingTitle();
	}
		
}