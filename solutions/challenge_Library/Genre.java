package challenge_Library;

/**
 * The genre of a book.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
enum Genre {
	/** An genre for dramatic books. */
	Drama, 
	/** An genre for reference books. */
	Encyclopedia, 
	/** An genre for fantasy books. */
	Fantasy, 
	/** An genre for historical books. */
	History, 
	/** An genre for scientific books. */
	Science, 
	/** An genre for science fiction, or sci-fi books. */
	ScienceFiction, 
	/** An genre for romantic books. */
	Romance, 
	/** An genre for mystery books. */
	Mystery, 
	/** An genre for school textbooks books. */
	TextBook, 
	/** An genre for thrilling books. */
	Thriller;
	
	/**
	 * Allows for the creation of user-friendly strings. Used primarily to 
	 * insert spacing between types with multiple words in the name.
	 * @return Returns a user-friendly string.
	 */
	String toUserFriendlyString() {
		switch(this) {
			case ScienceFiction: 	return "Science Fiction";
			case TextBook: 			return "Text Book";
			default: 				return toString();
		}
	}
	
}