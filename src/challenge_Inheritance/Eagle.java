package challenge_Inheritance;

/**
 * This is a class that represents a eagle.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Eagle extends Bird {

	/**
	 * This is the default constructor. Since there are no parameters passed in, 
	 * the fields will be set to default values.
	 */
	public Eagle() {
		super(DietType.Carnivore, SkinType.Feather);
	}
	
	/**
	 * The eagle makes a noise unique to being a eagle.
	 * @return Returns a noise similar to 'Scraw!'.
	 */
	@Override
	public String makeNoise() {
		return "Scraw!";
	}
}