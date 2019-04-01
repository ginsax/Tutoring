package challenge_AbstractDataType;

/**
 * Defines a contract that all stacks will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data objects within this stack.
 * @since 03/31/2019
 */
interface I_Stack<NodeDataType> {
	
	/**
	 * Adds the given <code>dataObject</code> to the top of the stack.
	 * @param dataObject The data object that is to be added to the top of the
	 *          stack.
	 */
	void push(final NodeDataType dataObject);
	
	/**
	 * Gets the data object that is at the top of the stack without affecting the
	 * other data objects within the stack.
	 * @return Returns the data object that is at the top of the stack.
	 */
	NodeDataType peek();
	
	/**
	 * Gets the data object that is at the top of the stack, removing it from the
	 * stack in the process.
	 * @return Returns the data object that is at the top of the stack.
	 */
	NodeDataType pop();
	
	/**
	 * Gets whether this stack is empty.
	 * @return Returns whether this stack is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Gets whether this stack contains the given <code>dataObject</code>.
	 * @param dataObject The data object to switch within this stack for.
	 * @return Returns whether this stack contains the given data object.
	 */
	boolean contains(final NodeDataType dataObject);
	
	/**
	 * Gets the number of data objects within this stack.
	 * @return Returns the number of data objects within this stack.
	 */
	int size();
}