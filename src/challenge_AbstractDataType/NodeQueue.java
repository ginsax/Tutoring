package challenge_AbstractDataType;

public class NodeQueue<NodeDataType> implements I_NodeQueue<NodeDataType> {
	
	private NodeDataType							mObject;
	private I_NodeQueue<NodeDataType>	mNextNode;
	
	
	public NodeQueue() {
	}
	
	public NodeQueue(NodeDataType object) {
		mObject = object;
	}
	
	public NodeQueue(I_NodeQueue<NodeDataType> nextNode) {
		mNextNode = nextNode;
	}
	
	public NodeQueue(I_NodeQueue<NodeDataType> nextNode,
	                 NodeDataType object) {
		mObject = object;
		mNextNode = nextNode;
	}
	
	@Override
	public NodeDataType getDataObject() {
		return mObject;
	}
	
	@Override
	public void setDataObject(NodeDataType dataObject) {
		mObject = dataObject;
	}
	
	@Override
	public I_NodeQueue<NodeDataType> getNextNode() {
		return mNextNode;
	}
	
	@Override
	public void setNextNode(I_NodeQueue<NodeDataType> nextNode) {
		mNextNode = nextNode;
	}
	
}
