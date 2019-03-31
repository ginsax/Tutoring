package challenge_Inheritance;

/**
 * This is the a class that represents a dog.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SolutionDog extends Mammal {

	/**
	 * This is the default constructor. Since there are no parameters passed in, the
	 * fields will be set to default values.
	 */
	public SolutionDog() {
		super(4, DietType.Omnivore, SkinType.Fur);
	}

	/**
	 * The dog makes a noise unique to being a dog.
	 * 
	 * @return Returns a noise similar to 'Woof!'.
	 */
	@Override
	public String makeNoise() {
		return "Woof!";
	}
}