package challenge_Inheritance;

// TODO: Auto-generated Javadoc
/**
 * The type of skin an animal may have.
 * @author jacobwatson
 * @version 1.0
 * @since 01/04/2019
 */
public enum SkinType { 
	/** Has feathers covering the body, like a bird. */
	Feather, 
	/** Has hair covering the body, like a dog or cat. */
	Fur, 
	/** Has scaly skin, like a fish or snake. */
	Scale, 
	/** Has skin type similar to a human. */
	Skin, 
	/**
	 * Default skin type for cases where the skin type is either unknown or 
	 * does not fit into any of the other specified categories.
	 */
	Other;
}