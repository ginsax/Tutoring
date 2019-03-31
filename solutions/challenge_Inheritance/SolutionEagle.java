package challenge_Inheritance;

/**
 * This is a class that represents a eagle.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SolutionEagle extends SolutionBird {

	/**
	 * This is the default constructor. Since there are no parameters passed in, the
	 * fields will be set to default values.
	 */
	public SolutionEagle() {
		super(DietType.Carnivore, SkinType.Feather);
	}

	/**
	 * The eagle makes a noise unique to being a eagle.
	 * 
	 * @return Returns a noise similar to 'Scraw!'.
	 */
	@Override
	public String makeNoise() {
		return "Scraw!";
	}
}