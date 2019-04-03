package challenge_AbstractDataType;

public class Solution_BinarySearchTree<NodeDataType extends Comparable<NodeDataType>>
                                      implements
                                      I_BinarySearchTree<NodeDataType> {
	
	/** The root of this tree. */
	private Solution_NodeBinarySearchTree<NodeDataType> mRoot;
	
	
	/** Instantiates a new Binary Search Tree. Fields are set to null. */
	public Solution_BinarySearchTree() {
		mRoot = null;
	}
	/**
	 * Instantiates a new Binary Search Tree with the given
	 * <code>rootDataObject</code> to set as the new root.
	 * @param rootDataObject The data object to set as the root of this tree.
	 */
	public Solution_BinarySearchTree(final NodeDataType rootDataObject) {
		this();
		mRoot = new Solution_NodeBinarySearchTree<NodeDataType>(rootDataObject);
	}
	
	@Override
	public boolean insert(final NodeDataType dataObject) {
		final int heightOriginal = height();
		mRoot
		    = (Solution_NodeBinarySearchTree<NodeDataType>) insert(mRoot,
		                                                           dataObject);
		
		return heightOriginal != height();
	}
	/**
	 * Inserts the given node into this tree recursively.
	 * @param currentNode The current node to insert into this tree.
	 * @param dataObject The value to search through the children for.
	 * @return Returns whether insertion was successful.
	 */
	private I_NodeBinarySearchTree<NodeDataType>
	        insert(final I_NodeBinarySearchTree<NodeDataType> currentNode,
	               final NodeDataType dataObject) {
		if (currentNode == null) {
			return new Solution_NodeBinarySearchTree<NodeDataType>(dataObject);
		}
		else {
			final int comparisonResult
			    = dataObject.compareTo(currentNode.getDataObject());
			
			if (comparisonResult < 0) {
				currentNode.setChildNodeLeft(insert(currentNode.getChildNodeLeft(),
				                                    dataObject));
			}
			else if (comparisonResult > 0) {
				currentNode.setChildNodeRight(insert(currentNode.getChildNodeRight(),
				                                     dataObject));
			}
		}
		return currentNode;
	}
	
	@Override
	public String printTree() {
		String printedTree = "[Tree is empty]";
		
		if (!isEmpty()) {
			printedTree = printTree(mRoot);
		}
		
		return printedTree;
	}
	/**
	 * Gets a string that represents the tree recursively.
	 * @param currentNode The current node of this tree.
	 * @return Returns the string representation of this tree.
	 */
	private String
	        printTree(final I_NodeBinarySearchTree<NodeDataType> currentNode) {
		if (currentNode == null) {
			return "";
		}
		else {
			final String legLeft = printTree(currentNode.getChildNodeLeft());
			final String legRight = printTree(currentNode.getChildNodeRight());
			
			return String.format("(%s)%s%s",
			                     currentNode.getDataObject(),
			                     legLeft,
			                     legRight);
		}
	}
	
	@Override
	public boolean remove(final NodeDataType dataObject) {
		final int heightOriginal = height();
		mRoot
		    = (Solution_NodeBinarySearchTree<NodeDataType>) remove(mRoot,
		                                                           dataObject);
		
		return heightOriginal != height();
	}
	/**
	 * Removes the given node from this tree recursively.
	 * @param currentNode The current node to remove from this tree.
	 * @param dataObject The value to search through the children for.
	 * @return Returns the removed node if it was contained within this tree,
	 *         otherwise false is returned.
	 */
	private I_NodeBinarySearchTree<NodeDataType>
	        remove(final I_NodeBinarySearchTree<NodeDataType> currentNode,
	               final NodeDataType dataObject) {
		if (currentNode == null) {
			return null;
		}
		else {
			final int comparisonResult
			    = dataObject.compareTo(currentNode.getDataObject());
			
			if (comparisonResult < 0) {
				currentNode.setChildNodeLeft(remove(currentNode.getChildNodeLeft(),
				                                    dataObject));
			}
			else if (comparisonResult > 0) {
				currentNode.setChildNodeRight(remove(currentNode.getChildNodeRight(),
				                                     dataObject));
			}
			else {
				if (currentNode.getChildNodeLeft() == null) {
					return currentNode.getChildNodeRight();
				}
				else if (currentNode.getChildNodeRight() == null) {
					return currentNode.getChildNodeLeft();
				}
				else {
					currentNode.setDataObject(calculateMinimumValue(currentNode
					    .getChildNodeRight()));
					
					currentNode.setChildNodeRight(remove(currentNode.getChildNodeRight(),
					                                     currentNode.getDataObject()));
				}
			}
			return currentNode;
		}
	}
	/**
	 * Calculates the minimum value along the left children of the given node.
	 * @param node The node to search along.
	 * @return Returns the minimum value along a given node.
	 */
	private NodeDataType
	        calculateMinimumValue(final I_NodeBinarySearchTree<NodeDataType> node) {
		I_NodeBinarySearchTree<NodeDataType> currentNode = node;
		NodeDataType minimumValue = currentNode.getDataObject();
		
		while (currentNode.getChildNodeLeft() != null) {
			minimumValue = currentNode.getChildNodeLeft().getDataObject();
			currentNode = currentNode.getChildNodeLeft();
		}
		
		return minimumValue;
	}
	
	@Override
	public boolean isEmpty() {
		return mRoot == null || height() == 0;
	}
	
	@Override
	public boolean contains(final NodeDataType dataObject) {
		return contains(mRoot,
		                dataObject);
	}
	/**
	 * Determines if the tree contains the given node recursively.
	 * @param currentNode The current node to determine if contained within this
	 *          tree.
	 * @param dataObject The value to search through the children for.
	 * @return Returns whether the given node contains the given data object.
	 */
	private boolean
	        contains(final I_NodeBinarySearchTree<NodeDataType> currentNode,
	                 final NodeDataType dataObject) {
		if (currentNode == null) {
			return false;
		}
		else {
			if (currentNode.getDataObject().equals(dataObject)) {
				return true;
			}
			else {
				final boolean leftContains
				    = contains(currentNode.getChildNodeLeft(),
				               dataObject);
				final boolean rightContains
				    = contains(currentNode.getChildNodeRight(),
				               dataObject);
				
				return leftContains || rightContains;
			}
		}
	}
	
	@Override
	public int height() {
		return calculateHeight(mRoot);
	}
	/**
	 * Calculates the height of the tree recursively.
	 * @param currentNode The current node to calculate the height of this tree.
	 * @return Returns the height of this tree.
	 */
	private int
	        calculateHeight(final I_NodeBinarySearchTree<NodeDataType> currentNode) {
		if (currentNode == null) {
			return 0;
		}
		else {
			final int heightTreeRight
			    = calculateHeight(currentNode.getChildNodeRight());
			final int heightTreeLeft
			    = calculateHeight(currentNode.getChildNodeLeft());
			
			final int tallerHeight
			    = heightTreeRight > heightTreeLeft
			                                       ? heightTreeRight + 1
			                                       : heightTreeLeft + 1;
			
			return tallerHeight;
		}
	}
}