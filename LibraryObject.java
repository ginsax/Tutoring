package challenge_Library;

import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LibraryObject {
	private ObjectProperty<UUID> mID = new SimpleObjectProperty<UUID>();
	
	private StringProperty mTitle = new SimpleStringProperty();
	private StringProperty mAuthor = new SimpleStringProperty();
	
	private StringProperty mGenre = new SimpleStringProperty();
	
	private StringProperty mYearPublished = new SimpleStringProperty();
	
	private StringProperty mSubject = new SimpleStringProperty();
	private StringProperty mEdition = new SimpleStringProperty();
	private StringProperty mAudience = new SimpleStringProperty();
	
	private IntegerProperty mInStock = new SimpleIntegerProperty();
	private IntegerProperty mTotalCopies = new SimpleIntegerProperty();
	
	public LibraryObject() {
		
	}
}