package challenge_AbstractDataType;

import challenge_AbstractDataType.Exception_EmptyStack;

public class Stack<NodeDataType> implements I_Stack<NodeDataType>{

	I_NodeStack<NodeDataType> mHeadNode;
	
	public Stack(){
		
	}
	
	Stack(NodeDataType... dataObjects){
		for(NodeDataType DO : dataObjects) {
			push(DO);
		}
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
		if(mHeadNode == null) {
			throw new Exception_EmptyStack();
		}
		return mHeadNode.getDataObject();
	}

	@Override
	public NodeDataType pop() {
		if(mHeadNode == null) {
			throw new Exception_EmptyStack();
		}
		I_NodeStack<NodeDataType> poppedNode = mHeadNode;
		if(mHeadNode.getNextNode() != null) {
			mHeadNode = mHeadNode.getNextNode();
		} else {
			mHeadNode = null;
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
	public boolean contains(NodeDataType dataObject) {
		I_NodeStack<NodeDataType> node = mHeadNode;
		while(node != null) {
			if(dataObject == node.getDataObject()) {
				return true;
			}
			node = node.getNextNode();
		}
		return false;
	}

	@Override
	public int size() {
		int count = 0;
		I_NodeStack<NodeDataType> node = mHeadNode;
		
		while(node != null) {
			count++;
			node = node.getNextNode();
		}
		return count;
	}

}
