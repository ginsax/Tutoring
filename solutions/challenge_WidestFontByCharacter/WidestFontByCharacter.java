package challenge_WidestFontByCharacter;


/**
 * TODO: Auto-generated class stub. I.E. What does this class do?
 * @author jacobwatson
 * @since 04/28/2019
 * @version 1.0
 */
class WidestFontByCharacter {
	private final FontCalculator[] mFontCalculators;
	
	
	/**
	 * Initializes a new WidestFontByCharacter.
	 * Sets all fields to their default values.
	 */
	WidestFontByCharacter() {
		mFontCalculators = new FontCalculator[36];
	}
	
	
	/**
	 * TODO: What does this method do?
	 */
	private void determineWidestFontByCharacter() {
		
		for (int i = 0; i < mFontCalculators.length; i++) {
			final int offset = i < 26 ? 97 : 22;
			final String character = Character.toString((char) (i + offset));
			
			mFontCalculators[i] = new FontCalculator(character);
			mFontCalculators[i].calculateWidestFontForCharacter();
			
			System.out.printf("%s is longest in the font [%s]. \n", 
			                  mFontCalculators[i].getCharacter(), 
			                  mFontCalculators[i].getWidestFontForCharacter());
		}
	}
	
	/**
	 * Runs the main program
	 * @param args The String arguments passed into the method.
	 */
	public static void main(final String[] args) {
		final WidestFontByCharacter main = new WidestFontByCharacter();
		main.determineWidestFontByCharacter();
	}
}