package challenge_AbstractDataType;

import challenge_AbstractDataType.I_NodeLinkedList;

public class NodeLinkedList<T> implements I_NodeLinkedList<T> {

	T mDataObject;
	I_NodeLinkedList<T> mNextNode;
	
	public NodeLinkedList(){};
	
	public NodeLinkedList(T dataObject){
		mDataObject = dataObject;
	}

	public NodeLinkedList(I_NodeLinkedList<T> nextNode){
		mNextNode = nextNode;
	}
	
	public NodeLinkedList(I_NodeLinkedList<T> nextNode, T dataObject){
		mDataObject = dataObject;
		mNextNode = nextNode;
	}	
	
	public NodeLinkedList(T dataObject, I_NodeLinkedList<T> nextNode){
		mDataObject = dataObject;
		mNextNode = nextNode;
	}
	
	@Override
	public T getDataObject() {
		return mDataObject;
	}

	@Override
	public void setDataObject(T dataObject) {
		mDataObject = dataObject;		
	}

	@Override
	public I_NodeLinkedList<T> getNextNode() {
		return mNextNode;
	}

	@Override
	public void setNextNode(I_NodeLinkedList<T> nextNode) {
		mNextNode = nextNode;
	}

}
