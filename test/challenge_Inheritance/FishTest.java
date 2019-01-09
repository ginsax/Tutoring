package challenge_Inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import challenge_Inheritance.Animal;
import challenge_Inheritance.DietType;
import challenge_Inheritance.Fish;
import challenge_Inheritance.SkinType;

/**
 * The Class FishTest.
 */
public class FishTest {

	/**
	 * Testing that the number of fins - if not specified - is equivalent to the minimum integer value.
	 */
	@Test
	public void test_DefaultNumberOfFinsIs_MinimumInteger() {
		final Fish fish = new Fish();
		
		final int expected = Integer.MIN_VALUE;
		final int actual = fish.getNumberOfFins();
		
		assertEquals("Testing that the number of fins - if not specified - is equivalent to the minimum integer value.", expected, actual);
	}
	/**
	 * Testing that the skin type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultSkinTypeIs_Other() {
		final Fish fish = new Fish();
		
		final SkinType expected = SkinType.Other;
		final SkinType actual 	= fish.getSkinType();
		
		assertEquals("Testing that the skin type - if not specified - is 'Other'.", expected, actual);
	}
	/**
	 * Testing that the diet type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultDietTypeIs_Other() {
		final Fish fish = new Fish();
		
		final DietType expected = DietType.Other;
		final DietType actual 	= fish.getDietType();
		
		assertEquals("Testing that the diet type - if not specified - is 'Other'.", expected, actual);
	}
	
	/**
	 * Testing that the skin type can be set to Scale & Other.
	 */
	@Test
	public void test_SkinType_CanBeSet() {
		final DietType diet = DietType.Other;
		
		SkinType 	expected 	= SkinType.Scale;
		Fish 		fish 		= new Fish(diet, expected);
		SkinType 	actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Scale'.", expected, actual);
		
		expected 	= SkinType.Other;
		fish 		= new Fish(diet, expected);
		actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.", expected, actual);
	}
	/**
	 * Testing that the skin type cannot be set to Feather, Fur, or Skin.
	 */
	@Test
	public void test_SkinType_CannotBeSetToInvalidValues() {
		final DietType diet = DietType.Other;
		final SkinType 	expected 	= SkinType.Other;
		
		Fish 		fish 		= new Fish(diet, SkinType.Feather);
		SkinType 	actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Feather'.", expected, actual);

		fish 		= new Fish(diet, SkinType.Fur);
		actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Fur'.", expected, actual);
		
		fish 		= new Fish(diet, SkinType.Skin);
		actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Skin'.", expected, actual);
		
		fish 		= new Fish(diet, SkinType.Other);
		actual 		= fish.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.", expected, actual);
	}
	
	/**
	 * Testing that the diet type can be set to Carnivore, Herbivore, Omnivore, & Other.
	 */
	@Test
	public void test_DietType_CanBeSet() {
		final SkinType skinType = SkinType.Other;
		
		DietType 	expected 	= DietType.Carnivore;
		Animal 		animal 		= new Animal(expected, skinType);
		DietType 	actual 		= animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Carnivore'.", expected, actual);
		
		expected 	= DietType.Herbivore;
		animal 		= new Animal(expected, skinType);
		actual 		= animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Herbivore'.", expected, actual);
		
		expected 	= DietType.Omnivore;
		animal 		= new Animal(expected, skinType);
		actual 		= animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Omnivore'.", expected, actual);
		
		expected 	= DietType.Other;
		animal 		= new Animal(expected, skinType);
		actual 		= animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Other'.", expected, actual);
	}

	/**
	 * Testing that the number of fins can be set to 0 & 2.
	 */
	@Test
	public void test_NumberOfLegs_CanBeSet() {
		final DietType dietType = DietType.Other;
		final SkinType skinType = SkinType.Other;
		
		int 	expected 	= 0;
		Fish 	fish 		= new Fish(expected, dietType, skinType);
		int 	actual 		= fish.getNumberOfFins();
		
		assertEquals("Testing that the number of fins can be set to 0.", expected, actual);

		expected 	= 2;
		fish 		= new Fish(expected, dietType, skinType);
		actual 		= fish.getNumberOfFins();
		
		assertEquals("Testing that the number of fins can be set to 2.", expected, actual);
	}
	/**
	 * Testing that the number of legs cannot be set to values other than 0 & 2.
	 */
	@Test
	public void test_NumberOfLegs_CannotBeSetToInvalidValues() {
		final DietType dietType = DietType.Other;
		final SkinType skinType = SkinType.Other;
		
		int expected 	= -1;
		Fish 	fish 	= new Fish(expected, dietType, skinType);
		int 	actual 	= fish.getNumberOfFins();
		
		assertNotEquals("Testing that the number of fins cannot be set to -1.", expected, actual);

		expected 	= 1;
		fish 		= new Fish(expected, dietType, skinType);
		actual 		= fish.getNumberOfFins();
		
		assertNotEquals("Testing that the number of fins cannot be set to 1.", expected, actual);
		
//		Tests that all numbers above 4 are invalid 
		for(int i = 3; i <= 100; i++) {
			expected 	= i;
			fish 		= new Fish(expected, dietType, skinType);
			actual 		= fish.getNumberOfFins();
			
			assertNotEquals(String.format("Testing that the number of fins cannot be set to %d.", expected), expected, actual);
		}
	}

	/**
	 * Testing that a fish can make a noise similar to 'I am a fish.'.
	 */
	@Test
	public void test_CanMakeNoise() {
		final Fish fish = new Fish();
		
		final String expected = "I am a fish.";
		final String actual = fish.makeNoise();
		
		assertEquals(String.format("Testing that a fish can make a noise similar to '%s'.", expected), expected, actual);
	}
}