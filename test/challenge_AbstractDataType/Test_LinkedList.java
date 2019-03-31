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
 * Test class for testing {@linkplain LinkedList LinkedLists}.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class Test_LinkedList {

	/**
	 * Tests that getting a node at an index greater than the length of the list
	 * results in a thrown {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_GetNode_AtIndexGreaterThanLength_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();
		list.getNodeAtIndex(24);
	}

	/**
	 * Tests that getting a node at a negative index results in a thrown
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_GetNode_AtNegativeIndex_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();
		list.getNodeAtIndex(-1);
	}

	/**
	 * Tests that getting a node at an index of zero if the head has not been
	 * initialized results in a thrown {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_GetNode_WithNoNode_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();
		list.getNodeAtIndex(0);
	}

	/**
	 * Tests that the head of a {@linkplain LinkedList} created with the default
	 * constructor is null.
	 */
	@Test
	public void test_DefaultConstructor_HeadIsNull() {
		final I_LinkedList<I_NodeLinkedList<String>> list = new LinkedList<I_NodeLinkedList<String>>();

		assertNull(list.head());
	}

	/**
	 * Tests that setting a node at an index greater than the length of the list
	 * results in a thrown {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_InsertNode_AtIndexGreaterThanLength_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		list.setNodeAtIndex(24, node);
	}

	/**
	 * Tests that setting a node at a negative index results in a thrown
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_InsertNode_AtNegativeIndex_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		list.setNodeAtIndex(-1, node);
	}

	/**
	 * Tests that setting a node at an index of zero if the head has not been
	 * initialized does not throw an {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_InsertNode_WithNoNode_ThrowsException() {
		final I_NodeLinkedList<String> nodeA = new NodeLinkedList<String>("I am the first node.");
		final I_NodeLinkedList<String> nodeB = new NodeLinkedList<String>("I am the second node.");
		final I_LinkedList<String> list = new LinkedList<String>(nodeA);

		list.insertNodeAtIndex(-1, nodeB);
	}

	/**
	 * Tests that a {@linkplain LinkedList} created with the default constructor has
	 * a length of zero.
	 */
	@Test
	public void test_DefaultConstructor_LengthIsZero() {
		final I_LinkedList<String> list = new LinkedList<String>();

		final int expected = 0;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at an index greater than the length of the list
	 * results in a thrown {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_SetNode_AtIndexGreaterThanLength_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		list.setNodeAtIndex(24, node);
	}

	/**
	 * Tests that setting a node at a negative index results in a thrown
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_DefaultConstructor_SetNode_AtNegativeIndex_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		list.setNodeAtIndex(-1, node);
	}

	/**
	 * Tests that setting a node at an index of zero if the head has not been
	 * initialized does not throw an {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_DefaultConstructor_SetNode_WithNoNode_ThrowsException() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		list.setNodeAtIndex(0, node);

		final I_NodeLinkedList<Object> expected = node;
		final I_NodeLinkedList<Object> actual = list.getNodeAtIndex(0);
		assertEquals(expected, actual);
	}

	/**
	 * Tests that the tail of a {@linkplain LinkedList} created with the default
	 * constructor is null.
	 */
	@Test
	public void test_DefaultConstructor_TailIsNull() {
		final I_LinkedList<Object> list = new LinkedList<Object>();

		assertNull(list.tail());
	}

	/**
	 * Tests that adding a node after the head of a list makes that added node the
	 * tail of said list.
	 */
	@Test
	public void test_DefaultConstructor_TailIsSet() {
		final I_NodeLinkedList<FizzBuzzAnalysisResult> nodeA = new NodeLinkedList<FizzBuzzAnalysisResult>();
		final I_LinkedList<FizzBuzzAnalysisResult> list = new LinkedList<FizzBuzzAnalysisResult>(nodeA);

		final I_NodeLinkedList<FizzBuzzAnalysisResult> nodeB = new NodeLinkedList<FizzBuzzAnalysisResult>();
		nodeA.setNextNode(nodeB);

		final I_NodeLinkedList<FizzBuzzAnalysisResult> expected = nodeB;
		final I_NodeLinkedList<FizzBuzzAnalysisResult> actual = list.tail();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that a {@linkplain LinkedList} created with the default constructor is
	 * empty.
	 */
	@Test
	public void test_DefaultConstructorCreatesAnEmptyList() {
		final I_LinkedList<String> list = new LinkedList<String>();

		assertTrue(list.isEmpty());
	}

	/**
	 * Tests that adding a node after the head of a list makes that added node the
	 * tail of said list.
	 */
	@Test
	public void test_MultipleNodes_TailIsSet() {
		final I_NodeLinkedList<FizzBuzzAnalysisResult> nodeA = new NodeLinkedList<FizzBuzzAnalysisResult>();
		final I_LinkedList<FizzBuzzAnalysisResult> list = new LinkedList<FizzBuzzAnalysisResult>(nodeA);

		final I_NodeLinkedList<FizzBuzzAnalysisResult> nodeB = new NodeLinkedList<FizzBuzzAnalysisResult>();
		nodeA.setNextNode(nodeB);

		final I_NodeLinkedList<FizzBuzzAnalysisResult> expected = nodeB;
		final I_NodeLinkedList<FizzBuzzAnalysisResult> actual = list.tail();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that getting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_NodeConstructor_GetNode_AtInvalidIndex_ThrowsException() {
		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>(node);

		list.getNodeAtIndex(1);
	}

	/**
	 * Tests that getting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_GetNode_AtValidIndex_BehavesAsExpected() {
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>(nodeB);
		final I_LinkedList<Object> list = new LinkedList<Object>(nodeA);

		final I_NodeLinkedList<Object> expected = nodeB;
		final I_NodeLinkedList<Object> actual = list.getNodeAtIndex(1);
		assertEquals(expected, actual);
	}

	/**
	 * Tests that getting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_GetNode_AtValidIndex_DoesNotThrowException() {
		final I_NodeLinkedList<Object> node = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>(node);

		final I_NodeLinkedList<Object> expected = node;
		final I_NodeLinkedList<Object> actual = list.getNodeAtIndex(0);
		assertEquals(expected, actual);
	}

	/** Tests that inserting a node at a valid index behaves as expected. */
	@Test
	public void test_NodeConstructor_InsertNode_AtValidIndex_BehavesAsExpected() {
		final I_NodeLinkedList<String> node = new NodeLinkedList<String>("I am the first node.");
		final I_LinkedList<String> list = new LinkedList<String>();

		list.insertNodeAtIndex(0, node);

		final int expected = 1;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/** Tests that inserting a node at a valid index behaves as expected. */
	@Test
	public void test_NodeConstructor_InsertNode_AtValidIndex_BehavesAsExpected_0() {
		final I_NodeLinkedList<String> nodeA = new NodeLinkedList<String>("I am the first node.");
		final I_NodeLinkedList<String> nodeB = new NodeLinkedList<String>("I am the second node.");
		final I_LinkedList<String> list = new LinkedList<String>(nodeA);

		list.insertNodeAtIndex(0, nodeB);

		final int expected = 1;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_InsertNode_AtValidIndex_DoesNotThrowException_00() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>(nodeA);

		list.setNodeAtIndex(0, nodeB);
		list.setNodeAtIndex(0, nodeC);

		final I_NodeLinkedList<Object> expected = nodeC;
		final I_NodeLinkedList<Object> actual = list.getNodeAtIndex(0);
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_InsertNode_AtValidIndex_DoesNotThrowException_01() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>();

		list.insertNodeAtIndex(0, nodeA);
		list.insertNodeAtIndex(1, nodeB);
		list.insertNodeAtIndex(2, nodeC);

		final int expected = 3;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test(expected = InvalidListIndexException.class)
	public void test_NodeConstructor_InsertNode_AtValidIndex_DoesNotThrowException_02() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>();

		list.insertNodeAtIndex(0, nodeA);
		list.insertNodeAtIndex(1, nodeB);
		list.insertNodeAtIndex(5, nodeC);
	}

	/** Tests that setting a node at a valid index behaves as expected. */
	@Test
	public void test_NodeConstructor_SetNode_AtValidIndex_BehavesAsExpected() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>();

		list.setNodeAtIndex(0, nodeA);
		list.setNodeAtIndex(1, nodeB);
		list.setNodeAtIndex(2, nodeC);

		final int expected = 3;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_SetNode_AtValidIndex_DoesNotThrowException_00() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>(nodeA);

		list.setNodeAtIndex(0, nodeB);
		list.setNodeAtIndex(0, nodeC);

		final I_NodeLinkedList<Object> expected = nodeC;
		final I_NodeLinkedList<Object> actual = list.getNodeAtIndex(0);
		assertEquals(expected, actual);
	}

	/**
	 * Tests that setting a node at a valid index does not throw an
	 * {@linkplain InvalidListIndexException}.
	 */
	@Test
	public void test_NodeConstructor_SetNode_AtValidIndex_DoesNotThrowException_01() {
		final I_NodeLinkedList<Object> nodeA = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeB = new NodeLinkedList<Object>();
		final I_NodeLinkedList<Object> nodeC = new NodeLinkedList<Object>();
		final I_LinkedList<Object> list = new LinkedList<Object>(nodeA);

		list.setNodeAtIndex(0, nodeB);
		list.setNodeAtIndex(0, nodeC);

		final int expected = 1;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that the head of a {@linkplain LinkedList} created with the
	 * parameterized constructor is not null.
	 */
	@Test
	public void test_ParameterizedConstructor_HeadIsNotNull() {
		final I_NodeLinkedList<Fish> node = new NodeLinkedList<Fish>();
		final I_LinkedList<Fish> list = new LinkedList<Fish>(node);

		assertNotNull(list.head());
	}

	/**
	 * Tests that a {@linkplain LinkedList} created with the parameterized
	 * constructor has a length of one.
	 */
	@Test
	public void test_ParameterizedConstructor_LengthIsOne() {
		final I_NodeLinkedList<Mammal> node = new NodeLinkedList<Mammal>();
		final I_LinkedList<Mammal> list = new LinkedList<Mammal>(node);

		final int expected = 1;
		final int actual = list.length();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that the next node of a node within a {@linkplain LinkedList} created
	 * with the parameterized constructor is null.
	 */
	@Test
	public void test_ParameterizedConstructor_NextIsNull() {
		final I_NodeLinkedList<Cat> node = new NodeLinkedList<Cat>();
		final I_LinkedList<Cat> list = new LinkedList<Cat>(node);

		assertNull(list.head().getNextNode());
	}

	/**
	 * Tests that the tail of a {@linkplain LinkedList} created with the
	 * parameterized constructor is the same as the head.
	 */
	@Test
	public void test_ParameterizedConstructor_TailIsHead() {
		final I_NodeLinkedList<SurgeonFish> node = new NodeLinkedList<SurgeonFish>();
		final I_LinkedList<SurgeonFish> list = new LinkedList<SurgeonFish>(node);

		final I_NodeLinkedList<SurgeonFish> expected = node;
		final I_NodeLinkedList<SurgeonFish> actual = list.tail();
		assertEquals(expected, actual);
	}

	/**
	 * Tests that a {@linkplain LinkedList} created with the parameterized
	 * constructor is not empty.
	 */
	@Test
	public void test_ParameterizedConstructorCreatesANonEmptyList() {
		final I_NodeLinkedList<Animal> node = new NodeLinkedList<Animal>();
		final I_LinkedList<Animal> list = new LinkedList<Animal>(node);

		assertFalse(list.isEmpty());
	}
}