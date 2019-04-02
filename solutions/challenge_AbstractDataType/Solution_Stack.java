package challenge_AbstractDataType;

/**
 * Defines a stack that implements the {@linkplain I_Stack} interface.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object the nodes of this stack hold.
 * @since 04/01/2019
 */
public class Solution_Stack<NodeDataType> implements I_Stack<NodeDataType> {
	
	/** The top element in this stack. */
	private I_NodeStack<NodeDataType> mTop;
	
	
	/** Initializes a new Stack. Fields are set to null. */
	public Solution_Stack() {
		mTop = null;
	}
	/**
	 * Initializes a new Stack, setting the top node in the process.
	 * @param dataObject The data object to be set as the top node.
	 */
	public Solution_Stack(final NodeDataType dataObject) {
		this();
		push(dataObject);
	}
	/**
	 * Initializes a new Stack, setting the nodes in the process.
	 * @param dataObjects The data objects to be pushed in order.
	 */
	@SafeVarargs
	public Solution_Stack(final NodeDataType... dataObjects) {
		this();
		
		for (final NodeDataType dataObject : dataObjects) {
			push(dataObject);
		}
	}
	
	@Override
	public void push(final NodeDataType dataObject) {
		if (mTop == null) {
			mTop = new Solution_NodeStack<NodeDataType>(dataObject);
		}
		else {
			mTop
			    = new Solution_NodeStack<NodeDataType>(mTop,
			                                           dataObject);
		}
	}
	
	@Override
	public NodeDataType peek() {
		if (mTop == null) {
			throw new Exception_EmptyStack();
		}
		
		return mTop.getDataObject();
	}
	
	@Override
	public NodeDataType pop() {
		if (mTop == null) {
			throw new Exception_EmptyStack();
		}
		
		final I_NodeStack<NodeDataType> node = mTop;
		mTop = node.getNextNode();
		
		return node.getDataObject();
	}
	
	@Override
	public boolean isEmpty() {
		return mTop == null;
	}
	
	@Override
	public boolean contains(final NodeDataType dataObject) {
		boolean stackContainsDataObject = false;
		I_NodeStack<NodeDataType> node = mTop;
		
		while (node != null) {
			if (node.getDataObject() == dataObject) {
				stackContainsDataObject = true;
				break;
			}
			
			node = node.getNextNode();
		}
		
		return stackContainsDataObject;
	}
	
	@Override
	public int size() {
		int size = 0;
		
		I_NodeStack<NodeDataType> node = mTop;
		
		while (node != null) {
			size++;
			node = node.getNextNode();
		}
		
		return size;
	}
	
}