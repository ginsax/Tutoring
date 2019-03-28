package challenge_AbstractDataType;

/**
 * Defines a contract that all Singly Linked lists will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object nodes within this list hold. 
 * @since 03/24/2019
 */
interface LinkedListable<NodeDataType> {
  
  /**
   * Gets the first node in the list.
   * @return Returns the first node in the list.
   */
  Nodeable_LinkedList<NodeDataType> head();
  /**
   * Gets the last node in the list.
   * @return Returns the last node in the list.
   */
  Nodeable_LinkedList<NodeDataType> tail();
  
  /**
   * Gets the number of nodes within this list.
   * @return Returns the number of nodes within this list.
   */
  int length();
  /**
   * Gets whether this list is empty.
   * @return Returns whether this list is empty.
   */
  boolean isEmpty();
}