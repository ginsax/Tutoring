package challenge_Inheritance;

/**
 * This is the base class that all animals will be extending.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Animal {
	
	/** The diet type. */
	protected DietType	mDietType;
	/** The skin type. */
	protected SkinType	mSkinType;
	
	
	/**
	 * This is the default constructor. Since there are no parameters passed in,
	 * the fields will be set to default values.
	 */
	public Animal() {
		mDietType = DietType.Other;
		mSkinType = SkinType.Other;
	}
	
	/**
	 * This is the constructor that will be used most often. It is the only way to
	 * assign values that should be considered constants.
	 * @param dietType The type of diet this animal has.
	 * @param skinType The type of skin this animal has.
	 */
	public Animal(final DietType dietType,
	              final SkinType skinType) {
		mDietType = dietType;
		mSkinType = skinType;
	}
	
	/**
	 * Gets the diet type of this animal.
	 * @return Returns the diet type of this animal.
	 */
	public DietType getDietType() {
		return mDietType;
	}
	
	/**
	 * Gets the skin type of this animal.
	 * @return Returns the skin type of this animal.
	 */
	public SkinType getSkinType() {
		return mSkinType;
	}
	
	/**
	 * The animal makes a noise unique to its species.
	 * @return Returns a unique string noise based on the animal species.
	 */
	public String makeNoise() {
		return "I am an animal. I make a non-specific noise.";
	}
}