package challenge_Palindrome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import challenge_Palindrome.PalindromeChecker;

/**
 * Run this class as a 'JUnit Test Case'.
 * @author jacob.watson
 * @since 12/18/2018
 */
public class PalindromeTest {
	private PalindromeChecker palindromeChecker;
	
	@Before
	public void initialize() {
		palindromeChecker = new PalindromeChecker();
	}
	
	@Test
	public void test_IsPalindrome_aaa() { 
		final String potentialPalindrome = "aaa";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test 
	public void test_IsPalindrome_aba() {
		final String potentialPalindrome = "aba";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_abc() {
		final String potentialPalindrome = "abc";
		final boolean expected = false;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertFalse(errorMessage, actual);
	}
	
	@Test
	public void test_IsPalindrome_Anna() {
		final String potentialPalindrome = "Anna";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_Civilly() {
		final String potentialPalindrome = "CivIlly";
		final boolean expected = false;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertFalse(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_MadamImAdam() {
		final String potentialPalindrome = "MadamImAdam";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_RepaperRotatorRepaper() {
		final String potentialPalindrome = "RePaPeRrOtAtOrRePaPER";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	
	@Test
	public void test_IsPalindrome_abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcba() {
		final String potentialPalindrome = "abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcba";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcbaabcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcba() {
		final String potentialPalindrome = "abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcbaabcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcba";
		final boolean expected = true;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertTrue(errorMessage, actual);
	}
	@Test
	public void test_IsPalindrome_abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcbaabcdefghijklmnopqrstuvwxyz() {
		final String potentialPalindrome = "abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcbaabcdefghijklmnopqrstuvwxyz";
		final boolean expected = false;
		final boolean actual = palindromeChecker.IsPalindrome(potentialPalindrome);
		
		final String errorMessage = createErrorMessage(potentialPalindrome, expected, actual);
		
		assertFalse(errorMessage, actual);
	}
	
	/**
	 * Creates a simple error message that specifies why the test failed. 
	 * @param potentialPalindrome String that was checked for being a palindrome.
	 * @param expected The expected value.
	 * @param actual The actual value that was returned.
	 * @return Returns a simple error message that explains why the test failed.
	 */
	private String createErrorMessage(final String potentialPalindrome, final boolean expected, final boolean actual) {
		final String errorMessage = String.format("The string '%s' was tested for being a potential palindrome. The test failed because a value of '%s' was expected, but '%s' was returned.", 
													potentialPalindrome, 
													expected, 
													actual);
		return errorMessage;
	}
}