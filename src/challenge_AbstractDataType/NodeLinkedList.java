package challenge_AbstractDataType;

public class NodeLinkedList<T> implements I_NodeLinkedList<T>{

	private I_NodeLinkedList<T> nextNode;
	private T dataValue;
	
	public NodeLinkedList() {
	}
	
	public NodeLinkedList(I_NodeLinkedList<T> myNextNode){
		nextNode = myNextNode;
	}
	
	public NodeLinkedList(T myDataValue){
		dataValue = myDataValue;
	}
	
	public NodeLinkedList(I_NodeLinkedList<T> myNextNode, T myDataValue){
		nextNode = myNextNode;
		dataValue = myDataValue;
	}
	
	@Override
	public I_NodeLinkedList<T> getNextNode() {
		return this.nextNode;
	}

	@Override
	public void setNextNode(I_NodeLinkedList<T> myNextNode) {
		this.nextNode = myNextNode;
	}

	@Override
	public T getDataObject() {
		return this.dataValue;
	}

	@Override
	public void setDataObject(T dataObject) {
		this.dataValue=dataObject;
	}

}
