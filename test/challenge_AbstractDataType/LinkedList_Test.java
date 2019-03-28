package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import challenge_FizzBuzz.FizzBuzzAnalysisResult;
import challenge_Inheritance.Animal;
import challenge_Inheritance.Cat;
import challenge_Inheritance.Fish;
import challenge_Inheritance.Mammal;
import challenge_Inheritance.SurgeonFish;

/**
 * Test class for testing 
 * {@linkplain LinkedListSingle LinkedListSingle_Solutions}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class LinkedList_Test {
  
  /**
   * Tests that a {@linkplain LinkedListSingle} created with the 
   * default constructor is empty. 
   */
  @Test
  public void test_DefaultConstructorCreatesAnEmptyList() {
    final LinkedListable<String> list = new LinkedListSingle<String>();
    
    assertTrue(list.isEmpty());
  }
  /**
   * Tests that a {@linkplain LinkedListSingle} created with the 
   * default constructor has a length of zero. 
   */
  @Test
  public void test_DefaultConstructor_LengthIsZero() {
    final LinkedListable<String> list = new LinkedListSingle<String>();
    
    final int expected = 0;
    final int actual = list.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the head of a {@linkplain LinkedListSingle} created 
   * with the default constructor is null. 
   */
  @Test
  public void test_DefaultConstructor_HeadIsNull() {
    final LinkedListable<Nodeable_LinkedList<String>> list = new LinkedListSingle<Nodeable_LinkedList<String>>();
    
    assertNull(list.head());
  }
  /**
   * Tests that the tail of a {@linkplain LinkedListSingle} created 
   * with the default constructor is null. 
   */
  @Test
  public void test_DefaultConstructor_TailIsNull() {
    final LinkedListable<Object> list = new LinkedListSingle<Object>();
    
    assertNull(list.tail());
  }
  
  
  /**
   * Tests that a {@linkplain LinkedListSingle} created with the 
   * parameterized constructor is not empty. 
   */
  @Test
  public void test_ParameterizedConstructorCreatesANonEmptyList() {
    final Nodeable_LinkedList<Animal> node = new Node<Animal>();
    final LinkedListable<Animal> list = new LinkedListSingle<Animal>(node);
    
    assertFalse(list.isEmpty());
  }
  /**
   * Tests that a {@linkplain LinkedListSingle} created with the 
   * parameterized constructor has a length of one. 
   */
  @Test
  public void test_ParameterizedConstructor_LengthIsOne() {
    final Nodeable_LinkedList<Mammal> node = new Node<Mammal>();
    final LinkedListable<Mammal> list = new LinkedListSingle<Mammal>(node);
    
    final int expected = 1;
    final int actual = list.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the head of a {@linkplain LinkedListSingle} created 
   * with the parameterized constructor is not null. 
   */
  @Test
  public void test_ParameterizedConstructor_HeadIsNotNull() {
    final Nodeable_LinkedList<Fish> node = new Node<Fish>();
    final LinkedListable<Fish> list = new LinkedListSingle<Fish>(node);
    
    assertNotNull(list.head());
  }
  /**
   * Tests that the next node of a node within a 
   * {@linkplain LinkedListSingle} created with the parameterized 
   * constructor is null. 
   */
  @Test
  public void test_ParameterizedConstructor_NextIsNull() {
    final Nodeable_LinkedList<Cat> node = new Node<Cat>();
    final LinkedListable<Cat> list = new LinkedListSingle<Cat>(node);
    
    assertNull(list.head().getNextNode());
  }
  /**
   * Tests that the tail of a {@linkplain LinkedListSingle} created 
   * with the parameterized constructor is the same as the head.
   */
  @Test
  public void test_ParameterizedConstructor_TailIsHead() {
    final Nodeable_LinkedList<SurgeonFish> node = new Node<SurgeonFish>();
    final LinkedListable<SurgeonFish> list = new LinkedListSingle<SurgeonFish>(node);
    
    final Nodeable_LinkedList<SurgeonFish> expected = node;
    final Nodeable_LinkedList<SurgeonFish> actual = list.tail();
    assertEquals(expected, actual);
  }
  
  
  /**
   * Tests that adding a node after the head of a list makes that added node 
   * the tail of said list. 
   */
  @Test
  public void test_MultipleNodes_TailIsSet() {
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> nodeA = new Node<FizzBuzzAnalysisResult>();
    final LinkedListable<FizzBuzzAnalysisResult> list = new LinkedListSingle<FizzBuzzAnalysisResult>(nodeA);
    
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> nodeB = new Node<FizzBuzzAnalysisResult>();
    nodeA.setNextNode(nodeB);
    
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> expected = nodeB;
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> actual = list.tail();
    assertEquals(expected, actual);
  }
}