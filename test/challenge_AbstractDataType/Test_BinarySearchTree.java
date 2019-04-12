package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for testing {@linkplain BinarySearchTree BinarySearchTrees}.
 * @author jacobwatson
 * @version 1.0
 * @since 04/01/2019
 */
public class Test_BinarySearchTree {
	
	/** Tests that a BST created with the default constructor is not null. */
	@Test
	public void test_BSTDefaultConstructor_IsNotNull() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		assertNotNull(tree);
	}
	/** Tests that a BST created with the default constructor is not null. */
	@Test
	public void test_BSTDefaultConstructor_IsEmpty() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		assertTrue(tree.isEmpty());
	}
	/**
	 * Tests that a BST created with the default constructor has a height of zero.
	 */
	@Test
	public void test_BSTDefaultConstructor_HeightIsZero() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final int expected = 0;
		final int actual = tree.height();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that a BST created with the default constructor does not contain a
	 * given node.
	 */
	@Test
	public void test_BSTDefaultConstructor_DoesNotContainNode() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		
		assertFalse(tree.contains(dataObject));
	}
	/**
	 * Tests that a BST created with the default constructor does not contain a
	 * given node.
	 */
	@Test
	public void test_BSTDefaultConstructor_CannotRemoveNode() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		
		assertFalse(tree.remove(dataObject));
	}
	/**
	 * Tests that printing a BST created with the default constructor returns the
	 * string '[Tree is empty]'.
	 */
	@Test
	public void test_BSTDefaultConstructor_PrintsAsEmptyTree() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final String expected = "[Tree is empty]";
		final String actual = tree.printTree();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor makes the tree not empty.
	 */
	@Test
	public void test_BSTDefaultConstructor_InsertingOneNode_MakesTreeNotEmpty() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		assertFalse(tree.isEmpty());
	}
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor makes the height of the tree one.
	 */
	@Test
	public void test_BSTDefaultConstructor_InsertingOneNode_MakesHeightOfTreeOne() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		final int expected = 1;
		final int actual = tree.height();
		assertEquals(expected,
		             actual);
	}
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor makes the tree contain that node.
	 */
	@Test
	public void test_BSTDefaultConstructor_InsertingOneNode_TreeContainsThatNode() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		assertTrue(tree.contains(dataObject));
	}
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor allows the tree to remove that node.
	 */
	@Test
	public void test_BSTDefaultConstructor_InsertingOneNode_TreeCanRemoveThatNode() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		assertTrue(tree.remove(dataObject));
	}
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor allows the tree to print that node as the root.
	 */
	@Test
	public void test_BSTDefaultConstructor_InsertingOneNode_TreeCanPrintThatNode() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		final String expected = "(69)";
		final String actual = tree.printTree();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that inserting a single node into a BST created with the default
	 * constructor allows the tree to remove that node.
	 */
	@Test
	public void test_RemovingOneNode_DecrementsHeightOfTree() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		final Integer dataObject = new Integer(69);
		tree.insert(dataObject);
		
		final int expected = tree.height() - 1;
		tree.remove(dataObject);
		final int actual = tree.height();
		assertEquals(expected,
		             actual);
	}
	
	/**
	 * Tests that
	 */
	@Test
	public void test_() {
		final I_BinarySearchTree<Integer> tree
		    = new Solution_BinarySearchTree<Integer>();
		
		assertNotNull(tree);
	}
}