package challenge_AbstractDataType;

/**
 * Defines a contract that all nodes in linked lists will implement.
 * @author jacobwatson
 * @version 1.0
 * @param <NodeDataType> The type of data object this node holds.
 * @since 03/24/2019
 */
public interface I_NodeLinkedList<NodeDataType> {
    
    
    /**
     * Gets the next node in a list.
     * @return Returns the next node in a list.
     */
    I_NodeLinkedList<NodeDataType> getNextNode();
    /**
     * Sets the next node in a list.
     * @param nextNode The node that is to be set as the next node in a list.
     */
    void setNextNode(final I_NodeLinkedList<NodeDataType> nextNode);
    
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
}