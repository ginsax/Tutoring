package challenge_AbstractDataType;

public class NodeQueue<T> implements I_NodeQueue<T> {

	T mDataObject;
	I_NodeQueue<T> mNextNode;
	
	NodeQueue(){}

	NodeQueue(T newDataObject){
		mDataObject = newDataObject;
	}

	NodeQueue(I_NodeQueue<T> newNextNodeQueue){
		mNextNode = newNextNodeQueue;
	}

	NodeQueue(T newDataObject, I_NodeQueue<T> newNextNodeQueue){
		mDataObject = newDataObject;
		mNextNode = newNextNodeQueue;
	}

	NodeQueue(I_NodeQueue<T> newNextNodeQueue, T newDataObject){
		mNextNode = newNextNodeQueue;
		mDataObject = newDataObject;
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
	public I_NodeQueue<T> getNextNode() {
		return mNextNode;
	}

	@Override
	public void setNextNode(I_NodeQueue<T> nextNode) {
		mNextNode = nextNode;
	}

}
