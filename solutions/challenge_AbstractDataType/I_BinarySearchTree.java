package challenge_AbstractDataType;

/**
 * Defines a contract that all {@linkplain BinarySearchTree} (BSTs) will
 * implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data objects within this BST.
 * @since 03/31/2019
 */
interface I_BinarySearchTree<NodeDataType extends Comparable<NodeDataType>> {
	
	/**
	 * Inserts the given <code>dataObject</code> into this BST, if the BST does
	 * not already contain it.
	 * @param dataObject The data object to be inserted into this BST.
	 * @return Returns whether insertion was successful.
	 */
	boolean insert(final NodeDataType dataObject);
	
	/**
	 * Gets a string representation of this BST.
	 * @return Returns a string representation of this BST.
	 */
	String printTree();
	
	/**
	 * Removes the given <code>dataObject</code> from this BST if it exists within
	 * it.
	 * @param dataObject The data object to be removed from this BST.
	 * @return Returns whether removal was successful.
	 */
	boolean remove(final NodeDataType dataObject);
	
	/**
	 * Gets whether this BST is empty.
	 * @return Returns whether this BST is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Gets whether this BST contains the given <code>dataObject</code>.
	 * @param dataObject The data object to search within this BST for.
	 * @return Returns whether this BST contains the given data object.
	 */
	boolean contains(final NodeDataType dataObject);
	
	/**
	 * Gets the number of data objects within this BST.
	 * @return Returns the number of data objects within this BST.
	 */
	int height();
}