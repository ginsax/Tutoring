package challenge_AbstractDataType;

public class NodeBinarySearchTree<T extends Comparable<T>> implements I_NodeBinarySearchTree<T> {

	T mDataObject;
	I_NodeBinarySearchTree<T> leftNode;
	I_NodeBinarySearchTree<T> rightNode;

	public NodeBinarySearchTree() {}
	
	public NodeBinarySearchTree(T dataObject) {
		mDataObject = dataObject;
	}
	
	public NodeBinarySearchTree(I_NodeBinarySearchTree<T> lefty, I_NodeBinarySearchTree<T> righty) {
		leftNode = lefty;
		rightNode = righty;
	}
	
	public NodeBinarySearchTree(I_NodeBinarySearchTree<T> lefty, I_NodeBinarySearchTree<T> righty, T dataObject) {
		leftNode = lefty;
		rightNode = righty;
		mDataObject = dataObject;
	}
	
	@Override
	public T getDataObject() {
		return mDataObject;
	}

	@Override
	public void setDataObject(T dataObject) {
		mDataObject = dataObject;
	}

	@Override
	public I_NodeBinarySearchTree<T> getChildNodeLeft() {
		return leftNode;
	}

	@Override
	public void setChildNodeLeft(I_NodeBinarySearchTree<T> childNodeLeft) {
		leftNode = childNodeLeft;
	}

	@Override
	public I_NodeBinarySearchTree<T> getChildNodeRight() {
		return rightNode;
	}

	@Override
	public void setChildNodeRight(I_NodeBinarySearchTree<T> childNodeRight) {
		rightNode = childNodeRight;
	}

	@Override
	public int compareTo(T o) {
		return mDataObject.compareTo(o);
	}

}
