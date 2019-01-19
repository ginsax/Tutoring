package challenge_Inheritance;

/**
 * This is the base class that all fish will be extending.
 * @author jacobwatson
 * @since 12/28/2018
 */
public class Fish extends Animal {
	
	/** The m default number of fins. */
	private final int mDefaultNumberOfFins = Integer.MIN_VALUE;
	
	/** The m number of fins. */
	private int mNumberOfFins;

	/**
	 * This is the default constructor. Since there are no parameters passed in, 
	 * the fields will be set to default values.
	 */
	public Fish() {
		super();
		mNumberOfFins = mDefaultNumberOfFins;
	}
	/**
	 * This is the constructor that will be used if the number of fins is not 
	 * known, but the skin and diet types are known.
	 * @param dietType The type of diet this fish has.
	 * @param skinType The type of skin this fish has.
	 */
	public Fish(final DietType dietType, final SkinType skinType) {
		super(dietType, skinType);
		mNumberOfFins = mDefaultNumberOfFins;
		ValidateSkinType();
	}
	/**
	 * This is the constructor that will be used if the number of fins & skin 
	 * and diet types are known.
	 * @param numberOfFins The number of legs this fish has.
	 * @param dietType The type of diet this fish has.
	 * @param skinType The type of skin this fish has.
	 */
	public Fish(final int numberOfFins, final DietType dietType, final SkinType skinType) {
		super(dietType, skinType);
		mNumberOfFins = numberOfFins;
		ValidateNumberOfFins();
	}
	
	/**
	 * Validates the various skin types and ensures that only valid skin 
	 * types are accepted.
	 */
	private void ValidateSkinType() {
		switch(mSkinType) {
			case Scale: 
    			break;
    		case Fur: 
    		case Skin: 
    		case Feather: 
    		case Other: 
    		default: 
			mSkinType = SkinType.Other;
				break;
		
		}
	}
	/**
	 * Validates the various numbers of fins and ensures that only valid 
	 * amounts are accepted.
	 */
	private void ValidateNumberOfFins() {
		switch(mNumberOfFins) {
		case 0: 
		case 2: 
			break;
		default: 
			mNumberOfFins = mDefaultNumberOfFins;
			break;
		}
	}
	
	/**
	 * Accessor of the number of legs this mammal has.
	 * @return Returns the number of legs this mammal has.
	 */
	public int getNumberOfFins() {
		return mNumberOfFins;
	}

	/**
	 * The fish makes a noise unique to being a fish.
	 * @return Returns a noise similar to 'I am a fish.'.
	 */
	@Override
	public String makeNoise() {
		return "I am a fish.";
	}
}