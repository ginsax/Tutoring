package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for testing {@linkplain Node Nodes}.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class Test_NodeLinkedList {
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} can be set.
	 */
	@Test
	public void test_Nodable_DataObject_CanBeSet() {
		final Double expected = new Double(69.69);
		
		final I_NodeLinkedList<Double> node = new NodeLinkedList<>();
		node.setDataObject(expected);
		
		final Double actual = node.getDataObject();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the has the value that was passed in to the constructor.
	 */
	@Test
	public void test_Nodable_DataObjectConstructor_DataObject_HasSetValue() {
		final Double expected = 69.69;
		
		final Double dataObject = new Double(expected);
		final I_NodeLinkedList<Double> node = new NodeLinkedList<>(
		    dataObject);
		
		final Double actual = node.getDataObject();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the Data Object constructor is not null.
	 */
	@Test
	public void test_Nodable_DataObjectConstructor_DataObject_IsNotNull() {
		final Double dataObject = new Double(69.69);
		final I_NodeLinkedList<Double> nodeA = new NodeLinkedList<>(
		    dataObject);
		
		assertNotNull(nodeA.getDataObject());
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the Node constructor is null.
	 */
	@Test
	public void test_Nodable_DataObjectConstructor_NextNode_IsNull() {
		final I_NodeLinkedList<Double> nodeB = new NodeLinkedList<>();
		final I_NodeLinkedList<Double> nodeA = new NodeLinkedList<>(nodeB);
		
		final I_NodeLinkedList<Double> expected = nodeB;
		final I_NodeLinkedList<Double> actual = nodeA.getNextNode();
		assertEquals(expected, actual);
	}
	
	/** Tests that the next node of a {@linkplain I_NodeLinkedList} can be set. */
	@Test
	public void test_Nodable_NextNode_CanBeSet() {
		final I_NodeLinkedList<String> nodeA = new NodeLinkedList<>();
		final I_NodeLinkedList<String> nodeB = new NodeLinkedList<>();
		
		nodeA.setNextNode(nodeB);
		
		final I_NodeLinkedList<String> expected = nodeB;
		final I_NodeLinkedList<String> actual = nodeA.getNextNode();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the Node constructor is null.
	 */
	@Test
	public void test_Nodable_NodeConstructor_DataObject_IsNull() {
		final I_NodeLinkedList<Integer> nodeB = new NodeLinkedList<>();
		final I_NodeLinkedList<Integer> nodeA = new NodeLinkedList<>(nodeB);
		
		assertNull(nodeA.getDataObject());
	}
	
	/**
	 * Tests that the next node of a {@linkplain I_NodeLinkedList} created with
	 * the Node constructor is not null.
	 */
	@Test
	public void test_Nodable_NodeConstructor_NextNode_IsNotNull() {
		final I_NodeLinkedList<Double> nodeB = new NodeLinkedList<>();
		final I_NodeLinkedList<Double> nodeA = new NodeLinkedList<>(nodeB);
		
		final I_NodeLinkedList<Double> expected = nodeB;
		final I_NodeLinkedList<Double> actual = nodeA.getNextNode();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the parameterized constructor is not null.
	 */
	@Test
	public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
		final Double dataObjectB = new Double(96.96);
		final I_NodeLinkedList<Double> nodeB = new NodeLinkedList<>(
		    dataObjectB);
		
		final Double dataObjectA = new Double(69.69);
		final I_NodeLinkedList<Double> nodeA = new NodeLinkedList<>(nodeB,
		    dataObjectA);
		
		final Double expected = dataObjectB;
		final Double actual = nodeA.getNextNode().getDataObject();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the next node of a {@linkplain I_NodeLinkedList} created with
	 * the parameterized constructor is not null.
	 */
	@Test
	public void test_Nodable_ParameterizedConstructor_NextNode_IsNotNull() {
		final Double dataObjectB = new Double(96.96);
		final I_NodeLinkedList<Double> nodeB = new NodeLinkedList<>(
		    dataObjectB);
		
		final Double dataObjectA = new Double(69.69);
		final I_NodeLinkedList<Double> nodeA = new NodeLinkedList<>(nodeB,
		    dataObjectA);
		
		final I_NodeLinkedList<Double> expected = nodeB;
		final I_NodeLinkedList<Double> actual = nodeA.getNextNode();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeLinkedList} created with
	 * the default constructor is null.
	 */
	@Test
	public void test_NodableDefaultConstructor_DataObject_IsNull() {
		final I_NodeLinkedList<Integer> node = new NodeLinkedList<>();
		
		assertNull(node.getDataObject());
	}
	
	/**
	 * Tests that a {@linkplain I_NodeLinkedList} created with the default
	 * constructor is not null.
	 */
	@Test
	public void test_NodableDefaultConstructor_IsNotNull() {
		final I_NodeLinkedList<Integer> node = new NodeLinkedList<>();
		
		assertNotNull(node);
	}
	
	/**
	 * Tests that the next node of a {@linkplain I_NodeLinkedList} created with
	 * the default constructor is null.
	 */
	@Test
	public void test_NodableDefaultConstructor_NextNode_IsNull() {
		final I_NodeLinkedList<Integer> node = new NodeLinkedList<>();
		
		assertNull(node.getNextNode());
	}
}