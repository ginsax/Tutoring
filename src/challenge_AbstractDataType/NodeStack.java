package challenge_AbstractDataType;

public class NodeStack<NodeDataType> implements I_NodeStack<NodeDataType>{

	private I_NodeStack<NodeDataType> mNextNode;
	private NodeDataType mDataObject;
	
	/**
	 * Initializes a new NodeStack.
	 * Sets all fields to their default values.
	 */
	NodeStack() {

	}
	
	NodeStack(NodeDataType dataObject){
		mDataObject = dataObject;
	}
	
	NodeStack(I_NodeStack<NodeDataType> NextNode){
		mNextNode = NextNode;
	}
	
	NodeStack(NodeDataType dataObject, I_NodeStack<NodeDataType> NextNode){
		mDataObject = dataObject;
		mNextNode = NextNode;
	}
	
	NodeStack(I_NodeStack<NodeDataType> NextNode, NodeDataType dataObject){
		mDataObject = dataObject;
		mNextNode = NextNode;
	}

	@Override
	public NodeDataType getDataObject() {
		return mDataObject;
	}

	@Override
	public void setDataObject(NodeDataType dataObject) {
		mDataObject = dataObject;
	}

	@Override
	public I_NodeStack<NodeDataType> getNextNode() {
		return mNextNode;
	}

	@Override
	public void setNextNode(I_NodeStack<NodeDataType> nextNode) {
		mNextNode = nextNode;
	}

}
