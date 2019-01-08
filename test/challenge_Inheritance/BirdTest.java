package challenge_Inheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import challenge_Inheritance.Animal;
import challenge_Inheritance.Bird;
import challenge_Inheritance.DietType;
import challenge_Inheritance.SkinType;

public class BirdTest {
	
	/**
	 * Testing that the skin type - if not specified - is 'Feather'.
	 */
	@Test
	public void test_DefaultSkinTypeIs_Other() {
		final Bird bird = new Bird();
		
		final SkinType expected = SkinType.Feather;
		final SkinType actual 	= bird.getSkinType();
		
		assertEquals("Testing that the skin type - if not specified - is 'Feather'.", expected, actual);
	}
	/**
	 * Testing that the diet type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultDietTypeIs_Other() {
		final Bird bird = new Bird();
		
		final DietType expected = DietType.Other;
		final DietType actual 	= bird.getDietType();
		
		assertEquals("Testing that the diet type - if not specified - is 'Other'.", expected, actual);
	}
	
	/**
	 * Testing that the skin type can be set to Feather & Other.
	 */
	@Test
	public void test_SkinType_CanBeSet() {
		final DietType diet = DietType.Other;
		
		SkinType 	expected 	= SkinType.Feather;
		Bird 		bird 		= new Bird(diet, expected);
		SkinType 	actual 		= bird.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Feather'.", expected, actual);
		
		expected 	= SkinType.Other;
		bird 		= new Bird(diet, expected);
		actual 		= bird.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.", expected, actual);
	}
	/**
	 * Testing that the skin type cannot be set to Fur, Scale, or Skin.
	 */
	@Test
	public void test_SkinType_CannotBeSetToInvalidValues() {
		final DietType diet 	= DietType.Other;
		final SkinType expected = SkinType.Other;
		
		Bird 		bird 		= new Bird(diet, SkinType.Fur);
		SkinType 	actual 		= bird.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Fur'.", expected, actual);
		
		bird 		= new Bird(diet, SkinType.Scale);
		actual 		= bird.getSkinType();
		
		assertEquals("Testing that the skin type cannot be set to 'Scale'.", expected, actual);
		
		bird 		= new Bird(diet, SkinType.Skin);
		actual 		= bird.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Skin'.", expected, actual);
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
	 * Testing that a bird can make a noise similar to 'I am a bird.'.
	 */
	@Test
	public void test_CanMakeNoise() {
		final Bird bird = new Bird();
		
		final String expected = "I am a bird.";
		final String actual = bird.makeNoise();
		
		assertEquals(String.format("Testing that a generic animal making noise sounds like '%s'.", expected), expected, actual);
	}
}