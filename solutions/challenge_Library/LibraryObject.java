package challenge_Library;

import java.util.Random;
import java.util.UUID;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LibraryObject {
	private ObjectProperty<UUID> mID = new SimpleObjectProperty<UUID>();
	
	private StringProperty mTitle 		= new SimpleStringProperty();
	private StringProperty mISBN 		= new SimpleStringProperty();
	private StringProperty mAuthor 	= new SimpleStringProperty();
	private StringProperty mSeries 	= new SimpleStringProperty();
	private BooleanProperty mFictionality = new SimpleBooleanProperty();
	
	private IntegerProperty mPublishingYear = new SimpleIntegerProperty();
	private IntegerProperty mOrderInSeries = new SimpleIntegerProperty();

	private ObjectProperty<Genre> mGenre = new SimpleObjectProperty<Genre>();
	private ObjectProperty<Audience> mAudience = new SimpleObjectProperty<Audience>();
	
	private IntegerProperty mInStock = new SimpleIntegerProperty();
	private IntegerProperty mTotalCopies = new SimpleIntegerProperty();

	public LibraryObject(final String bookID, 
										  final String title, 
										  final String author, 
										  final Genre genre, 
										  final Audience audience, 
										  final int year, 
										  final boolean fictionality, 
										  final int inStock, 
										  final int totalCopies) {
		mID.set(UUID.randomUUID());
		
		mISBN						.set(bookID);
		mTitle						.set(title);
		mAuthor				.set(author);
		mGenre					.set(genre);
		mAudience			.set(audience);
		mPublishingYear	.set(year);
		mFictionality			.set(fictionality);
		mInStock				.set(inStock);
		mTotalCopies		.set(totalCopies);
	}

	public LibraryObject(final String[] parsedResults) {
		int index = 0;
		
		mISBN.set(parsedResults[index++].toUpperCase());
		mTitle.set(parsedResults[index++]);
		mAuthor.set(parsedResults[index++]);
		parseSeriesFrom(parsedResults[index]);
		parseOrderInSeriesFrom(parsedResults[index++]);
		parsePublishingYearFrom(parsedResults[index++]);
		parseGenreFrom(parsedResults[index++]);
		parseAudienceFrom(parsedResults[index++]);
		parseFictionalityFrom(parsedResults[index++]);
		parseStock(parsedResults, index++);
		parseTotalCopies(parsedResults, index++);
	}
	
	private void parseSeriesFrom(final String parsedResult) {
		String series;
		
		try {
			series = parsedResult.substring(0, parsedResult.indexOf("|"));
		}
		catch (IndexOutOfBoundsException e) {
			series = "";
		}
		
		mSeries.set(series);
	}
	private void parseOrderInSeriesFrom(final String parsedResult) {
		if(!mSeries.get().isEmpty()) {
			try {
				final String order = parsedResult.substring(parsedResult.indexOf("|") +1);
				mOrderInSeries.set(Integer.parseInt((order)));
			}
			catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	private void parseGenreFrom(final String parsedResult) {
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
	private void parseAudienceFrom(final String parsedResult) {
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
	private void parsePublishingYearFrom(final String parsedResult) {
		int publishingYear;
		
		try {
			publishingYear = Integer.parseInt(parsedResult);			
		} 
		catch(NumberFormatException e) {
			publishingYear = new Random().nextInt(119) + 1900;			
		}
		
		mPublishingYear.set(publishingYear);
	}
	private void parseFictionalityFrom(final String parsedResult) {
		mFictionality.set(Boolean.parseBoolean(parsedResult));
	}
	private void parseStock(final String[] parsedResults, final int index) {
		int stock;
		
		try {
			stock = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			stock = new Random().nextInt(10);
		}
		
		mInStock.set(stock);
	}
	private void parseTotalCopies(final String[] parsedResults, 
														 	final int index) {
		int totalCopies;
		
		try {
			totalCopies = Integer.parseInt(parsedResults[index]);
		} 
		catch(Exception e) {
			totalCopies = mInStock.get() + new Random().nextInt(5);
		}
		
		mTotalCopies.set(totalCopies);
	}
	

	public ObjectProperty<UUID> getID() {
		return mID;
	}
	
	public StringProperty getISBN() {
		return mISBN;
	}

	public StringProperty getTitle() {
		return mTitle;
	}

	public StringProperty getAuthor() {
		return mAuthor;
	}

	public BooleanProperty getFictionality() {
		return mFictionality;
	}

	public IntegerProperty getPublishingYear() {
		return mPublishingYear;
	}

	public ObjectProperty<Genre> getGenre() {
		return mGenre;
	}

	public ObjectProperty<Audience> getAudience() {
		return mAudience;
	}

	public IntegerProperty getInStock() {
		return mInStock;
	}

	public IntegerProperty getTotalCopies() {
		return mTotalCopies;
	}
	
	@Override
	public String toString() {
		String seriesInformation = String.format(", book %d of %s", 
																				 mOrderInSeries.get(), 
																				 mSeries.get());
		seriesInformation = mSeries.get().isEmpty() ? "" : seriesInformation;
		return String.format("%s [%s] (%d)%s by %s. %s %s - %s. [%d/%d] copies in stock.", 
												mTitle.get(), 
												mISBN.get(), 
												mPublishingYear.get(), 
												seriesInformation, 
												mAuthor.get(), 
												mAudience.get().toUserFriendlyString(), 
												mGenre.get().toUserFriendlyString(), 
												createUserFriendlyFictionalityString(), 
												mInStock.get(), 
												mTotalCopies.get());
	}

	private String createUserFriendlyFictionalityString() {
		return mFictionality.get() ? "Fiction" : "Nonfiction";
	}
}