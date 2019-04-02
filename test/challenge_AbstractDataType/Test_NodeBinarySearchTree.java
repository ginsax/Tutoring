package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import challenge_Library.SolutionLibraryBook;

/**
 * Test class for testing {@linkplain NodeBinarySearchTree
 * NodeBinarySearchTrees}.
 * @author jacobwatson
 * @version 1.0
 * @since 04/01/2019
 */
public class Test_NodeBinarySearchTree {
	
	/**
	 * Tests that the data object of a node created using the default constructor
	 * is null.
	 */
	@Test
	public void test_DefaultConstructor_DataObjectIsNull() {
		final I_NodeBinarySearchTree<SolutionLibraryBook> node
		    = new NodeBinarySearchTree<SolutionLibraryBook>();
		
		assertNull(node.getDataObject());
	}
	/**
	 * Tests that the left child node of a node created using the default
	 * constructor is null.
	 */
	@Test
	public void test_DefaultConstructor_LeftChildNodeIsNull() {
		final I_NodeBinarySearchTree<SolutionLibraryBook> node
		    = new NodeBinarySearchTree<SolutionLibraryBook>();
		
		assertNull(node.getChildNodeLeft());
	}
	/**
	 * Tests that the right child node of a node created using the default
	 * constructor is null.
	 */
	@Test
	public void test_DefaultConstructor_RightChildNodeIsNull() {
		final I_NodeBinarySearchTree<SolutionLibraryBook> node
		    = new NodeBinarySearchTree<SolutionLibraryBook>();
		
		assertNull(node.getChildNodeRight());
	}
	/**
	 * Tests that the data object of a node created using the default constructor
	 * can be set.
	 */
	@Test
	public void test_DefaultConstructor_DataObjectCanBeSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>();
		
		node.setDataObject(dataObject);
		
		final Integer expected = dataObject;
		final Integer actual = node.getDataObject();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the left child node of a node created using the default
	 * constructor can be set.
	 */
	@Test
	public void test_DefaultConstructor_LeftChildNodeCanBeSet() {
		final I_NodeBinarySearchTree<Integer> childNode
		    = new NodeBinarySearchTree<Integer>();
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>();
		
		node.setChildNodeLeft(childNode);
		
		final I_NodeBinarySearchTree<Integer> expected = childNode;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeLeft();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the right child node of a node created using the default
	 * constructor can be set.
	 */
	@Test
	public void test_DefaultConstructor_RightChildNodeCanBeSet() {
		final I_NodeBinarySearchTree<Integer> childNode
		    = new NodeBinarySearchTree<Integer>();
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>();
		
		node.setChildNodeRight(childNode);
		
		final I_NodeBinarySearchTree<Integer> expected = childNode;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeRight();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that the data object of a node created using the data object
	 * constructor is set to the given data object passed in to the constructor.
	 */
	@Test
	public void test_DataObjectConstructor_DataObjectIsSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(dataObject);
		
		final Integer expected = dataObject;
		final Integer actual = node.getDataObject();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the left child node object of a node created using the data
	 * object constructor is null.
	 */
	@Test
	public void test_DataObjectConstructor_LeftChildNodeIsNull() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(dataObject);
		
		assertNull(node.getChildNodeLeft());
	}
	/**
	 * Tests that the right child node object of a node created using the data
	 * object constructor is null.
	 */
	@Test
	public void test_DataObjectConstructor_RightChildNodeIsNull() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(dataObject);
		
		assertNull(node.getChildNodeRight());
	}
	/**
	 * Tests that the data object of a node created using the data object
	 * constructor is set to the given data object passed in to the constructor.
	 */
	@Test
	public void test_DataObjectConstructor_DataObjectCanBeSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(32);
		
		node.setDataObject(dataObject);
		
		final Integer expected = dataObject;
		final Integer actual = node.getDataObject();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the left child node of a node created using the data object
	 * constructor can be set.
	 */
	@Test
	public void test_DataObjectConstructor_LeftChildNodeCanBeSet() {
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(32);
		
		node.setChildNodeLeft(childNodeLeft);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeLeft;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeLeft();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the right child node of a node created using the data object
	 * constructor can be set.
	 */
	@Test
	public void test_DataObjectConstructor_RightChildNodeCanBeSet() {
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(32);
		
		node.setChildNodeRight(childNodeRight);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeRight;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeRight();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that the data object of a node created using the parameterized
	 * constructor is set to the given data object passed in to the constructor.
	 */
	@Test
	public void test_ParameterizedConstructor_DataObjectIsSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		final Integer expected = dataObject;
		final Integer actual = node.getDataObject();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the left child node of a node created using the parameterized
	 * constructor is set to the given left child node passed in to the
	 * constructor.
	 */
	@Test
	public void test_ParameterizedConstructor_LeftChildNodeIsSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeLeft;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeLeft();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the right child node of a node created using the parameterized
	 * constructor is set to the given right child node passed in to the
	 * constructor.
	 */
	@Test
	public void test_ParameterizedConstructor_RightChildNodeIsSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeRight;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeRight();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the data object of a node created using the parameterized
	 * constructor is set to the given data object passed in to the constructor.
	 */
	@Test
	public void test_ParameterizedConstructor_DataObjectCanBeSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		node.setDataObject(dataObject);
		
		final Integer expected = dataObject;
		final Integer actual = node.getDataObject();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the left child node of a node created using the parameterized
	 * constructor can be set.
	 */
	@Test
	public void test_ParameterizedConstructor_LeftChildNodeCanBeSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		node.setChildNodeLeft(childNodeLeft);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeLeft;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeLeft();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that the right child node of a node created using the parameterized
	 * constructor can be set.
	 */
	@Test
	public void test_ParameterizedConstructor_RightChildNodeCanBeSet() {
		final Integer dataObject = new Integer(69);
		final I_NodeBinarySearchTree<Integer> childNodeLeft
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> childNodeRight
		    = new NodeBinarySearchTree<Integer>();
		
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(childNodeLeft,
		                                        childNodeRight,
		                                        dataObject);
		
		node.setChildNodeRight(childNodeRight);
		
		final I_NodeBinarySearchTree<Integer> expected = childNodeRight;
		final I_NodeBinarySearchTree<Integer> actual = node.getChildNodeRight();
		assertEquals(expected,
		             actual);
	}
	
	/** Tests that the nodes can be compared correctly. */
	@Test
	public void test_NodesCanBeComparedCorrectly() {
		final I_NodeBinarySearchTree<Integer> node
		    = new NodeBinarySearchTree<Integer>(0);
		
		int expected = 0;
		int actual = node.compareTo(new Integer(0));
		assertEquals(expected,
		             actual);
		
		expected = 1;
		actual = node.compareTo(new Integer(-1));
		assertEquals(expected,
		             actual);
		
		expected = -1;
		actual = node.compareTo(new Integer(1));
		assertEquals(expected,
		             actual);
	}
}