package challenge_AbstractDataType;

public class Stack<NodeDataType> implements I_Stack<NodeDataType>{

	I_NodeStack<NodeDataType> mHeadNode;
	
	Stack(){
		
	}
	
	Stack(NodeDataType dataObject){
		NodeStack<NodeDataType> node = new NodeStack<NodeDataType>(dataObject);
		mHeadNode = node;
	}
	
	@Override
	public void push(NodeDataType dataObject) {
		NodeStack<NodeDataType> mNode = new NodeStack<NodeDataType>(dataObject);
		if(mHeadNode == null) {
			mHeadNode = mNode;
		} else {
		mNode.setNextNode(mHeadNode);
		mHeadNode = mNode;
		}
	}

	@Override
	public NodeDataType peek() {
		return mHeadNode.getDataObject();
	}

	@Override
	public NodeDataType pop() {
		I_NodeStack<NodeDataType> poppedNode = mHeadNode;
		if(mHeadNode.getNextNode() != null) {
			mHeadNode = mHeadNode.getNextNode();
		}
		return poppedNode.getDataObject();
	}

	@Override
	public boolean isEmpty() {
		if(mHeadNode == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object dataObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
