package challenge_AbstractDataType;

public class LinkedList<T> implements I_LinkedList<T> {

	private I_NodeLinkedList<T> headNode;
	
	//Constructor (empty list object)
	LinkedList(){
	}
	
	//Constructor (single head object)
	LinkedList(I_NodeLinkedList<T> firstNode){
		headNode = firstNode;
	}

	@Override
	public int length() {
		
		// Initialize dummy node and iteration index
		I_NodeLinkedList<T> nodey = headNode;
		int iterationIndex = 0;

		// iterate through nodes to index.
		while (nodey != null) {
			nodey = nodey.getNextNode();
			iterationIndex++;
		}

		return iterationIndex;
	}
	
	@Override
	public boolean isEmpty() {
		if(this.headNode == null) {return true;}
		return false;
	}
	
	@Override
	public I_NodeLinkedList<T> head() {
		return headNode;
	}
	
	@Override
	public I_NodeLinkedList<T> tail() {
		I_NodeLinkedList<T> nodey = headNode;
		
		if (nodey == null){
			return nodey;
		}
		
		if (nodey.getNextNode() == null) {
			return nodey;
		}
		
		I_NodeLinkedList<T> nextNode = nodey.getNextNode();

		do {
			nodey = nextNode;
			nextNode = nextNode.getNextNode();
		} while (nextNode != null);

		return nodey;
	}
	
	/**
	 * This method indexes from 0.
	 * 
	 * @return returns the node at the given index. If the index is out of bounds,
	 *         the method returns null and displays a message indicating the out of
	 *         bounds error.
	 */
	@Override
	public I_NodeLinkedList<T> getNodeAtIndex(final int index) throws Exception_InvalidListIndex {

		// Handle if index is below zero.
		if ((index < 0) | (index >= this.length())) {
			throw new Exception_InvalidListIndex();
		}

		// Initialize dummy node
		I_NodeLinkedList<T> nodey = headNode;
		
		for(int i=0; i < index; i++) {
			nodey = nodey.getNextNode();
		}

		return nodey;
	}
	
	@Override
	public void setNodeAtIndex(final int index, final I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		// Handle if index is below zero.
		if (index < 0 | index>(this.length()) ) {
			throw new Exception_InvalidListIndex();
		}
		
		I_NodeLinkedList<T> nodey = this.headNode;
		
		if(index==0) {
			if(nodey==null) {
				this.headNode = node;
				return;
			}
			if(nodey.getNextNode() != null) {
				node.setNextNode(nodey.getNextNode());
			}
			this.headNode = node;
			return;
		}

		if ( (index==(this.length()-1)) | (index==this.length()) ) {
			this.getNodeAtIndex(index-1).setNextNode(node);
		} else {
			node.setNextNode(this.getNodeAtIndex(index+1));
			this.getNodeAtIndex(index-1).setNextNode(node);
		}
		
	}
	
	@Override
	public void insertNodeAtIndex(final int index, final I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		// Handle if index is below zero.
		if (index < 0) {
			throw new Exception_InvalidListIndex();
		}

		// Initialize dummy nodes
		I_NodeLinkedList<T> nodey = headNode;
		I_NodeLinkedList<T> nextNode = null;

		if (index == 0) {
			this.headNode = node;
			node.setNextNode(nodey);
			return;
		} else {
		// iterate through nodes to index.
		for (int i = 0; i < (index - 1); i++) {
			nodey = nodey.getNextNode();
			nextNode = nodey.getNextNode();
			// Catch if index has gone out of bounds.
			if (nodey == null) {
				throw new Exception_InvalidListIndex();
			}
		}
		nodey.setNextNode(node);
		if(nextNode==null) {
			return;
		} else {
			node.setNextNode(nextNode);
		}
		}

	}

	@Override
	public void appendNode(final I_NodeLinkedList<T> node) {
		this.tail().setNextNode(node);
		}
}
