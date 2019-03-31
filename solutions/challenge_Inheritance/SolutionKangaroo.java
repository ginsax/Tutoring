package challenge_Inheritance;

/**
 * This is the a class that represents a kangaroo.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SolutionKangaroo extends Mammal {

	/**
	 * This is the default constructor. Since there are no parameters passed in, the
	 * fields will be set to default values.
	 */
	public SolutionKangaroo() {
		super(2, DietType.Herbivore, SkinType.Fur);
	}

	/**
	 * The kangaroo makes a noise unique to being a kangaroo.
	 * 
	 * @return Returns a noise similar to 'Pow Pow!'.
	 */
	@Override
	public String makeNoise() {
		return "Pow pow!";
	}
}