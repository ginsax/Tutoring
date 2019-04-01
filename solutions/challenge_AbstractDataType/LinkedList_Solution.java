package challenge_AbstractDataType;

/**
 * A Linked list that is linked in one direction.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/24/2019
 */
final class LinkedList_Solution<NodeDataType>
                               implements
                               LinkedListable<NodeDataType> {
	
	/** The head of this list. */
	private Nodeable_LinkedList<NodeDataType> mHead;
	
	
	/** Instantiates a new LinkedListSingle_Solution. */
	LinkedList_Solution() {
		mHead = null;
	}
	
	/**
	 * Instantiates a new LinkedListSingle_Solution.
	 * @param head The new head of this list.
	 */
	LinkedList_Solution(final Nodeable_LinkedList<NodeDataType> head) {
		this();
		mHead = head;
	}
	
	@Override
	public Nodeable_LinkedList<NodeDataType> head() {
		return mHead;
	}
	
	@Override
	public Nodeable_LinkedList<NodeDataType> tail() {
		Nodeable_LinkedList<NodeDataType> node = mHead;
		Nodeable_LinkedList<NodeDataType> lastNode = null;
		
		while (node != null) {
			lastNode = node;
			node = node.getNextNode();
		}
		
		return lastNode;
	}
	
	@Override
	public int length() {
		Nodeable_LinkedList<NodeDataType> node = mHead;
		
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
	public Nodeable_LinkedList<NodeDataType> getNodeAtIndex(final int index)
	                                                                         throws InvalidListIndexException {
		if ((index < 0) || (index >= length()) || (mHead == null)) {
			throw new InvalidListIndexException(index,
			                                    length());
		}
		
		int i = 0;
		Nodeable_LinkedList<NodeDataType> node = mHead;
		Nodeable_LinkedList<NodeDataType> lastNode = null;
		
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
	                           final Nodeable_LinkedList<NodeDataType> nextNode)
	                                                                             throws InvalidListIndexException {
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
			throw new InvalidListIndexException(index,
			                                    length());
		}
		
		int i = 0;
		Nodeable_LinkedList<NodeDataType> node = mHead;
		Nodeable_LinkedList<NodeDataType> nodeAtIndex = null;
		
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
	                              final Nodeable_LinkedList<NodeDataType> nextNode)
	                                                                                throws InvalidListIndexException {
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
			throw new InvalidListIndexException(index,
			                                    length());
		}
		
		int i = 0;
		Nodeable_LinkedList<NodeDataType> node = mHead;
		
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
	public void appendNode(final Nodeable_LinkedList<NodeDataType> node) {
		tail().setNextNode(node);
	}
	
}