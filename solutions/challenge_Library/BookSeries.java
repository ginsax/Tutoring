package challenge_Library;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Custom class that holds the information related to a book series. Required to
 * have an accurate sorting for book series.
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
public class BookSeries implements Comparable<BookSeries> {
	
	/** The name of this series. */
	private final StringProperty mSeriesName = new SimpleStringProperty();
	
	/** The total number of books in this series. */
	private int mTotalNumberOfBooksInSeries;
	
	/** The position this book takes within the series. */
	private double mPositionInSeries;
	
	
	/**
	 * Creates a new BookSeriesInformation object, with the default series name.
	 */
	public BookSeries() {
		mSeriesName.set(CommonConstants.DEFAULT_SERIES);
	}
	
	/**
	 * Constructor that receives a string containing book information to parse.
	 * @param seriesInformationToParse String containing information about the
	 *          series that needs to be parsed.
	 * @throws InvalidBookSeriesNameException
	 */
	public BookSeries(final String seriesInformationToParse) throws InvalidBookSeriesNameException {
		try {
			mSeriesName.set(seriesInformationToParse.substring(0,
			                                                   seriesInformationToParse
			                                                       .lastIndexOf(" ")));
		}
		catch (final Exception e) {
			mSeriesName.set(CommonConstants.DEFAULT_SERIES);
		}
		
		if (seriesInformationToParse != null &&
		    seriesInformationToParse.contains("|")) {
			try {
				final int indexDelimiter = seriesInformationToParse.indexOf("|");
				final int indexSpace = seriesInformationToParse.lastIndexOf(" ");
				final String order = seriesInformationToParse.substring(indexSpace + 1,
				                                                        indexDelimiter);
				mTotalNumberOfBooksInSeries = Integer
				    .parseInt(seriesInformationToParse.substring(indexDelimiter + 1));
				mPositionInSeries = Double.parseDouble(order);
			}
			catch (final Exception e) {
				throw new InvalidBookSeriesNameException();
			}
		}
	}
	
	@Override
	public int compareTo(final BookSeries otherBookSeries) {
		int comparisonSeriesName
		    = mSeriesName.get().compareTo(otherBookSeries.seriesProperty().get());
		double comparisonPosition
		    = mPositionInSeries - otherBookSeries.mPositionInSeries;
		int comparisonTotal = mTotalNumberOfBooksInSeries -
		                      otherBookSeries.mTotalNumberOfBooksInSeries;
		
		comparisonSeriesName = comparisonSeriesName < 0
		                                                ? -1
		                                                : comparisonSeriesName > 0
		                                                                           ? 1
		                                                                           : 0;
		comparisonPosition = comparisonPosition < 0
		                                            ? -1
		                                            : comparisonPosition > 0
		                                                                     ? 1
		                                                                     : 0;
		comparisonTotal = comparisonTotal < 0
		                                      ? -1
		                                      : comparisonTotal > 0
		                                                            ? 1
		                                                            : 0;
		
		if (comparisonSeriesName != 0) {
			return comparisonSeriesName;
		}
		else if (comparisonPosition != 0) {
			return (int) comparisonPosition;
		}
		else if (comparisonTotal != 0) {
			return comparisonTotal;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Creates a string containing user-friendly information about this book and
	 * its position with its series.
	 * @return Returns a user-friendly string about this book and its position
	 *         within its series.
	 */
	public String getSeriesInformationString() {
		if (!isPartOfASeries()) {
			return "";
		}
		
		String position;
		if (mPositionInSeries % 1 == 0) {
			position = "%.0f";
		}
		else {
			position = "%.1f";
		}
		final String seriesInformation
		    = String.format(", book " + position + "/%d of %s",
		                    mPositionInSeries,
		                    mTotalNumberOfBooksInSeries,
		                    toString());
		return seriesInformation;
	}
	
	/**
	 * Checks if this book is part of a series.
	 * @return Returns true if the series name is not empty, otherwise false is
	 *         returned.
	 */
	public boolean isPartOfASeries() {
		return toString() != CommonConstants.DEFAULT_SERIES;
	}
	
	/**
	 * Gets the name of this series.
	 * @return Returns the name of this series.
	 */
	public StringProperty seriesProperty() {
		return mSeriesName;
	}
	
	@Override
	public String toString() {
		return mSeriesName.get();
	}
}