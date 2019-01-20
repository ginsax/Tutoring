package challenge_Library;

/**
 * The fictionality of a book.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public enum Fictionality {
	/** The default fictionality. Used when there is a parsing error. */
	DefaultFictionality, 
	/** The fictionality of a book that is not based on fact. */
	Fiction, 
	/** The fictionality of a book that is based on fact. */
	NonFiction;
	
	/**
	 * Allows for the creation of user-friendly strings. Used primarily to 
	 * insert spacing between types with multiple words in the name.
	 * @return Returns a user-friendly string.
	 */
	@Override
	public String toString() {
		switch(this) {
			case Fiction: 			return "Fiction"; 
			case NonFiction: 	return "Nonfiction"; 
			default: 					return "Unknown Fictionality";
		}
	}
}