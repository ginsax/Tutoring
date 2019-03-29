package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import challenge_Inheritance.Animal;
import challenge_Inheritance.Bird;
import challenge_Inheritance.Eel;
import challenge_Inheritance.Fish;
import challenge_Inheritance.Hummingbird;
import challenge_Inheritance.Kangaroo;
import challenge_Inheritance.Mammal;
import challenge_Inheritance.Manatee;
import challenge_Inheritance.SurgeonFish;

/**
 * Test class for testing {@linkplain Queue Queues}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/28/2019
 */
public class Queue_Test {
	private final String[] mTestDataObjects = new String[] {
			"I am the first node in a queue", 
			"I am the second node in a queue", 
			"I am the third node in a queue", 
			"I am the fourth node in a queue", 
			};
  
  
  /**
   * Tests that a {@linkplain Queueable} created with the default 
   * constructor is not null. 
   */
  @Test
  public void test_QueueableDefaultConstructor_IsNotNull() {
    final Queueable<Integer> queue = new Queue<Integer>();
    
    assertNotNull(queue);
  }
  /**
   * Tests that enqueuing a {@linkplain Queueable} created with the default 
   * constructor - without adding any nodes - is not null. 
   */
  @Test
  public void test_QueueableDefaultConstructor_Enqueuing_IsNotNull() {
  	final String nodeValue = "I am a node in a queue";
    final Queueable<String> queue = new Queue<String>();
    
    queue.enqueue(nodeValue);
    
    assertNotNull(queue.peek());
  }
  /**
   * Tests that enqueuing a {@linkplain Queueable} created with the default 
   * constructor - without adding any nodes - is not empty. 
   */
  @Test
  public void test_QueueableDefaultConstructor_Enqueuing_IsNotEmpty() {
  	final String nodeValue = "I am a node in a queue";
    final Queueable<String> queue = new Queue<String>();
    
    queue.enqueue(nodeValue);
    
    assertFalse(queue.isEmpty());
  }
  /**
   * Tests that dequeuing a {@linkplain Queueable} created with the default 
   * constructor - without adding any nodes - is null. 
   */
  @Test
  public void test_QueueableDefaultConstructor_Dequeuing_IsNull() {
    final Queueable<Double> queue = new Queue<Double>();
    
    assertNull(queue.dequeue());
  }
  /**
   * Tests that peeking a {@linkplain Queueable} created with the default 
   * constructor - without adding any nodes - is null. 
   */
  @Test
  public void test_QueueableDefaultConstructor_Peeking_IsNull() {
    final Queueable<String> queue = new Queue<String>();
    
    assertNull(queue.peek());
  }
  /**
   * Tests that the length of a {@linkplain Queueable} created with the 
   * default constructor - without adding any nodes - is zero. 
   */
  @Test
  public void test_QueueableDefaultConstructor_Length_IsZero() {
    final Queueable<Object> queue = new Queue<Object>();
    
    final int expected = 0;
    final int actual = queue.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that a {@linkplain Queueable} created with the default constructor 
   * - without adding any nodes - is empty. 
   */
  @Test
  public void test_QueueableDefaultConstructor_IsEmpty() {
    final Queueable<Nodeable_Queue<Integer>> queue = new Queue<Nodeable_Queue<Integer>>();
    
    assertTrue(queue.isEmpty());
  }
  
  
  /**
   * Tests that a {@linkplain Queueable} created with the parameterized  
   * constructor is not null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_IsNotNull() {
  	final Integer dataObject = new Integer(0);
    final Queueable<Integer> queue = new Queue<Integer>(dataObject);
    
    assertNotNull(queue);
  }
  /**
   * Tests that enqueuing a {@linkplain Queueable} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_Enqueuing_IsNotNull() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);
    
    final String nodeValue = "I am the fifth node in a queue";
    queue.enqueue(nodeValue);
    
    assertNotNull(queue.peek());
  }
  /**
   * Tests that enqueuing a {@linkplain Queueable} created with the 
   * parameterized constructor is not empty. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_Enqueuing_IsNotEmpty() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);

    final String nodeValue = "I am the fifth node in a queue";
    queue.enqueue(nodeValue);
    
    assertFalse(queue.isEmpty());
  }
  /**
   * Tests that dequeuing a {@linkplain Queueable} created with the 
   * parameterized constructor - with only one node - is not null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_DequeuingSingle_IsNull() {
    final Double nodeValue = new Double(0.1);
    final Queueable<Double> queue = new Queue<Double>(nodeValue);
    
    assertNotNull(queue.dequeue());
  }
  /**
   * Tests that dequeuing a {@linkplain Queueable} created with the 
   * parameterized constructor - with only one node - twice is null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_DequeuingSingle_Twice_IsNull() {
    final Double nodeValue = new Double(0.1);
    final Queueable<Double> queue = new Queue<Double>(nodeValue);

    queue.dequeue();
    assertNull(queue.dequeue());
  }
  /**
   * Tests that dequeuing a {@linkplain Queueable} created with the 
   * parameterized constructor - with more than one node - is not null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_DequeuingMultiple_IsNotNull() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);
    
    assertNotNull(queue.dequeue());
  }
  /**
   * Tests that peeking a {@linkplain Queueable} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_Peeking_IsNotNull() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);
    
    assertNotNull(queue.peek());
  }
  /**
   * Tests that the length of a {@linkplain Queueable} created with the 
   * parameterized constructor is equal to the number of parameters passed to 
   * the constructor. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_Length_IsNumberOfParameters() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);
    
    final int expected = mTestDataObjects.length;
    final int actual = queue.length();
    assertEquals(expected, actual);
  }
  /**
   * Tests that a {@linkplain Queueable} created with the parameterized 
   * constructor - without removing any nodes - is not empty. 
   */
  @Test
  public void test_QueueableParameterizedConstructor_IsNotEmpty() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);
    
    assertFalse(queue.isEmpty());
  }
  
  
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 0. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_00() {
    final Queueable<String> queue = new Queue<String>(mTestDataObjects);

    final String nodeValue = "I am the fifth node in a queue";
    queue.enqueue(nodeValue);
    
    assertEquals(mTestDataObjects[0], queue.dequeue());
    assertEquals(mTestDataObjects[1], queue.dequeue());
    assertEquals(mTestDataObjects[2], queue.dequeue());
    assertEquals(mTestDataObjects[3], queue.dequeue());
  	assertEquals(nodeValue, 					queue.peek());
    assertEquals(nodeValue, 					queue.dequeue());
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 1. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_01() {
  	final Integer[] nodesToAdd = new Integer[] {
  			new Integer(5), 
  			new Integer(6), 
  			new Integer(9), 
  			new Integer(129), 
  			new Integer(72), 
  			new Integer(-5), 
  			new Integer(234), 
  			new Integer(90), 
  	};
  	
    final Queueable<Integer> queue = new Queue<Integer>();
    queue.enqueue(nodesToAdd);
    
    for (int i = 0; i < nodesToAdd.length; i++) {
    	assertEquals(nodesToAdd[i], queue.peek());
    	assertEquals(nodesToAdd[i], queue.dequeue());
    }
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 2. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_02() {
  	final Integer[] nodesToAdd = new Integer[] {
  			new Integer(5), 
  			new Integer(6), 
  			new Integer(9), 
  			new Integer(129), 
  			new Integer(72), 
  			new Integer(-5), 
  			new Integer(234), 
  			new Integer(90), 
  	};
  	
    final Queueable<Integer> queue = new Queue<Integer>(nodesToAdd);

    for (int i = 0; i < nodesToAdd.length; i++) {
    	assertEquals(nodesToAdd[i], queue.peek());
    	assertEquals(nodesToAdd[i], queue.dequeue());
    }
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 3. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_03() {
  	final Double[] nodesToAdd = new Double[] {
  			new Double(50.293), 
  			new Double(61.4810), 
  			new Double(9.019), 
  			new Double(1.0000000001), 
  			new Double(72.1234), 
  			new Double(-33.0), 
  			new Double(234.0), 
  			new Double(90.), 
  	};
  	
    final Queueable<Double> queue = new Queue<Double>(nodesToAdd);

    for (int i = 0; i < nodesToAdd.length; i++) {
    	assertEquals(nodesToAdd[i], queue.peek());
    	assertEquals(nodesToAdd[i], queue.dequeue());
    }
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 4. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_04() {
  	final Animal[] nodesToAdd = new Animal[] {
  			new Mammal(), 
  			new Bird(), 
  			new Fish(), 
  			new Kangaroo(), 
  			new Eel(), 
  			new Hummingbird(), 
  			new Manatee(), 
  			new SurgeonFish(), 
  	};
  	
    final Queueable<Animal> queue = new Queue<Animal>(nodesToAdd);

    for (int i = 0; i < nodesToAdd.length; i++) {
    	assertEquals(nodesToAdd[i], queue.peek());
    	assertEquals(nodesToAdd[i], queue.dequeue());
    }
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 5. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_05() {
  	final Animal[] nodesToAdd = null;
  	
    final Queueable<Animal> queue = new Queue<Animal>();
    queue.enqueue(nodesToAdd);
    
    assertNull(queue.dequeue());
  }
  /** Tests that a {@linkplain Queueable} behaves as expected - Test 6. */
  @Test
  public void test_QueueableConstructor_NodesAreOrderedAsExpected_06() {
  	final Animal[] nodesToAdd = null;
  	
    final Queueable<Animal> queue = new Queue<Animal>(nodesToAdd);
    queue.enqueue(nodesToAdd);
    
    assertNull(queue.peek());
  }
}