package challenge_AbstractDataType;

public class LinkedList<T> implements I_LinkedList<T> {

	private I_NodeLinkedList<T> headNode;

	@Override
	public void appendNode(final I_NodeLinkedList<T> node) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method indexes from 0.
	 * 
	 * @return returns the node at the given index. If the index is out of bounds,
	 *         the method returns null and displays a message indicating the out of
	 *         bounds error.
	 */
	@Override
	public I_NodeLinkedList<T> getNodeAtIndex(final int index) throws InvalidListIndexException {

		// Handle if index is below zero.
		if (index < 0) {
			System.out.println("Index may not be negative");
			return null;
		}
		;

		// Initialize dummy node
		I_NodeLinkedList<T> nodey = headNode;

		// Catch empty LinkedList before processing.
		if (nodey == null) {
			System.out.println("No nodes have been initialized!");
			return nodey;
		}

		// iterate through nodes to index.
		for (int i = 0; i < index; i++) {
			nodey = nodey.getNextNode();
			// Catch if index has gone out of bounds.
			if (nodey == null) {
				System.out.println("the index is out of range.");
			}
		}

		// return node.
		return null;
	}

	@Override
	public I_NodeLinkedList<T> head() {
		return headNode;
	}

	@Override
	public void insertNodeAtIndex(final int index, final I_NodeLinkedList<T> node) throws InvalidListIndexException {
		// Handle if index is below zero.
		if (index < 0) {
			System.out.println("Index may not be negative");
		}

		// Initialize dummy node
		I_NodeLinkedList<T> nodey = headNode;

		// Catch empty LinkedList before processing.
		if (nodey == null) {
			System.out.println("No nodes have been initialized!");
		}

		if (index == 0) {
			this.headNode = node;
			node.setNextNode(nodey);
		}

		// iterate through nodes to index.
		for (int i = 0; i < (index - 1); i++) {
			nodey = nodey.getNextNode();
			nodey.getNextNode();
			// Catch if index has gone out of bounds.
			if (nodey == null) {
				System.out.println("the index is out of range.");
			}
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNodeAtIndex(final int index, final I_NodeLinkedList<T> node) throws InvalidListIndexException {
		// Handle if index is below zero.
		if (index < 0) {
			System.out.println("Index may not be negative");
		}

		// Initialize dummy node
		I_NodeLinkedList<T> nodey = headNode;

		// Catch empty LinkedList before processing.
		if (nodey == null) {
			System.out.println("No nodes have been initialized!");
		}

		// iterate through nodes to index.
		for (int i = 0; i < index; i++) {
			nodey = nodey.getNextNode();
			// Catch if index has gone out of bounds.
			if (nodey == null) {
				System.out.println("the index is out of range.");
			}
		}

		// set node at index to passed-in-node.
		nodey = node;
	}

	@Override
	public I_NodeLinkedList<T> tail() {
		I_NodeLinkedList<T> nodey = headNode;

		while (nodey != null) {
			nodey = nodey.getNextNode();
		}

		return nodey;
	}

}
