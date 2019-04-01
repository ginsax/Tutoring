package challenge_Inheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class AnimalTest.
 */
public class AnimalTest {
	
	/**
	 * Superficial test used only to get code coverage.
	 */
	@Test
	public void superficialEnumCoverageTest() {
		
		for (final DietType dietType : DietType.values()) {
			DietType.valueOf(dietType.name());
		}
		
		for (final SkinType skinType : SkinType.values()) {
			SkinType.valueOf(skinType.name());
		}
	}
	
	/**
	 * Testing that a generic animal can make a generic noise.
	 */
	@Test
	public void test_CanMakeNoise() {
		final Animal animal = new Animal();
		
		final String expected = "I am an animal. I make a non-specific noise.";
		final String actual = animal.makeNoise();
		
		assertEquals(String
		    .format("Testing that a generic animal making noise sounds like '%s'.",
		            expected),
		             expected,
		             actual);
	}
	
	/**
	 * Testing that the diet type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultDietTypeIs_Other() {
		final Animal animal = new Animal();
		
		final DietType expected = DietType.Other;
		final DietType actual = animal.getDietType();
		
		assertEquals("Testing that the diet type - if not specified - is 'Other'.",
		             expected,
		             actual);
	}
	
	/**
	 * Testing that the skin type - if not specified - is 'Other'.
	 */
	@Test
	public void test_DefaultSkinTypeIs_Other() {
		final Animal animal = new Animal();
		
		final SkinType expected = SkinType.Other;
		final SkinType actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type - if not specified - is 'Other'.",
		             expected,
		             actual);
	}
	
	/**
	 * Testing that the diet type can be set to Carnivore, Herbivore, Omnivore, &
	 * Other.
	 */
	@Test
	public void test_DietType_CanBeSet() {
		final SkinType skinType = SkinType.Other;
		
		DietType expected = DietType.Carnivore;
		Animal animal
		    = new Animal(expected,
		                 skinType);
		DietType actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Carnivore'.",
		             expected,
		             actual);
		
		expected = DietType.Herbivore;
		animal
		    = new Animal(expected,
		                 skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Herbivore'.",
		             expected,
		             actual);
		
		expected = DietType.Omnivore;
		animal
		    = new Animal(expected,
		                 skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Omnivore'.",
		             expected,
		             actual);
		
		expected = DietType.Other;
		animal
		    = new Animal(expected,
		                 skinType);
		actual = animal.getDietType();
		
		assertEquals("Testing that the diet type can be set to 'Other'.",
		             expected,
		             actual);
	}
	
	/**
	 * Testing that the skin type can be set to Feather, Fur, Skin, Scale, &
	 * Other.
	 */
	@Test
	public void test_SkinType_CanBeSet() {
		final DietType diet = DietType.Other;
		
		SkinType expected = SkinType.Feather;
		Animal animal
		    = new Animal(diet,
		                 expected);
		SkinType actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Feather'.",
		             expected,
		             actual);
		
		expected = SkinType.Fur;
		animal
		    = new Animal(diet,
		                 expected);
		actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Fur'.",
		             expected,
		             actual);
		
		expected = SkinType.Scale;
		animal
		    = new Animal(diet,
		                 expected);
		actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Scale'.",
		             expected,
		             actual);
		
		expected = SkinType.Skin;
		animal
		    = new Animal(diet,
		                 expected);
		actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Skin'.",
		             expected,
		             actual);
		
		expected = SkinType.Other;
		animal
		    = new Animal(diet,
		                 expected);
		actual = animal.getSkinType();
		
		assertEquals("Testing that the skin type can be set to 'Other'.",
		             expected,
		             actual);
	}
}