package challenge_Inheritance;

/**
 * This is the a class that represents a manatee.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SolutionManatee extends Mammal {

	/**
	 * This is the default constructor. Since there are no parameters passed in, the
	 * fields will be set to default values.
	 */
	public SolutionManatee() {
		super(0, DietType.Herbivore, SkinType.Skin);
	}

	/**
	 * The manatee makes a noise unique to being a manatee.
	 * 
	 * @return Returns a noise similar to 'Blbllbb blllbb'.
	 */
	@Override
	public String makeNoise() {
		return "Blbllbb blllbb";
	}
}