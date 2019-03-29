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
 * {@linkplain LinkedList LinkedLists}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class LinkedList_Test {
  
  /**
   * Tests that a {@linkplain LinkedList} created with the 
   * default constructor is empty. 
   */
  @Test
  public void test_DefaultConstructorCreatesAnEmptyList() {
    final LinkedListable<String> list = new LinkedList<String>();
    
    assertTrue(list.isEmpty());
  }
  /**
   * Tests that a {@linkplain LinkedList} created with the 
   * default constructor has a length of zero. 
   */
  @Test
  public void test_DefaultConstructor_LengthIsZero() {
    final LinkedListable<String> list = new LinkedList<String>();
    
    final int expected = 0;
    final int actual = list.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the head of a {@linkplain LinkedList} created 
   * with the default constructor is null. 
   */
  @Test
  public void test_DefaultConstructor_HeadIsNull() {
    final LinkedListable<Nodeable_LinkedList<String>> list = new LinkedList<Nodeable_LinkedList<String>>();
    
    assertNull(list.head());
  }
  /**
   * Tests that the tail of a {@linkplain LinkedList} created 
   * with the default constructor is null. 
   */
  @Test
  public void test_DefaultConstructor_TailIsNull() {
    final LinkedListable<Object> list = new LinkedList<Object>();
    
    assertNull(list.tail());
  }
  
  
  /**
   * Tests that a {@linkplain LinkedList} created with the 
   * parameterized constructor is not empty. 
   */
  @Test
  public void test_ParameterizedConstructorCreatesANonEmptyList() {
    final Nodeable_LinkedList<Animal> node = new Node<Animal>();
    final LinkedListable<Animal> list = new LinkedList<Animal>(node);
    
    assertFalse(list.isEmpty());
  }
  /**
   * Tests that a {@linkplain LinkedList} created with the 
   * parameterized constructor has a length of one. 
   */
  @Test
  public void test_ParameterizedConstructor_LengthIsOne() {
    final Nodeable_LinkedList<Mammal> node = new NodeLinkedList<Mammal>();
    final LinkedListable<Mammal> list = new LinkedList<Mammal>(node);
    
    final int expected = 1;
    final int actual = list.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the head of a {@linkplain LinkedList} created 
   * with the parameterized constructor is not null. 
   */
  @Test
  public void test_ParameterizedConstructor_HeadIsNotNull() {
    final Nodeable_LinkedList<Fish> node = new NodeLinkedList<Fish>();
    final LinkedListable<Fish> list = new LinkedList<Fish>(node);
    
    assertNotNull(list.head());
  }
  /**
   * Tests that the next node of a node within a 
   * {@linkplain LinkedList} created with the parameterized 
   * constructor is null. 
   */
  @Test
  public void test_ParameterizedConstructor_NextIsNull() {
    final Nodeable_LinkedList<Cat> node = new NodeLinkedList<Cat>();
    final LinkedListable<Cat> list = new LinkedList<Cat>(node);
    
    assertNull(list.head().getNextNode());
  }
  /**
   * Tests that the tail of a {@linkplain LinkedList} created 
   * with the parameterized constructor is the same as the head.
   */
  @Test
  public void test_ParameterizedConstructor_TailIsHead() {
    final Nodeable_LinkedList<SurgeonFish> node = new NodeLinkedList<SurgeonFish>();
    final LinkedListable<SurgeonFish> list = new LinkedList<SurgeonFish>(node);
    
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
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> nodeA = new NodeLinkedList<FizzBuzzAnalysisResult>();
    final LinkedListable<FizzBuzzAnalysisResult> list = new LinkedList<FizzBuzzAnalysisResult>(nodeA);
    
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> nodeB = new NodeLinkedList<FizzBuzzAnalysisResult>();
    nodeA.setNextNode(nodeB);
    
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> expected = nodeB;
    final Nodeable_LinkedList<FizzBuzzAnalysisResult> actual = list.tail();
    assertEquals(expected, actual);
  }
}