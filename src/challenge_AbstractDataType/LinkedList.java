package challenge_AbstractDataType;
import challenge_AbstractDataType.I_LinkedList;

public class LinkedList<T> implements I_LinkedList<T> {

	I_NodeLinkedList<T> mRootNode;
	
	public LinkedList(@SuppressWarnings("unchecked") I_NodeLinkedList<T>... i_NodeLinkedLists) {
		if(i_NodeLinkedLists.length == 0) return;
		else {
			for (I_NodeLinkedList<T> newNode: i_NodeLinkedLists) {
				appendNode(newNode);
			}
		}
	}
	
	@Override
	public void appendNode(I_NodeLinkedList<T> node) {
		if (mRootNode == null) {
			mRootNode = node;
			return;
		}
		tail().setNextNode(node);
	}

	/**
	 * Returns the node at a given index in the linked list.
	 * List indexes from zero.
	 * 
	 * @param index : The requested index.
	 */
	@Override
	public I_NodeLinkedList<T> getNodeAtIndex(int index) throws Exception_InvalidListIndex {
		
		I_NodeLinkedList<T> mNodeToBeReturned = mRootNode;
			if (mNodeToBeReturned == null) throw new Exception_InvalidListIndex();
		
		for(int i=0;i<index;i++) {
			mNodeToBeReturned = mNodeToBeReturned.getNextNode();
			if (mNodeToBeReturned == null) throw new Exception_InvalidListIndex();
		}
		
		return mNodeToBeReturned;
	}

	@Override
	public I_NodeLinkedList<T> head() {
		return mRootNode;
	}

	@Override
	public void insertNodeAtIndex(int index, I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		if ((index<0) | (index>length())) throw new Exception_InvalidListIndex();
		
		I_NodeLinkedList<T> mNodeBeforeIndex = null;
		
		// set Before Nodes
		if (index>0) {
			mNodeBeforeIndex = getNodeAtIndex(index-1);
			if (mNodeBeforeIndex.getNextNode() != null) node.setNextNode(mNodeBeforeIndex.getNextNode());
			mNodeBeforeIndex.setNextNode(node);
		} else if (index == 0) { 
			node.setNextNode(mRootNode);
			mRootNode = node;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(mRootNode==null) return true;
		return false;
	}

	@Override
	public int length() {
		int lengthCounter = 0;
		I_NodeLinkedList<T> counterNode = mRootNode;
		
		while(counterNode != null) {
			lengthCounter++;
			counterNode = counterNode.getNextNode();
		}
		return lengthCounter;
	}

	@Override
	public void setNodeAtIndex(int index, I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		if ((index<0) | (index>length())) throw new Exception_InvalidListIndex();
		
		I_NodeLinkedList<T> mNodeAfterIndex = null;
		I_NodeLinkedList<T> mNodeBeforeIndex = null;
		
		// set Before&After Nodes
		if (index<(length()-1)) {
			mNodeAfterIndex = getNodeAtIndex(index+1);
		}
		if (index>0) {
			mNodeBeforeIndex = getNodeAtIndex(index-1);
		}
		
		if (mNodeAfterIndex != null) node.setNextNode(mNodeAfterIndex);
		if (mNodeBeforeIndex != null) mNodeBeforeIndex.setNextNode(node);
		if (index == 0) mRootNode = node;
		
	}

	@Override
	public I_NodeLinkedList<T> tail() {
		I_NodeLinkedList<T> tailNode = mRootNode;
			if (tailNode == null) return(null);
		I_NodeLinkedList<T> mNextNode = tailNode.getNextNode();
		
		while (mNextNode != null) {
			tailNode = mNextNode;
			mNextNode = mNextNode.getNextNode();
		}
		
		return tailNode;
	}

}
