package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for testing {@linkplain NodeQueue QueueNodes}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/28/2019
 */
public class Test_NodeQueue {
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * data object constructor is not null.
	 */
	@Test
	public void test_Nodable_DataObjectConstructor_DataObject_IsNotNull() {
		final Float dataObject = new Float(69.2f);
		final I_NodeQueue<Float> node = new NodeQueue<Float>(dataObject);
		
		assertNotNull(node.getDataObject());
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * next node constructor is not null.
	 */
	@Test
	public void test_Nodable_DefaultConstructor_DataObject_IsNotNull() {
		final I_NodeQueue<Float> nodeB = new NodeQueue<Float>();
		final I_NodeQueue<Float> nodeA = new NodeQueue<Float>();
		
		nodeA.setNextNode(nodeB);
		
		final I_NodeQueue<Float> expected = nodeB;
		final I_NodeQueue<Float> actual = nodeA.getNextNode();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * next node constructor is not null.
	 */
	@Test
	public void test_Nodable_NextNodeConstructor_NextNode_CanBeSet() {
		final I_NodeQueue<Float> nodeB = new NodeQueue<Float>();
		final I_NodeQueue<Float> nodeA = new NodeQueue<Float>(nodeB);
		
		final I_NodeQueue<Float> expected = nodeB;
		final I_NodeQueue<Float> actual = nodeA.getNextNode();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * parameterized constructor is not null.
	 */
	@Test
	public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
		final I_NodeQueue<Float> nodeB = new NodeQueue<Float>();
		final Float dataObject = new Float(69.0f);
		final I_NodeQueue<Float> nodeA = new NodeQueue<Float>(nodeB,
		                                                      dataObject);
		
		final I_NodeQueue<Float> expected = nodeB;
		final I_NodeQueue<Float> actual = nodeA.getNextNode();
		assertEquals(expected,
		             actual);
		assertEquals(dataObject,
		             nodeA.getDataObject());
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * default constructor can be set.
	 */
	@Test
	public void test_NodableDefaultConstructor_DataObject_CanBeSet() {
		final I_NodeQueue<String> node = new NodeQueue<String>();
		final String dataObject = "I am a data object";
		
		node.setDataObject(dataObject);
		
		assertNotNull(node.getDataObject());
	}
	
	/**
	 * Tests that the data object of a {@linkplain I_NodeQueue} created with the
	 * default constructor is null.
	 */
	@Test
	public void test_NodableDefaultConstructor_DataObject_IsNull() {
		final I_NodeQueue<Double> node = new NodeQueue<Double>();
		
		assertNull(node.getDataObject());
	}
	
	/**
	 * Tests that a {@linkplain I_NodeQueue} created with the default constructor
	 * is not null.
	 */
	@Test
	public void test_NodableDefaultConstructor_IsNotNull() {
		final I_NodeQueue<Integer> node = new NodeQueue<Integer>();
		
		assertNotNull(node);
	}
}