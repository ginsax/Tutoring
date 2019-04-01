package challenge_AbstractDataType;

public class Solution_NodeStack<NodeDataType> implements I_NodeStack<NodeDataType> {
  /** The data object of this node. */
  private NodeDataType              mDataObject;
  /** The next node in a queue. */
  private I_NodeStack<NodeDataType> mNextNode;
  
  
  /** Instantiates a new NodeStack. Sets all fields to null. */
  public Solution_NodeStack() {
    mNextNode = null;
    mDataObject = null;
  }
  
  /**
   * Instantiates a new NodeStack with the given <code>nextNode</code>.
   * @param nextNode The next node in a stack after this node.
   */
  public Solution_NodeStack(final I_NodeStack<NodeDataType> nextNode) {
    this();
    mNextNode = nextNode;
  }
  
  /**
   * Instantiates a new NodeStack with the given <code>nodeDataObject</code>.
   * @param nodeDataObject The data object this node holds.
   */
  public Solution_NodeStack(final NodeDataType dataObject) {
    this();
    mDataObject = dataObject;
  }
  
  /**
   * Instantiates a new NodeStack with the given <code>nextNode</code> and
   * <code>nodeDataObject</code>.
   * @param nextNode The next node in a stack after this node.
   * @param nodeDataObject The data object this node holds.
   */
  public Solution_NodeStack(final I_NodeStack<NodeDataType> nextNode,
                            final NodeDataType dataObject) {
    this();
    mNextNode = nextNode;
    mDataObject = dataObject;
  }
  
  @Override
  public NodeDataType getDataObject() {
    return mDataObject;
  }
  
  @Override
  public void setDataObject(final NodeDataType dataObject) {
    mDataObject = dataObject;
  }
  
  @Override
  public I_NodeStack<NodeDataType> getNextNode() {
    return mNextNode;
  }
  
  @Override
  public void setNextNode(final I_NodeStack<NodeDataType> nextNode) {
    mNextNode = nextNode;
  }
}