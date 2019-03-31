package challenge_AbstractDataType;

/**
 * Defines a contract that all Linked lists will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object nodes within this list hold.
 * @since 03/31/2019
 */
interface I_LinkedList<NodeDataType> {
  
  /**
   * Adds a node at the given <code>index</code> within the list.
   * @param index The index to retrieve a node from.
   * @return Returns a node at the given index within the list.
   * @throws InvalidListIndexException Thrown if the given index is greater than
   *           the length of the list.
   */
  void appendNode(final I_NodeLinkedList<NodeDataType> node);
  
  /**
   * Gets a node at the given <code>index</code> within the list.
   * @param index The index to retrieve a node from.
   * @return Returns a node at the given index within the list.
   * @throws InvalidListIndexException Thrown if the given index is greater than
   *           the length of the list.
   */
  I_NodeLinkedList<NodeDataType> getNodeAtIndex(final int index) throws InvalidListIndexException;
  
  /**
   * Gets the first node in the list.
   * @return Returns the first node in the list.
   */
  I_NodeLinkedList<NodeDataType> head();
  
  void insertNodeAtIndex(final int index,
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
  
  void setNodeAtIndex(final int index,
                      final I_NodeLinkedList<NodeDataType> node) throws InvalidListIndexException;
  
  /**
   * Gets the last node in the list.
   * @return Returns the last node in the list.
   */
  I_NodeLinkedList<NodeDataType> tail();
}