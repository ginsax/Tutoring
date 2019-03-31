package challenge_AbstractDataType;

/**
 * A node within a linked list.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/24/2019
 */
final class Solution_NodeLinkedList<NodeDataType> implements I_NodeLinkedList<NodeDataType> {
  /** The data object of this node. */
  private NodeDataType                   mDataObject;
  /** The next node in a list. */
  private I_NodeLinkedList<NodeDataType> mNextNode;
  
  
  /** Instantiates a new node. */
  Solution_NodeLinkedList() {
    mNextNode = null;
    mDataObject = null;
  }
  
  /**
   * Instantiates a new node with the given <code>nextNode</code>.
   * @param nextNode The next node in a list.
   */
  Solution_NodeLinkedList(final I_NodeLinkedList<NodeDataType> nextNode) {
    this();
    mNextNode = nextNode;
  }
  
  /**
   * Instantiates a new node with the given <code>nextNode</code> and
   * <code>dataObject</code>.
   * @param nextNode The next node in a list.
   * @param dataObject The data object of this node.
   */
  Solution_NodeLinkedList(final I_NodeLinkedList<NodeDataType> nextNode,
                          final NodeDataType dataObject) {
    this();
    mNextNode = nextNode;
    mDataObject = dataObject;
  }
  
  /**
   * Instantiates a new node with the given <code>dataObject</code>.
   * @param dataObject The data object of this node.
   */
  Solution_NodeLinkedList(final NodeDataType dataObject) {
    this();
    mDataObject = dataObject;
  }
  
  @Override
  public NodeDataType getDataObject() {
    return mDataObject;
  }
  
  @Override
  public I_NodeLinkedList<NodeDataType> getNextNode() {
    return mNextNode;
  }
  
  @Override
  public void setDataObject(final NodeDataType dataObject) {
    mDataObject = dataObject;
  }
  
  @Override
  public void setNextNode(final I_NodeLinkedList<NodeDataType> nextNode) {
    mNextNode = nextNode;
  }
}