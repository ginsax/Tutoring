package challenge_Inheritance;

/**
 * This is the base class that all mammals will be extending.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Mammal extends Animal {
	private final int mDefaultNumberOfLegs = Integer.MIN_VALUE;
	private int mNumberOfLegs;

	/**
	 * This is the default constructor. Since there are no parameters passed in, 
	 * the fields will be set to default values.
	 */
	public Mammal() {
		super();
		mNumberOfLegs = mDefaultNumberOfLegs;
	}
	/**
	 * This is the constructor that will be used if the number of legs is not 
	 * known, but the skin and diet types are known.
	 * @param dietType The type of diet this mammal has.
	 * @param skinType The type of skin this mammal has.
	 */
	public Mammal(final DietType dietType, final SkinType skinType) {
		super(dietType, skinType);
		mNumberOfLegs = mDefaultNumberOfLegs;
		ValidateSkinType();
	}
	/**
	 * This is the constructor that will be used if the number of legs & skin 
	 * and diet types are known.
	 * @param numberOfLegs The number of legs this mammal has.
	 * @param dietType The type of diet this mammal has.
	 * @param skinType The type of skin this mammal has.
	 */
	public Mammal(final int numberOfLegs, final DietType dietType, final SkinType skinType) {
		super(dietType, skinType);
		mNumberOfLegs = numberOfLegs;
		ValidateNumberOfLegs();
	}
	
	/**
	 * Validates the various skin types and ensures that only valid skin 
	 * types are accepted.
	 */
	private void ValidateSkinType() {
		switch(mSkinType) {
		case Fur: 
			break;
		case Skin: 
			break;
		case Feather: 
		case Other: 
		case Scale: 
		default: 
			mSkinType = SkinType.Other;
			break;
		
		}
	}
	/**
	 * Validates the various numbers of legs and ensures that only valid 
	 * amounts are accepted.
	 */
	private void ValidateNumberOfLegs() {
		switch(mNumberOfLegs) {
		case 0: 
		case 2: 
		case 4: 
			break;
		default: 
			mNumberOfLegs = mDefaultNumberOfLegs;
			break;
		}
	}
	
	/**
	 * Accessor of the number of legs this mammal has.
	 * @return Returns the number of legs this mammal has.
	 */
	public int getNumberOfLegs() {
		return mNumberOfLegs;
	}

	/**
	 * The mammal makes a noise unique to being a mammal.
	 * @return Returns a noise similar to 'I am a mammal.'.
	 */
	@Override
	public String makeNoise() {
		return "I am a mammal.";
	}
}