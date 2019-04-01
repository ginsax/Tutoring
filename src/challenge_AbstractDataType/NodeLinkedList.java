package challenge_AbstractDataType;

public class NodeLinkedList<T> implements I_NodeLinkedList<T> {
	
	private I_NodeLinkedList<T>	nextNode;
	private T										dataValue;
	
	
	public NodeLinkedList() {
	}
	
	public NodeLinkedList(final I_NodeLinkedList<T> myNextNode) {
		nextNode = myNextNode;
	}
	
	public NodeLinkedList(final I_NodeLinkedList<T> myNextNode,
	                      final T myDataValue) {
		nextNode = myNextNode;
		dataValue = myDataValue;
	}
	
	public NodeLinkedList(final T myDataValue) {
		dataValue = myDataValue;
	}
	
	@Override
	public T getDataObject() {
		return this.dataValue;
	}
	
	@Override
	public I_NodeLinkedList<T> getNextNode() {
		return this.nextNode;
	}
	
	@Override
	public void setDataObject(final T dataObject) {
		this.dataValue = dataObject;
	}
	
	@Override
	public void setNextNode(final I_NodeLinkedList<T> myNextNode) {
		this.nextNode = myNextNode;
	}
	
}
