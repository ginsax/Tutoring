package challenge_AbstractDataType;

/**
 * Defines a contract that all Queues will implement.
 * 
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data objects within this queue.
 * @since 03/28/2019
 */
interface I_Queue<NodeDataType> {

	/**
	 * Removes the first node in the queue.
	 * 
	 * @return Returns the first node in the queue, removing it in the process.
	 */
	NodeDataType dequeue();

	/**
	 * Adds the given <code>nodeToAdd</code> to the queue. This node is placed at
	 * the end of the queue.
	 * 
	 * @param nodeToAdd The node that is added to the end of the queue.
	 */
	void enqueue(@SuppressWarnings("unchecked") final NodeDataType... nodesToAdd);

	/**
	 * Gets whether this queue is empty.
	 * 
	 * @return Returns whether this queue is empty.
	 */
	boolean isEmpty();

	/**
	 * Gets the number of nodes within this queue.
	 * 
	 * @return Returns the number of nodes within this queue.
	 */
	int length();

	/**
	 * Observes the first node in the queue, without removing it.
	 * 
	 * @return Returns the first node in the queue, without removing it.
	 */
	NodeDataType peek();
}