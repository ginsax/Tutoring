package challenge_AbstractDataType;

/**
 * Defines a contract that all nodes in a {@linkplain BinarySearchTree} (BSTs)
 * will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 04/01/2019
 */
public interface I_NodeBinarySearchTree<NodeDataType extends Comparable<NodeDataType>>
                                       extends Comparable<NodeDataType> {
	
	/**
	 * Gets the data object of this node.
	 * @return Returns the data object of this node.
	 */
	NodeDataType getDataObject();
	/**
	 * Sets the data object of this node.
	 * @param dataObject The new data object of this node.
	 */
	void setDataObject(final NodeDataType dataObject);
	
	/**
	 * Gets the left child node of this node.
	 * @return Returns the left child node of this node
	 */
	I_NodeBinarySearchTree<NodeDataType> getChildNodeLeft();
	/**
	 * Sets the left child node of this node.
	 * @param nextNode The node that is to be set as the left child node of this
	 *          node.
	 */
	void setChildNodeLeft(final I_NodeBinarySearchTree<NodeDataType> childNodeLeft);
	
	/**
	 * Gets the right child node of this node.
	 * @return Returns the right child node of this node.
	 */
	I_NodeBinarySearchTree<NodeDataType> getChildNodeRight();
	/**
	 * Sets the right child node of this node.
	 * @param nextNode The node that is to be set as the right child node of this
	 *          node.
	 */
	void setChildNodeRight(final I_NodeBinarySearchTree<NodeDataType> childNodeRight);
}