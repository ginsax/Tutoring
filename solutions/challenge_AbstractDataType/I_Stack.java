package challenge_AbstractDataType;

/**
 * Defines a contract that all stacks will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object nodes within this stack hold.
 * @since 03/31/2019
 */
interface I_Stack<NodeDataType> {
  
  /**
   * Adds the given <code>node</code> to the top of the stack.
   * @param node The node that is to be added to the top of the stack.
   */
  void push(final I_NodeStack<NodeDataType> node);
  
  /**
   * Gets the node that is at the top of the stack without affecting the nodes
   * within the stack.
   * @return Returns the node that is at the top of the stack.
   */
  I_NodeStack<NodeDataType> peek();
  
  /**
   * Gets the node that is at the top of the stack, removing it from the stack
   * in the process.
   * @return Returns the node that is at the top of the stack.
   */
  I_NodeStack<NodeDataType> pop();
  
  /**
   * Gets whether this stack is empty.
   * @return Returns whether this stack is empty.
   */
  boolean isEmpty();
  
  /**
   * Gets whether this stack contains the given <code>node</code>.
   * @return Returns whether this stack contains the given node.
   */
  boolean contains(final I_NodeStack<NodeDataType> node);
  
  /**
   * Gets the number of nodes within this stack.
   * @return Returns the number of nodes within this stack.
   */
  int length();
}