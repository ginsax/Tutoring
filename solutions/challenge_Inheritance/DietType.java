package challenge_Inheritance;

/**
 * The type of diet an animal may have.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/04/2019
 */
public enum DietType {
	/** Diet consists solely of animal meat. */
	Carnivore,

	/** Diet consists solely of plant matter. */
	Herbivore,

	/** Has dietary characteristics similar to both carnivores and omnivores. */
	Omnivore,

	/**
	 * Default diet type for cases where the diet type is either unknown or does not
	 * fit into any of the other specified categories.
	 */
	Other;
}