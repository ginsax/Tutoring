package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import challenge_Inheritance.Animal;
import challenge_Inheritance.Bird;
import challenge_Inheritance.Cat;
import challenge_Inheritance.Dog;
import challenge_Inheritance.Eagle;
import challenge_Inheritance.Eel;
import challenge_Inheritance.Fish;
import challenge_Inheritance.Hummingbird;
import challenge_Inheritance.Kangaroo;
import challenge_Inheritance.Mammal;
import challenge_Inheritance.Manatee;
import challenge_Inheritance.SurgeonFish;

/**
 * Test class for testing {@linkplain Stack Stacks}.
 * @author jacobwatson
 * @version 1.0
 * @since 04/01/2019
 */
public class Test_Stack {
	
	/**
	 * Tests that a {@linkplain I_Stack} created with the default constructor -
	 * without adding any nodes - is not null.
	 */
	@Test
	public void test_StackDefaultConstructor_IsNotNull() {
		final I_Stack<Double> stack = new Stack<Double>();
		
		assertNotNull(stack);
	}
	/**
	 * Tests that a {@linkplain I_Stack} created with the default constructor -
	 * without adding any nodes - is empty.
	 */
	@Test
	public void test_StackDefaultConstructor_IsEmpty() {
		final I_Stack<Integer> stack = new Stack<Integer>();
		
		assertTrue(stack.isEmpty());
	}
	/**
	 * Tests that a {@linkplain I_Stack} created with the default constructor -
	 * without adding any nodes - does not contain a given node.
	 */
	@Test
	public void test_StackDefaultConstructor_DoesNotContainANode() {
		final I_Stack<Float> stack = new Stack<Float>();
		final Float node = new Float(0.1f);
		
		assertFalse(stack.contains(node));
	}
	/**
	 * Tests that the size of a {@linkplain I_Stack} created with the default
	 * constructor - without adding any nodes - is zero.
	 */
	@Test
	public void test_StackDefaultConstructor_SizeIsZero() {
		final I_Stack<Mammal> stack = new Stack<Mammal>();
		
		final int expected = 0;
		final int actual = stack.size();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that peeking at a {@linkplain I_Stack} created with the default
	 * constructor - without adding any nodes - throws an exception.
	 */
	@Test (expected = Exception_EmptyStack.class)
	public void test_StackDefaultConstructor_PeekEmptyStack_ThrowsException() {
		final I_Stack<String> stack = new Stack<String>();
		
		stack.peek();
	}
	/**
	 * Tests that popping a {@linkplain I_Stack} created with the default
	 * constructor - without adding any nodes - throws an exception.
	 */
	@Test (expected = Exception_EmptyStack.class)
	public void test_StackDefaultConstructor_PopEmptyStack_ThrowsException() {
		final I_Stack<Object> stack = new Stack<Object>();
		
		stack.pop();
	}
	
	/**
	 * Tests that a {@linkplain I_Stack} created with the data object constructor
	 * is not null.
	 */
	@Test
	public void test_StackDataObjectConstructor_IsNotNull() {
		final Double dataObject = new Double(69.9);
		final I_Stack<Double> stack = new Stack<Double>(dataObject);
		
		assertNotNull(stack);
	}
	/**
	 * Tests that a {@linkplain I_Stack} created with the data object constructor
	 * is not empty.
	 */
	@Test
	public void test_StackDataObjectConstructor_IsNotEmpty() {
		final Integer dataObject = new Integer(69);
		final I_Stack<Integer> stack = new Stack<Integer>(dataObject);
		
		assertFalse(stack.isEmpty());
	}
	/**
	 * Tests that a {@linkplain I_Stack} created with the data object constructor
	 * contains the same sata object passed into the constructor.
	 */
	@Test
	public void test_StackDataObjectConstructor_ContainsANode() {
		final Float dataObject = new Float(0.1f);
		final I_Stack<Float> stack = new Stack<Float>(dataObject);
		
		assertTrue(stack.contains(dataObject));
	}
	/**
	 * Tests that a {@linkplain I_Stack} created with the data object constructor
	 * contains the same sata object passed into the constructor.
	 */
	@Test
	public void test_StackDataObjectConstructor_DoesNotContainARandomNode() {
		final Float dataObject = new Float(0.1f);
		final I_Stack<Float> stack = new Stack<Float>(dataObject);
		final Float dataObjectRandom = new Float(6.9f);
		
		assertFalse(stack.contains(dataObjectRandom));
	}
	/**
	 * Tests that the size of a {@linkplain I_Stack} created with the data object
	 * constructor is one.
	 */
	@Test
	public void test_StackDataObjectConstructor_SizeIsOne() {
		final Fish dataObject = new Fish();
		final I_Stack<Fish> stack = new Stack<Fish>(dataObject);
		
		final int expected = 1;
		final int actual = stack.size();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that peeking at a {@linkplain I_Stack} created with the data object
	 * constructor returns the same data object passed into the constructor.
	 */
	@Test
	public void test_StackDataObjectConstructor_PeekStack_ReturnsDataObject() {
		final Bird dataObject = new Bird();
		final I_Stack<Bird> stack = new Stack<Bird>(dataObject);
		
		final Bird expected = dataObject;
		final Bird actual = stack.peek();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that popping a {@linkplain I_Stack} created with the data object
	 * constructor returns the same data object passed into the constructor.
	 */
	@Test
	public void test_StackDataObjectConstructor_PopStack_ReturnsDataObject() {
		final Kangaroo dataObject = new Kangaroo();
		final I_Stack<Kangaroo> stack = new Stack<Kangaroo>(dataObject);
		
		final Kangaroo expected = dataObject;
		final Kangaroo actual = stack.pop();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that popping a {@linkplain I_Stack} created with the data object
	 * constructor makes the stack empty.
	 */
	@Test
	public void test_StackDataObjectConstructor_PopStack_MakesStackEmpty() {
		final SurgeonFish dataObject = new SurgeonFish();
		final I_Stack<SurgeonFish> stack = new Stack<SurgeonFish>(dataObject);
		
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	/**
	 * Tests that popping a {@linkplain I_Stack} created with the data object
	 * constructor makes the size of that stack zero.
	 */
	@Test
	public void test_StackDataObjectConstructor_PopStack_MakesSizeZero() {
		final Eel dataObject = new Eel();
		final I_Stack<Eel> stack = new Stack<Eel>(dataObject);
		
		stack.pop();
		
		final int expected = 0;
		final int actual = stack.size();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that pushing a node on a {@linkplain I_Stack} created with the
	 * default constructor increases the size of that stack by one.
	 */
	@Test
	public void test_StackDefaultConstructor_PushStack_MakesSizeOne() {
		final I_Stack<Eel> stack = new Stack<Eel>();
		
		stack.push(new Eel());
		
		final int expected = 1;
		final int actual = stack.size();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that pushing a node on a {@linkplain I_Stack} created with the data
	 * object constructor increases the size of that stack by one.
	 */
	@Test
	public void
	       test_StackDataObjectConstructor_PushStack_IncreasesStackSizeByOne() {
		final Eel dataObject = new Eel();
		final I_Stack<Eel> stack = new Stack<Eel>(dataObject);
		
		final int expected = stack.size() + 1;
		stack.push(new Eel());
		
		final int actual = stack.size();
		assertEquals(expected,
		             actual);
	}
	
	/** Tests that the behavior of a {@linkplain I_Stack} is as expected - 00. */
	@Test
	public void test_Stack_OrderingBehavesAsExpected_00() {
		final Animal[] dataObjects
		    = new Animal[] {
		        new Mammal(),
		        new Bird(),
		        new Fish(),
		        new Cat(),
		        new Dog(),
		        new Eagle(),
		        new Eel(),
		        new Hummingbird(),
		        new Kangaroo(),
		        new Manatee(),
		        new SurgeonFish(),
				};
				
		final I_Stack<Animal> stack = new Stack<Animal>(dataObjects);
		
		for (int i = dataObjects.length - 1; i >= 0; i--) {
			final Animal expected = dataObjects[i];
			final Animal actual = stack.pop();
			
			assertEquals(expected,
			             actual);
		}
	}
}