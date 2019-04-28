/**
 * 
 */
package challenge_WidestFontByCharacter;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * TODO: Auto-generated class stub. I.E. What does this class do?
 * @author jacobwatson
 * @since 04/28/2019
 * @version 1.0
 */
public class FontCalculator {
	private final String mCharacter;
	private String mWidestFontForCharacter;
	
	
	/**
	 * Initializes a new FontCalculator.
	 * Sets all fields to their default values.
	 */
	FontCalculator(final String character) {
		mCharacter = character;
	}
	
	void calculateWidestFontForCharacter() {
		double widestWidth = Double.MIN_VALUE;
		
		for (final String fontFamily : Font.getFamilies()) {
			final Text text = new Text(mCharacter);
			text.setFont(Font.font(fontFamily));
			
			if (text.getLayoutBounds().getWidth() > widestWidth) {
				widestWidth = text.getLayoutBounds().getWidth();
				mWidestFontForCharacter = fontFamily;
			}
		}
	}
	
	
	/**
	 * Gets the character being evaluated.
	 * @return Returns the the character being evaluated.
	 */
	public String getCharacter() {
		return mCharacter;
	}
	/**
	 * Gets the widest font for this character.
	 * @return Returns the widest font for this character.
	 */
	public String getWidestFontForCharacter() {
		return mWidestFontForCharacter;
	}
	
}