package challenge_Library;

/**
 * The intended audience of a book.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
enum Audience {
	/** An intended audience of Adult. */
	Adult, 
	/** An intended audience of children. */
	Children, 
	/** An intended audience of young adults. */
	YoungAdult;
	
	/**
	 * Allows for the creation of user-friendly strings. Used primarily to 
	 * insert spacing between types with multiple words in the name.
	 * @return Returns a user-friendly string.
	 */
	String toUserFriendlyString() {
		switch(this) {
			case YoungAdult: return "Young Adult"; 
			default: return toString();
		}
	}
}