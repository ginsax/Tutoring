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
	  
	  mSortingTitle = sortingTitle(mTitle);
	}

	public LibraryBook(String IBNS, String tittle, String auThor, BookSeries Siries, Genre genre,
			Audience populationTarget, int publishingYear, Fictionality fictionality, int stock, int totalStock) {
		mID.set(UUID.randomUUID());
		
		  mISBN                  .set(IBNS);
		  mTitle                 .set(tittle);
		  mAuthor                .set(auThor);
		  mSeries                .set(Siries);
		  mGenre                 .set(genre);
		  mAudience              .set(populationTarget);
		  mPublishingYear        .set(publishingYear);
		  mFictionality          .set(fictionality);
		  mNumberOfCopiesInStock .set(stock);
		  mNumberOfCopiesTotal   .set(totalStock);
		  
		  mSortingTitle = sortingTitle(mTitle);
	}

	private String sortingTitle(StringProperty actualTitle) {
		String sortTitle=actualTitle.get().trim();
		/*if (sortTitle.length()>3) {
			if (sortTitle.substring(0, 2).toLowerCase()=="the") {
				sortTitle=sortTitle.trim().substring(3).trim();
			} else if (sortTitle.substring(0,1).toLowerCase() == "an") {
				sortTitle = sortTitle.trim().substring(2).trim();
			} else if (sortTitle.substring(0,0).toLowerCase() == "a") {
				sortTitle = sortTitle.trim().substring(1).trim();
			}
		} */
		return sortTitle;
	}

	public ObjectProperty<UUID> idProperty() {
		return this.mID;
	}


	public StringProperty isbnProperty() {
		return this.mISBN;
	}


	public StringProperty titleProperty() {
		return this.mTitle;
	}


	public StringProperty authorProperty() {
		return this.mAuthor;
	}


	public ObjectProperty<BookSeries> seriesProperty() {
		return this.mSeries;
	}


	public ObjectProperty<Genre> genreProperty() {
		return this.mGenre;
	}


	public ObjectProperty<Audience> audienceProperty() {
		return this.mAudience;
	}


	public IntegerProperty publishingYearProperty() {
		return this.mPublishingYear;
	}


	public ObjectProperty<Fictionality> fictionalityProperty() {
		return this.mFictionality;
	}


	public IntegerProperty numberOfCopiesInStockProperty() {
		return this.mNumberOfCopiesInStock;
	}


	public IntegerProperty numberOfCopiesTotalProperty() {
		return this.mNumberOfCopiesTotal;
	}


	public UUID getID() {
		return this.mID.getValue();
	}


	public String getISBN() {
		return this.mISBN.get();
	}


	public String getTitle() {
		return this.mTitle.get().toString();
	}


	public String getAuthor() {
		return this.mAuthor.get();
	}


	public String getSeries() {
		return this.mSeries.get().toString();
	}


	public Genre getGenre() {
		return this.mGenre.getValue();
	}


	public Audience getAudience() {
		return this.mAudience.get();
	}


	public int getPublishingYear() {
		return this.mPublishingYear.get();
	}


	public Fictionality getFictionality() {
		return this.mFictionality.get();
	}


	public int getNumberOfCopiesInStock() {
		return this.mNumberOfCopiesInStock.get();
	}


	public int getNumberOfCopiesTotal() {
		return this.mNumberOfCopiesTotal.get();
	}
		
	@Override
	public int compareTo(LibraryBook dummyBook) {
		System.out.println(this.mSortingTitle);
		int testah = this.mSortingTitle.compareTo(dummyBook.mSortingTitle);
		if (testah == 0) {
		return 0;
		}
		int actualTestah = testah/Math.abs(testah);
		return actualTestah;
	}
	
	public String toString() {
	//The Emperor's Soul [978-1616960926] (2012) by Brandon Sanderson. Adult Fantasy - Fiction. [2/3] copies in stock.
	String returnString = this.getTitle()+" ["+this.getISBN()+"] ("+this.getPublishingYear()+")" + this.seriesProperty().get().getSeriesInformationString() +" by "
	+this.getAuthor()+". "+this.getAudience()+" "+this.getGenre()+" - "+this.getFictionality()+". ["+this.getNumberOfCopiesInStock()
	+"/"+this.getNumberOfCopiesTotal()+"] copies in stock.";
	return returnString;
	}	
	
	}