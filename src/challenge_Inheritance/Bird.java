package challenge_Inheritance;

/**
 * This is the base class that all birds will be extending.
 * 
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Bird extends Animal {

	/**
	 * This is the default constructor. Since there are no parameters passed in, the
	 * fields will be set to default values.
	 */
	public Bird() {
		super(DietType.Other, SkinType.Feather);
	}

	/**
	 * This is the constructor that will be used if the skin and diet types are
	 * known.
	 * 
	 * @param dietType The type of diet this bird has.
	 * @param skinType The type of skin this bird has.
	 */
	public Bird(final DietType dietType, final SkinType skinType) {
		super(dietType, skinType);
		ValidateSkinType();
	}

	/**
	 * The bird makes a noise unique to being a bird.
	 * 
	 * @return Returns a noise similar to 'I am a bird.'.
	 */
	@Override
	public String makeNoise() {
		return "I am a bird.";
	}

	/**
	 * Validates the various skin types and ensures that only valid skin types are
	 * accepted.
	 */
	private void ValidateSkinType() {
		switch (mSkinType) {
		case Feather:
			break;
		case Fur:
		case Other:
		case Scale:
		case Skin:
		default:
			mSkinType = SkinType.Other;
			break;
		}
	}
}