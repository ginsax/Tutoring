package challenge_AbstractDataType;

/**
 * A Linked list that is linked in one direction.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/24/2019
 */
final class Solution_LinkedList<NodeDataType>
                               implements
                               I_LinkedList<NodeDataType> {
	
	/** The head of this list. */
	private I_NodeLinkedList<NodeDataType> mHead;
	
	
	/** Instantiates a new LinkedListSingle_Solution. */
	Solution_LinkedList() {
		mHead = null;
	}
	
	/**
	 * Instantiates a new LinkedListSingle_Solution.
	 * @param head The new head of this list.
	 */
	Solution_LinkedList(final I_NodeLinkedList<NodeDataType> head) {
		this();
		mHead = head;
	}
	
	@Override
	public I_NodeLinkedList<NodeDataType> head() {
		return mHead;
	}
	
	@Override
	public I_NodeLinkedList<NodeDataType> tail() {
		I_NodeLinkedList<NodeDataType> node = mHead;
		I_NodeLinkedList<NodeDataType> lastNode = null;
		
		while (node != null) {
			lastNode = node;
			node = node.getNextNode();
		}
		
		return lastNode;
	}
	
	@Override
	public int length() {
		I_NodeLinkedList<NodeDataType> node = mHead;
		
		int count = 0;
		
		while (node != null) {
			node = node.getNextNode();
			count++;
		}
		
		return count;
	}
	
	@Override
	public boolean isEmpty() {
		return mHead == null;
	}
	
	@Override
	public I_NodeLinkedList<NodeDataType> getNodeAtIndex(final int index)
	                                                                      throws Exception_InvalidListIndex {
		if ((index < 0) || (index >= length()) || (mHead == null)) {
			throw new Exception_InvalidListIndex();
		}
		
		int i = 0;
		I_NodeLinkedList<NodeDataType> node = mHead;
		I_NodeLinkedList<NodeDataType> lastNode = null;
		
		while (node != null) {
			lastNode = node;
			node = node.getNextNode();
			
			if (i == index) {
				break;
			}
			
			i++;
		}
		
		return lastNode;
	}
	
	@Override
	public void setNodeAtIndex(final int index,
	                           final I_NodeLinkedList<NodeDataType> nextNode)
	                                                                          throws Exception_InvalidListIndex {
		if ((mHead == null) || (index == 0)) {
			
			final int length = length() == 1
			                                 ? 0
			                                 : length();
			if ((index >= 0) && (index <= length)) {
				mHead = nextNode;
				return;
			}
		}
		
		if ((index < 0) || (index > length())) {
			throw new Exception_InvalidListIndex();
		}
		
		int i = 0;
		I_NodeLinkedList<NodeDataType> node = mHead;
		I_NodeLinkedList<NodeDataType> nodeAtIndex = null;
		
		while (node != null) {
			nodeAtIndex = node;
			
			if (i == index) {
				break;
			}
			node = node.getNextNode();
			
			i++;
		}
		
		nodeAtIndex.setNextNode(nextNode);
	}
	
	@Override
	public void insertNodeAtIndex(final int index,
	                              final I_NodeLinkedList<NodeDataType> nextNode)
	                                                                             throws Exception_InvalidListIndex {
		if ((mHead == null) || (index == 0)) {
			
			final int length = length() == 1
			                                 ? 0
			                                 : length();
			if ((index >= 0) && (index <= length)) {
				mHead = nextNode;
				return;
			}
		}
		
		if ((index < 0) || (index > length())) {
			throw new Exception_InvalidListIndex();
		}
		
		int i = 0;
		I_NodeLinkedList<NodeDataType> node = mHead;
		
		while (node != null) {
			
			if (i == index) {
				break;
			}
			node = node.getNextNode();
			
			i++;
		}
		
		getNodeAtIndex(i - 1).setNextNode(nextNode);
		appendNode(node);
	}
	
	@Override
	public void appendNode(final I_NodeLinkedList<NodeDataType> node) {
		tail().setNextNode(node);
	}
	
}