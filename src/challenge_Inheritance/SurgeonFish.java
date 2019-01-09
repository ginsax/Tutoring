package inheritance;

/**
 * This is a class that represents a surgeonfish.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class SurgeonFish extends Fish {

	/**
	 * This is the default constructor. Since there are no parameters passed in, 
	 * the fields will be set to default values.
	 */
	public SurgeonFish() {
		super(2, DietType.Herbivore, SkinType.Scale);
	}
	/**
	 * The surgeonfish makes a noise unique to being a surgeonfish..
	 * @return Returns a noise similar to 'Glub glub.'.
	 */
	@Override
	public String makeNoise() {
		return "Glub glub.";
	}
}