package challenge_AbstractDataType;

public class Queue<ContentType> implements I_Queue<ContentType> {
	
	I_NodeQueue<ContentType> mFirstNode;
	
	
	public Queue() {
		
	}
	
	public Queue(final ContentType... nodes) {
		enqueue(nodes);
	}
	
	@Override
	public boolean isEmpty() {
		if (mFirstNode == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public int length() {
		int counter = 0;
		I_NodeQueue<ContentType> currentNode = mFirstNode;
		
		while (true) {
			if (currentNode == null) {
				return counter;
			}
			currentNode = currentNode.getNextNode();
			counter++;
		}
	}
	
	@Override
	public ContentType peek() {
		if (mFirstNode == null) {
			return null;
		}
		return mFirstNode.getDataObject();
	}
	
	@Override
	public ContentType dequeue() {
		if (mFirstNode == null) {
			return null;
		}
		final I_NodeQueue<ContentType> node = mFirstNode;
		mFirstNode = node.getNextNode();
		return node.getDataObject();
	}
	
	@Override
	public void enqueue(final ContentType... nodesToAdd) {
		if (nodesToAdd == null) {
			return;
		}
		for (int i = 0; i < nodesToAdd.length; i++) {
			if (i == 0 & mFirstNode == null) {
				final NodeQueue<ContentType> firstNode
				    = new NodeQueue<ContentType>(nodesToAdd[0]);
				mFirstNode = firstNode;
				continue;
			}
			final NodeQueue<ContentType> node
			    = new NodeQueue<ContentType>(nodesToAdd[i]);
			getLastNode().setNextNode(node);
		}
	}
	
	private I_NodeQueue<ContentType> getLastNode() {
		I_NodeQueue<ContentType> returnNode = mFirstNode;
		
		if (length() == 0) {
			return returnNode;
		}
		else {
			for (int i = 0; i < length() - 1; i++) {
				returnNode = returnNode.getNextNode();
			}
		}
		return returnNode;
	}
	
}
