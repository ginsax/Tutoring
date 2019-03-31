package challenge_Inheritance;

/**
 * This is the a class that represents a cat.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Cat extends Mammal {
	
	/**
	 * This is the default constructor. Since there are no parameters passed in,
	 * the fields will be set to default values.
	 */
	public Cat() {
		super(4, DietType.Carnivore, SkinType.Fur);
	}
	
	/**
	 * The cat makes a noise unique to being a cat.
	 * 
	 * @return Returns a noise similar to 'Meow!'.
	 */
	@Override
	public String makeNoise() {
		return "Meow!";
	}
}