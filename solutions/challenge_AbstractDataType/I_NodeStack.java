package challenge_AbstractDataType;

/**
 * Defines a contract that all nodes in stacks will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/31/2019
 */
public interface I_NodeStack<NodeDataType> {
  
  /**
   * Gets the data object of this node.
   * @return Returns the data object of this node.
   */
  NodeDataType getDataObject();
  
  /**
   * Sets the data object of this node.
   * @param dataObject The new data object of this node.
   */
  void setDataObject(final NodeDataType dataObject);
  
  /**
   * Gets the next node in a stack.
   * @return Returns the next node in a stack.
   */
  I_NodeStack<NodeDataType> getNextNode();
  
  /**
   * Sets the next node in a stack.
   * @param nextNode The node that is to be set as the next node in a stack.
   */
  void setNextNode(final I_NodeStack<NodeDataType> nextNode);
}