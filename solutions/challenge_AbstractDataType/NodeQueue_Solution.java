package challenge_AbstractDataType;

import java.util.Queue;

/**
 * Nodes to be used in {@linkplain Queue Queues}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/28/2019
 */
public class NodeQueue_Solution<NodeDataObject>
                               implements
                               Nodeable_Queue<NodeDataObject> {
	
	private NodeDataObject									mDataObject;
	private Nodeable_Queue<NodeDataObject>	mNextNode;
	
	
	/** Instantiates a new Node_Queue. Sets all fields to null. */
	NodeQueue_Solution() {
		mDataObject = null;
		mNextNode = null;
	}
	
	/**
	 * Instantiates a new Node_Queue with the given <code>nodeDataObject</code>.
	 * @param nodeDataObject The data object this node holds.
	 */
	NodeQueue_Solution(final NodeDataObject nodeDataObject) {
		this();
		mDataObject = nodeDataObject;
	}
	
	/**
	 * Instantiates a new Node_Queue with the given <code>nextNode</code>.
	 * @param nextNode The next node in a queue after this node.
	 */
	NodeQueue_Solution(final Nodeable_Queue<NodeDataObject> nextNode) {
		this();
		mNextNode = nextNode;
	}
	
	/**
	 * Instantiates a new Node_Queue with the given <code>nextNode</code> and
	 * <code>nodeDataObject</code>.
	 * @param nextNode The next node in a queue after this node.
	 * @param nodeDataObject The data object this node holds.
	 */
	NodeQueue_Solution(final Nodeable_Queue<NodeDataObject> nextNode,
	                   final NodeDataObject nodeDataObject) {
		this();
		mNextNode = nextNode;
		mDataObject = nodeDataObject;
	}
	
	@Override
	public Nodeable_Queue<NodeDataObject> getNextNode() {
		return mNextNode;
	}
	
	@Override
	public void setNextNode(final Nodeable_Queue<NodeDataObject> nextNode) {
		mNextNode = nextNode;
	}
	
	@Override
	public NodeDataObject getDataObject() {
		return mDataObject;
	}
	
	@Override
	public void setDataObject(final NodeDataObject dataObject) {
		mDataObject = dataObject;
	}
}