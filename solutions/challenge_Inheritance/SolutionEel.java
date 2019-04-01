package challenge_Inheritance;

/**
 * This is a class that represents a eel.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SolutionEel extends SolutionFish {
	
	/**
	 * This is the default constructor. Since there are no parameters passed in,
	 * the fields will be set to default values.
	 */
	public SolutionEel() {
		super(0,
		      DietType.Carnivore,
		      SkinType.Scale);
	}
	
	/**
	 * The eel makes a noise unique to being a eel.
	 * @return Returns a noise similar to 'Zap!'.
	 */
	@Override
	public String makeNoise() {
		return "Zap!";
	}
}