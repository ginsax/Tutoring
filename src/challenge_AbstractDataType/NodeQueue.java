package challenge_AbstractDataType;

public class NodeQueue<NodeDataType> implements I_NodeQueue<NodeDataType> {
	
	private NodeDataType							mObject;
	private I_NodeQueue<NodeDataType>	mNextNode;
	
	
	public NodeQueue() {
	}
	
	public NodeQueue(final NodeDataType object) {
		mObject = object;
	}
	
	public NodeQueue(final I_NodeQueue<NodeDataType> nextNode) {
		mNextNode = nextNode;
	}
	
	public NodeQueue(final I_NodeQueue<NodeDataType> nextNode,
	                 final NodeDataType object) {
		mObject = object;
		mNextNode = nextNode;
	}
	
	@Override
	public NodeDataType getDataObject() {
		return mObject;
	}
	
	@Override
	public void setDataObject(final NodeDataType dataObject) {
		mObject = dataObject;
	}
	
	@Override
	public I_NodeQueue<NodeDataType> getNextNode() {
		return mNextNode;
	}
	
	@Override
	public void setNextNode(final I_NodeQueue<NodeDataType> nextNode) {
		mNextNode = nextNode;
	}
	
}
