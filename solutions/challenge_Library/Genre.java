package challenge_Library;

// TODO: Auto-generated Javadoc
/**
 * The genre of a book.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public enum Genre {
	/** The default genre. Used when there is a parsing error. */
	DefaultGenre, 
	/** An genre for dramatic books. */
	Drama, 
	/** An genre for reference books. */
	Encyclopedia, 
	/** An genre for fantasy books. */
	Fantasy, 
	/** An genre for historical books. */
	History, 
	/** An genre for mystery books. */
	Mystery, 
	/** An genre for romantic books. */
	Romance, 
	/** An genre for scientific books. */
	Science, 
	/** An genre for science fiction, or sci-fi books. */
	ScienceFiction, 
	/** An genre for school textbooks books. */
	TextBook, 
	/** An genre for thrilling books. */
	Thriller;
	
	/**
	 * Allows for the creation of user-friendly strings. Used primarily to 
	 * insert spacing between types with multiple words in the name.
	 * @return Returns a user-friendly string.
	 */
	@Override
	public String toString() {
		switch(this) {
			case Drama: 				return "Drama";
			case Encyclopedia: 	return "Encyclopedia";
			case Fantasy: 				return "Fantasy";
			case History: 				return "History";
			case Mystery: 				return "Mystery";
			case Romance: 			return "Romance";
			case Science: 				return "Science";
			case ScienceFiction: 	return "Science Fiction";
			case TextBook: 			return "Text Book";
			case Thriller: 				return "Thriller";
			default: 						return "Unknown Genre";
		}
	}
	
}