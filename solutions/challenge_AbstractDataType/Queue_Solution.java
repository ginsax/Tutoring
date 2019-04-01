package challenge_AbstractDataType;

/**
 * Defines a queue that implements the {@linkplain Queueable} interface.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/28/2019
 */
public class Queue_Solution<NodeDataType> implements Queueable<NodeDataType> {
	
	private Nodeable_Queue<NodeDataType> mFirstNode;
	
	
	/**
	 * Instantiates a new queue with the given <code>dataObjects</code> added
	 * initially.
	 * @param dataObjects The data objects to be added as nodes.
	 */
	@SafeVarargs
	Queue_Solution(final NodeDataType... dataObjects) {
		if ((dataObjects == null) || (dataObjects.length == 0)) {
			mFirstNode = null;
		}
		else {
			enqueue(dataObjects);
		}
	}
	
	@Override
	public NodeDataType dequeue() {
		final NodeDataType firstNodeDataObject;
		
		if (mFirstNode != null) {
			firstNodeDataObject = mFirstNode.getDataObject();
			mFirstNode = mFirstNode.getNextNode();
		}
		else {
			firstNodeDataObject = null;
		}
		
		return firstNodeDataObject;
	}
	
	@Override
	public void enqueue(@SuppressWarnings("unchecked") final NodeDataType... nodesToAdd) {
		if (nodesToAdd == null) {
			return;
		}
		
		final int numberOfNodes = nodesToAdd.length;
		int startingIndex = 0;
		
		if (mFirstNode == null) {
			mFirstNode = new NodeQueue_Solution<NodeDataType>(nodesToAdd[0]);
			startingIndex++;
		}
		
		Nodeable_Queue<NodeDataType> currentNode = mFirstNode;
		
		for (int i = startingIndex; i < numberOfNodes; i++) {
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			
			currentNode
			    .setNextNode(new NodeQueue_Solution<NodeDataType>(nodesToAdd[i]));
		}
	}
	
	@Override
	public NodeDataType peek() {
		final NodeDataType firstNodeDataObject;
		
		if ((mFirstNode != null) && (mFirstNode.getDataObject() != null)) {
			firstNodeDataObject = mFirstNode.getDataObject();
		}
		else {
			firstNodeDataObject = null;
		}
		
		return firstNodeDataObject;
	}
	
	@Override
	public int length() {
		int size = 0;
		
		if (mFirstNode != null) {
			Nodeable_Queue<NodeDataType> currentNode = mFirstNode;
			
			while (currentNode != null) {
				currentNode = currentNode.getNextNode();
				size++;
			}
		}
		
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return mFirstNode == null;
	}
}