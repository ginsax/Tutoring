package challenge_Palindrome;

/**
 * Use this class to test the Palindrome challenge.
 * @author jacob.watson
 * @since 12/18/2018
 */
public class PalindromeChecker {
  
  /**
   * Analyzes the given {@code potentialPalindrome} String and returns whether
   * it is a palindrome or not.
   * @param potentialPalindrome String that may or may not be a palindrome.
   * @return Returns true if the {code potentialPalindrome} is a palindrome.
   *         Otherwise, false is returned.
   */
  public boolean IsPalindrome(final String potentialPalindrome) {
    /// TODO: Check if the given word is a palindrome.
    /// HINT: Palindromes are usually case-insensitive!
    // Task_1:Create anti-string
    String bizzaroString = "";
    for (int i = potentialPalindrome.length() -
                 1; i >= 0; i--) {
      bizzaroString = bizzaroString +
                      potentialPalindrome.charAt(i);
    }
    // Task_2: compare inverted string with original to see if they match
    // (therefore palindrome)
    // Do not differentiate between lower and upper case.
    final boolean doPalindromesMatch = potentialPalindrome
        .equalsIgnoreCase(bizzaroString);
    return doPalindromesMatch;
  }
}