package challenge_AbstractDataType;
import challenge_AbstractDataType.I_LinkedList;

public class LinkedList<T> implements I_LinkedList<T> {

	I_NodeLinkedList<T> mRootNode;
	
	public LinkedList(I_NodeLinkedList<T>...i_NodeLinkedLists) {
		if(i_NodeLinkedLists.length == 0) return;
		else if(i_NodeLinkedLists.length == 1) mRootNode = i_NodeLinkedLists[0];
		else {
			for(int i=0; i < i_NodeLinkedLists.length; i++) {
				if 
			}
		}
	}
	
	@Override
	public void appendNode(I_NodeLinkedList<T> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I_NodeLinkedList<T> getNodeAtIndex(int index) throws Exception_InvalidListIndex {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I_NodeLinkedList<T> head() {
		return mRootNode;
	}

	@Override
	public void insertNodeAtIndex(int index, I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		// TODO Auto-generated method stub
		
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
		return 0;
	}

	@Override
	public void setNodeAtIndex(int index, I_NodeLinkedList<T> node) throws Exception_InvalidListIndex {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I_NodeLinkedList<T> tail() {
		// TODO Auto-generated method stub
		return null;
	}

}
