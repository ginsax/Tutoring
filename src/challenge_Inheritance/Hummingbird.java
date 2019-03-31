package challenge_Inheritance;

/**
 * This is a class that represents a hummingbird.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Hummingbird extends Bird {
  
  /**
   * This is the default constructor. Since there are no parameters passed in,
   * the fields will be set to default values.
   */
  public Hummingbird() {
    super(DietType.Herbivore,
          SkinType.Feather);
  }
  
  /**
   * The hummingbird makes a noise unique to being a hummingbird.
   * @return Returns a noise similar to 'Bzz bzz!'.
   */
  @Override
  public String makeNoise() {
    return "Bzz bzz!";
  }
}