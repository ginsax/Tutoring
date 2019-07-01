package challenge_AbstractDataType;

public class NodeStack<T> implements I_NodeStack<T>{

	T mDataObject;
	I_NodeStack<T> mNextNode; 
	
	public NodeStack() {}
	
	public NodeStack(T newDataObject) {
		mDataObject = newDataObject;
	}
	
	public NodeStack(I_NodeStack<T> newNodeStack) {
		mNextNode = newNodeStack;
	}
	
	public NodeStack(T newDataObject, I_NodeStack<T> newNodeStack) {
		mDataObject = newDataObject;
		mNextNode = newNodeStack;
	}
	
	public NodeStack(I_NodeStack<T> newNodeStack, T newDataObject) {
		mDataObject = newDataObject;
		mNextNode = newNodeStack;
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
	public I_NodeStack<T> getNextNode() {
		return mNextNode;
	}

	@Override
	public void setNextNode(I_NodeStack<T> nextNode) {
		mNextNode = nextNode;
	}

}
