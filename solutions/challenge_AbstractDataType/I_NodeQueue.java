package challenge_AbstractDataType;

/**
 * Defines a contract that all nodes in queues will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/28/2019
 */
public interface I_NodeQueue<NodeDataType> {
  
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
   * Gets the next node in a queue.
   * @return Returns the next node in a queue.
   */
  I_NodeQueue<NodeDataType> getNextNode();
  
  /**
   * Sets the next node in a queue.
   * @param nextNode The node that is to be set as the next node in a queue.
   */
  void setNextNode(final I_NodeQueue<NodeDataType> nextNode);
}