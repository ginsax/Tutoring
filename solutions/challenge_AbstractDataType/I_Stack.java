package challenge_AbstractDataType;

/**
 * Defines a contract that all stacks will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object nodes within this stack hold.
 * @since 03/31/2019
 */
interface I_Stack<NodeDataType> {
  
  public void appendNode(final I_NodeLinkedList<NodeDataType> node);
  
  public I_NodeLinkedList<NodeDataType> getNodeAtIndex(final int index) throws InvalidListIndexException;
  
  /**
   * Gets the first node in the list.
   * @return Returns the first node in the list.
   */
  I_NodeLinkedList<NodeDataType> head();
  
  public void insertNodeAtIndex(final int index,
                                final I_NodeLinkedList<NodeDataType> node) throws InvalidListIndexException;
  
  /**
   * Gets whether this list is empty.
   * @return Returns whether this list is empty.
   */
  boolean isEmpty();
  
  /**
   * Gets the number of nodes within this list.
   * @return Returns the number of nodes within this list.
   */
  int length();
  
  public void setNodeAtIndex(final int index,
                             final I_NodeLinkedList<NodeDataType> node) throws InvalidListIndexException;
  
  /**
   * Gets the last node in the list.
   * @return Returns the last node in the list.
   */
  I_NodeLinkedList<NodeDataType> tail();
}