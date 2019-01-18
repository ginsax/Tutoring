package challenge_Library;

// TODO: Auto-generated Javadoc
/**
 * The intended audience of a book.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public enum Audience {
	/** The default audience. Used when there is a parsing error. */
	DefaultAudience, 
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
	@Override
	public String toString() {
		switch(this) {
			case Adult: 				return "Adult"; 
			case Children: 		return "Children"; 
			case YoungAdult: 	return "Young Adult"; 
			default: 					return "Unknown Audience";
		}
	}
}