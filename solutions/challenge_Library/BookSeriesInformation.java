package challenge_Library;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookSeriesInformation implements Comparable<BookSeriesInformation> {
	private final StringProperty mSeriesName = new SimpleStringProperty();
	private int mTotalNumberOfBooksInSeries;
	private double mPositionInSeries;
	
	
	public BookSeriesInformation(final String parsedResult) {
		try {
			mSeriesName.set(parsedResult.substring(0, parsedResult.lastIndexOf(" ")));
		}
		catch (IndexOutOfBoundsException e) {
			mSeriesName.set("");
		}
		
		if(parsedResult.contains("|")) {
			try {
				final int indexDelimiter 	= parsedResult.indexOf("|");
				final int indexSpace 		= parsedResult.lastIndexOf(" ");
				final String order = parsedResult.substring(indexSpace + 1, indexDelimiter);
				mTotalNumberOfBooksInSeries = Integer.parseInt(parsedResult.substring(indexDelimiter + 1));
				mPositionInSeries  = Double.parseDouble(order);
			}
			catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	
	public boolean isPartOfASeries() {
		return !mSeriesName.get().isEmpty();
	}
	
	public String getSeriesInformationString() {
		String seriesInformation = String.format(", book %d/%d of %s", 
				mPositionInSeries, 
				mTotalNumberOfBooksInSeries, 
				mSeriesName);
		return seriesInformation;
	}
	
	@Override
	public String toString() {
		return mSeriesName.get();
	}
	public StringProperty seriesProperty() {
		return mSeriesName;
	}

	@Override
	public int compareTo(final BookSeriesInformation otherBookSeriesInformation) {
		int comparisonSeriesName 	= mSeriesName.get().compareTo(otherBookSeriesInformation.seriesProperty().get());
		double comparisonPosition 	= mPositionInSeries - otherBookSeriesInformation.mPositionInSeries;
		int comparisonTotal 				= mTotalNumberOfBooksInSeries - otherBookSeriesInformation.mTotalNumberOfBooksInSeries;
		
		comparisonSeriesName 	= comparisonSeriesName 	< 0 ? -1 : comparisonSeriesName > 0 ? 1 : 0;
		comparisonPosition 		= comparisonPosition 			< 0 ? -1 : comparisonPosition 		> 0 ? 1 : 0;
		comparisonTotal 				= comparisonTotal 				< 0 ? -1 : comparisonTotal 				> 0 ? 1 : 0;
		
		if(comparisonSeriesName 		!= 0) return comparisonSeriesName;
		else if (comparisonPosition 	!= 0) return (int) comparisonPosition;
		else if (comparisonTotal 		!= 0) return comparisonTotal;
		else return 0;
	}
}