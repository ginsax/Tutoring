package challenge_Inheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class InheritanceTest.
 */
public class InheritanceTest {
  
  /**
   * Testing that a cat making noise sounds like 'Meow!'.
   */
  @Test
  public void test_CatCanMakeNoise() {
    final Cat cat = new Cat();
    
    final String expected = "Meow!";
    final String actual = cat.makeNoise();
    
    assertEquals(String
        .format("Testing that a cat making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that a dog making noise sounds like 'Woof!'.
   */
  @Test
  public void test_DogCanMakeNoise() {
    final Dog dog = new Dog();
    
    final String expected = "Woof!";
    final String actual = dog.makeNoise();
    
    assertEquals(String
        .format("Testing that a dog making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that an eagle making noise sounds like 'Scraw!'.
   */
  @Test
  public void test_EagleCanMakeNoise() {
    final Eagle eagle = new Eagle();
    
    final String expected = "Scraw!";
    final String actual = eagle.makeNoise();
    
    assertEquals(String
        .format("Testing that an eagle making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that an eel making noise sounds like 'Zap!'.
   */
  @Test
  public void test_EelCanMakeNoise() {
    final Eel eel = new Eel();
    
    final String expected = "Zap!";
    final String actual = eel.makeNoise();
    
    assertEquals(String
        .format("Testing that an eel making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that a hummingbird making noise sounds like 'Bzz bzz!'.
   */
  @Test
  public void test_HummingbirdMakeNoise() {
    final Hummingbird hummingbird = new Hummingbird();
    
    final String expected = "Bzz bzz!";
    final String actual = hummingbird.makeNoise();
    
    assertEquals(String
        .format("Testing that a hummingbird making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that a kangaroo making noise sounds like 'Pow pow!'.
   */
  @Test
  public void test_KangarooMakeNoise() {
    final Kangaroo kangaroo = new Kangaroo();
    
    final String expected = "Pow pow!";
    final String actual = kangaroo.makeNoise();
    
    assertEquals(String
        .format("Testing that a kangaroo making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that a manatee making noise sounds like 'Blbllbb blllbb'.
   */
  @Test
  public void test_ManateeMakeNoise() {
    final Manatee manatee = new Manatee();
    
    final String expected = "Blbllbb blllbb";
    final String actual = manatee.makeNoise();
    
    assertEquals(String
        .format("Testing that a manatee making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
  
  /**
   * Testing that a surgeonfish making noise sounds like 'Glub glub.'.
   */
  @Test
  public void test_SurgeonFishMakeNoise() {
    final SurgeonFish surgeonFish = new SurgeonFish();
    
    final String expected = "Glub glub.";
    final String actual = surgeonFish.makeNoise();
    
    assertEquals(String
        .format("Testing that a surgeonfish making noise sounds like '%s'.",
                expected),
                 expected,
                 actual);
  }
}