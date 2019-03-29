package challenge_AbstractDataType;

/**
 * A node within a linked list.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/24/2019
 */
final class NodeLinkedList_Solution<NodeDataType> implements Nodeable_LinkedList<NodeDataType> {
  /** The data object of this node. */
  private NodeDataType mDataObject;
  /** The next node in a list. */
  private Nodeable_LinkedList<NodeDataType> mNextNode;
  
  
  /** Instantiates a new node. */
  NodeLinkedList_Solution() {
    mNextNode   = null;
    mDataObject = null;
  }
  /**
   * Instantiates a new node with the given <code>dataObject</code>.
   * @param dataObject The data object of this node.
   */
  NodeLinkedList_Solution(final NodeDataType dataObject) {
    this();
    mDataObject = dataObject;
  }
  /**
   * Instantiates a new node with the given <code>nextNode</code>.
   * @param nextNode The next node in a list.
   */
  NodeLinkedList_Solution(final Nodeable_LinkedList<NodeDataType> nextNode) {
    this();
    mNextNode   = nextNode;
  }
  /**
   * Instantiates a new node with the given <code>nextNode</code> and 
   * <code>dataObject</code>.
   * @param nextNode The next node in a list.
   * @param dataObject The data object of this node.
   */
  NodeLinkedList_Solution(final Nodeable_LinkedList<NodeDataType> nextNode, 
                final NodeDataType dataObject) {
    this();
    mNextNode   = nextNode;
    mDataObject = dataObject;
  }
  
  
  @Override
  public Nodeable_LinkedList<NodeDataType> getNextNode() {
    return mNextNode;
  }
  @Override
  public void setNextNode(final Nodeable_LinkedList<NodeDataType> nextNode) {
    mNextNode = nextNode;
  }
  
  @Override
  public NodeDataType getDataObject() {
    return mDataObject;
  }
  @Override
  public void setDataObject(final NodeDataType dataObject) {
    mDataObject = dataObject;
  }
}