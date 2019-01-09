package challenge_Palindrome;

/**
 * Use this class to test the Palindrome challenge.
 * @author jacob.watson
 * @since 12/18/2018
 */
public class SolutionPalindromeChecker {
	
	/**
	 * Analyzes the given {@code potentialPalindrome} String and returns whether it is a palindrome or not. 
	 * @param potentialPalindrome String that may or may not be a palindrome.
	 * @return Returns true if the {code potentialPalindrome} is a palindrome. Otherwise, false is returned.
	 */
	public boolean IsPalindrome(String potentialPalindrome) {
		potentialPalindrome = potentialPalindrome.toLowerCase(); // It is important to make sure we make all the characters lower case.
		if (potentialPalindrome.length() <= 1) { // If there is one or fewer character(s) left, then it is a palindrome.
			return true;
		}
		else {
			final char first = potentialPalindrome.charAt(0); // Get the very first character.
			final char last = potentialPalindrome.charAt(potentialPalindrome.length() - 1); // Get the very last character.
			if(first == last) { // Compare the first and last characters. If they are the same character, then restart the check using the next character and the next last character.
				final String newPotentialPalindrome = potentialPalindrome.substring(1, potentialPalindrome.length() - 1);
				return IsPalindrome(newPotentialPalindrome);
			}
			else {
				return false;
			}
		}
	}
}