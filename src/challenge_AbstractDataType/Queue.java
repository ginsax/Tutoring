package challenge_AbstractDataType;

public class Queue<T> implements I_Queue<T> {

	I_NodeQueue<T> mFrontNode;
	
	@SuppressWarnings("unchecked")
	Queue(T...mQueueDataItems){
		enqueue(mQueueDataItems);
	}
	
	@Override
	public T dequeue() {
		
		if (mFrontNode == null) return null;
		
		T dataObjectStore = mFrontNode.getDataObject();
		mFrontNode = mFrontNode.getNextNode();
		return dataObjectStore;
	}

	@Override
	public void enqueue(@SuppressWarnings("unchecked") T... nodesToAdd) {
		if (nodesToAdd==null) return;
		for (T node: nodesToAdd) {
			if (length()==0) {
				mFrontNode = new NodeQueue<T>(node);
				continue;
			}
			tail().setNextNode(new NodeQueue<T>(node));
		}
	}

	@Override
	public boolean isEmpty() {
		if(mFrontNode==null) return(true);
		return false;
	}

	@Override
	public int length() {
		int counter = 0;
		I_NodeQueue<T> refNode = mFrontNode;
		while (refNode != null) {
			counter++;
			refNode = refNode.getNextNode();
		}
		return counter;
	}

	@Override
	public T peek() {
		
		if (mFrontNode == null) return null;
		
		return mFrontNode.getDataObject();
	}

	private I_NodeQueue<T> tail(){
		
		if (mFrontNode==null) return null;
		
		I_NodeQueue<T> tailNode = mFrontNode;
		I_NodeQueue<T> tailNodeNext = tailNode.getNextNode();
		
		while (tailNodeNext!=null) {
			tailNode = tailNodeNext;
			tailNodeNext = tailNodeNext.getNextNode();
		}
		
		return tailNode;
	}
	
}
