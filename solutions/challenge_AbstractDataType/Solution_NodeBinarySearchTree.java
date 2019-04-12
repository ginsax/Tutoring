package challenge_AbstractDataType;

/**
 * A node within a {@linkplain BinarySearchTree} (BST).
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 04/01/2019
 */
public class Solution_NodeBinarySearchTree<NodeDataType extends Comparable<NodeDataType>>
                                          implements
                                          I_NodeBinarySearchTree<NodeDataType> {
	
	/** The data object of this node. */
	private NodeDataType													mDataObject;
	/** The node that falls to the left of this node. */
	private I_NodeBinarySearchTree<NodeDataType>	mChildNodeLeft;
	/** The node that falls to the right of this node. */
	private I_NodeBinarySearchTree<NodeDataType>	mChildNodeRight;
	
	
	/** Instantiates a new NodeBinarySearchTree. Sets all fields to null. */
	public Solution_NodeBinarySearchTree() {
		mChildNodeLeft = null;
		mChildNodeRight = null;
		mDataObject = null;
	}
	/**
	 * Instantiates a new NodeBinarySearchTree with the given
	 * <code>dataObject</code>. The left and right child nodes are set to null.
	 * @param dataObject The data object this node holds.
	 */
	public Solution_NodeBinarySearchTree(final NodeDataType dataObject) {
		this();
		mDataObject = dataObject;
	}
	/**
	 * Instantiates a new NodeBinarySearchTree with the given
	 * <code>childNodeLeft</code>, <code>childNodeRight</code> and
	 * <code>nodeDataObject</code>.
	 * @param childNodeLeft The child node that falls to the left of this node.
	 * @param childNodeRight The child node that falls to the right of this node.
	 * @param nodeDataObject The data object this node holds.
	 */
	public Solution_NodeBinarySearchTree(final I_NodeBinarySearchTree<NodeDataType> childNodeLeft,
	                                     final I_NodeBinarySearchTree<NodeDataType> childNodeRight,
	                                     final NodeDataType dataObject) {
		this();
		mChildNodeLeft = childNodeLeft;
		mChildNodeRight = childNodeRight;
		mDataObject = dataObject;
	}
	
	@Override
	public NodeDataType getDataObject() {
		return mDataObject;
	}
	@Override
	public void setDataObject(final NodeDataType dataObject) {
		mDataObject = dataObject;
	}
	
	@Override
	public I_NodeBinarySearchTree<NodeDataType> getChildNodeLeft() {
		return mChildNodeLeft;
	}
	@Override
	public void setChildNodeLeft(final I_NodeBinarySearchTree<NodeDataType> childNodeLeft) {
		mChildNodeLeft = childNodeLeft;
	}
	
	@Override
	public I_NodeBinarySearchTree<NodeDataType> getChildNodeRight() {
		return mChildNodeRight;
	}
	@Override
	public void setChildNodeRight(final I_NodeBinarySearchTree<NodeDataType> childNodeRight) {
		mChildNodeRight = childNodeRight;
	}
	@Override
	public int compareTo(final NodeDataType otherNodeDataType) {
		return mDataObject.compareTo(otherNodeDataType);
	}
}