package challenge_Inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * The Class MammalTest.
 */
public class MammalTest {
	
	/**
	 * Testing that a mammal can make a noise similar to 'I am a mammal.'.
	 */
	@Test
	public void test_CanMakeNoise() {
		final Mammal mammal = new Mammal();
		
		final String expected = "I am a mammal.";
		final String actual = mammal.makeNoise();
		
		assertEquals(String.format(
		    "Testing that a generic animal making noise sounds like '%s'.",
		    expected), expected, actual);
	}
	
	/**
	 * Testing that the diet type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultDietTypeIs_Other() {
		final Mammal mammal = new Mammal();
		
		final DietType expected = DietType.Other;
		final DietType actual = mammal.getDietType();
		
		assertEquals("Testing that the diet type - if not specified - is 'Other'.",
		    expected, actual);
	}
	
	/**
	 * Testing that the number of legs - if not specified - is equivalent to the
	 * minimum integer value.
	 */
	@Test
	public void test_DefaultNumberOfLegsIs_MinimumInteger() {
		final Mammal mammal = new Mammal();
		
		final int expected = Integer.MIN_VALUE;
		final int actual = mammal.getNumberOfLegs();
		
		assertEquals(
		    "Testing that the number of legs - if not specified - is equivalent to the minimum integer value.",
		    expected, actual);
	}
	
	/**
	 * Testing that the skin type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultSkinTypeIs_Other() {
		final Mammal mammal = new Mammal();
		
		final SkinType expected = SkinType.Other;
		final SkinType actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type - if not specified - is 'Other'.",
		    expected, actual);
	}
	
	/**
	 * Testing that the diet type can be set to Carnivore, Herbivore, Omnivore, &
	 * Other.
	 */
	@Test
	public void test_DietType_CanBeSet() {
		final SkinType skinType = SkinType.Other;
		
		DietType expected = DietType.Carnivore;
		Animal animal = new Animal(expected, skinType);
		DietType actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Carnivore'.",
		    expected, actual);
		
		expected = DietType.Herbivore;
		animal = new Animal(expected, skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Herbivore'.",
		    expected, actual);
		
		expected = DietType.Omnivore;
		animal = new Animal(expected, skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Omnivore'.",
		    expected, actual);
		
		expected = DietType.Other;
		animal = new Animal(expected, skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Other'.", expected,
		    actual);
	}
	
	/**
	 * Testing that the number of legs can be set to 0, 2, & 4.
	 */
	@Test
	public void test_NumberOfLegs_CanBeSet() {
		final DietType dietType = DietType.Other;
		final SkinType skinType = SkinType.Other;
		
		int expected = 0;
		Mammal mammal = new Mammal(expected, dietType, skinType);
		int actual = mammal.getNumberOfLegs();
		
		assertEquals("Testing that the number of legs can be set to 0.", expected,
		    actual);
		
		expected = 2;
		mammal = new Mammal(expected, dietType, skinType);
		actual = mammal.getNumberOfLegs();
		
		assertEquals("Testing that the number of legs can be set to 2.", expected,
		    actual);
	}
	
	/**
	 * Testing that the number of legs cannot be set to values other than 0, 2, &
	 * 4.
	 */
	@Test
	public void test_NumberOfLegs_CannotBeSetToInvalidValues() {
		final DietType dietType = DietType.Other;
		final SkinType skinType = SkinType.Other;
		
		int expected = -1;
		Mammal mammal = new Mammal(expected, dietType, skinType);
		int actual = mammal.getNumberOfLegs();
		
		assertNotEquals("Testing that the number of legs cannot be set to -1.",
		    expected, actual);
		
		expected = 1;
		mammal = new Mammal(expected, dietType, skinType);
		actual = mammal.getNumberOfLegs();
		
		assertNotEquals("Testing that the number of legs cannot be set to 1.",
		    expected, actual);
		
		expected = 3;
		mammal = new Mammal(expected, dietType, skinType);
		actual = mammal.getNumberOfLegs();
		
		assertNotEquals("Testing that the number of legs cannot be set to 3.",
		    expected, actual);
		
		// Tests that all numbers above 4 are invalid
		for (int i = 5; i <= 100; i++) {
			expected = i;
			mammal = new Mammal(expected, dietType, skinType);
			actual = mammal.getNumberOfLegs();
			
			assertNotEquals(
			    String.format("Testing that the number of legs cannot be set to %d.",
			        expected),
			    expected, actual);
		}
	}
	
	/**
	 * Testing that the skin type can be set to Fur, Skin, & Other.
	 */
	@Test
	public void test_SkinType_CanBeSet() {
		final DietType diet = DietType.Other;
		
		SkinType expected = SkinType.Fur;
		Mammal mammal = new Mammal(diet, expected);
		SkinType actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Fur'.", expected,
		    actual);
		
		expected = SkinType.Skin;
		mammal = new Mammal(diet, expected);
		actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Skin'.", expected,
		    actual);
		
		expected = SkinType.Other;
		mammal = new Mammal(diet, expected);
		actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.", expected,
		    actual);
	}
	
	/**
	 * Testing that the skin type cannot be set to Feather or Scale.
	 */
	@Test
	public void test_SkinType_CannotBeSetToInvalidValues() {
		final DietType diet = DietType.Other;
		final SkinType expected = SkinType.Other;
		
		Mammal mammal = new Mammal(diet, SkinType.Feather);
		SkinType actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Feather'.",
		    expected, actual);
		
		mammal = new Mammal(diet, SkinType.Scale);
		actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Scale'.",
		    expected, actual);
		
		mammal = new Mammal(diet, SkinType.Other);
		actual = mammal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.", expected,
		    actual);
	}
}