package challenge_AbstractDataType;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for testing {@linkplain Node Nodes}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class NodeLinkedList_Test {
  
  
  /**
   * Tests that a {@linkplain Nodeable_LinkedList} created with the default constructor is not null. 
   */
  @Test
  public void test_NodableDefaultConstructor_IsNotNull() {
    final Nodeable_LinkedList<Integer> node = new NodeLinkedList<Integer>();
    
    assertNotNull(node);
  }
  /**
   * Tests that the next node of a {@linkplain Nodeable_LinkedList} created with the 
   * default constructor is null. 
   */
  @Test
  public void test_NodableDefaultConstructor_NextNode_IsNull() {
    final Nodeable_LinkedList<Integer> node = new NodeLinkedList<Integer>();
    
    assertNull(node.getNextNode());
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * default constructor is null. 
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_IsNull() {
    final Nodeable_LinkedList<Integer> node = new NodeLinkedList<Integer>();
    
    assertNull(node.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * Node constructor is null. 
   */
  @Test
  public void test_Nodable_NodeConstructor_DataObject_IsNull() {
    final Nodeable_LinkedList<Integer> nodeB = new NodeLinkedList<Integer>();
    final Nodeable_LinkedList<Integer> nodeA = new NodeLinkedList<Integer>(nodeB);
    
    assertNull(nodeA.getDataObject());
  }
  /**
   * Tests that the next node of a {@linkplain Nodeable_LinkedList} created with the 
   * Node constructor is not null. 
   */
  @Test
  public void test_Nodable_NodeConstructor_NextNode_IsNotNull() {
    final Nodeable_LinkedList<Double> nodeB = new NodeLinkedList<Double>();
    final Nodeable_LinkedList<Double> nodeA = new NodeLinkedList<Double>(nodeB);
    
    final Nodeable_LinkedList<Double> expected = nodeB;
    final Nodeable_LinkedList<Double> actual = nodeA.getNextNode();
    assertEquals(expected, actual);
  }
  
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * Data Object constructor is not null. 
   */
  @Test
  public void test_Nodable_DataObjectConstructor_DataObject_IsNotNull() {
    final Double dataObject = new Double(69.69);
    final Nodeable_LinkedList<Double> nodeA = new NodeLinkedList<Double>(dataObject);
    
    assertNotNull(nodeA.getDataObject());
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * has the value that was passed in to the constructor. 
   */
  @Test
  public void test_Nodable_DataObjectConstructor_DataObject_HasSetValue() {
    final Double expected = 69.69;
    
    final Double dataObject = new Double(expected);
    final Nodeable_LinkedList<Double> node = new NodeLinkedList<Double>(dataObject);
    
    final Double actual = node.getDataObject();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * Node constructor is null. 
   */
  @Test
  public void test_Nodable_DataObjectConstructor_NextNode_IsNull() {
    final Nodeable_LinkedList<Double> nodeB = new NodeLinkedList<Double>();
    final Nodeable_LinkedList<Double> nodeA = new NodeLinkedList<Double>(nodeB);
    
    final Nodeable_LinkedList<Double> expected = nodeB;
    final Nodeable_LinkedList<Double> actual = nodeA.getNextNode();
    assertEquals(expected, actual);
  }
  
  /**
   * Tests that the data object of a {@linkplain Nodeable_LinkedList} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
    final Double dataObjectB = new Double(96.96);
    final Nodeable_LinkedList<Double> nodeB = new NodeLinkedList<Double>(dataObjectB);
    
    final Double dataObjectA = new Double(69.69);
    final Nodeable_LinkedList<Double> nodeA = new NodeLinkedList<Double>(nodeB, dataObjectA);
    
    
    final Double expected = dataObjectB;
    final Double actual   = nodeA.getNextNode().getDataObject();
    assertEquals(expected, actual);
  }
  /**
   * Tests that the next node of a {@linkplain Nodeable_LinkedList} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_Nodable_ParameterizedConstructor_NextNode_IsNotNull() {
    final Double dataObjectB = new Double(96.96);
    final Nodeable_LinkedList<Double> nodeB = new NodeLinkedList<Double>(dataObjectB);
    
    final Double dataObjectA = new Double(69.69);
    final Nodeable_LinkedList<Double> nodeA = new NodeLinkedList<Double>(nodeB, dataObjectA);
    
    
    final Nodeable_LinkedList<Double> expected = nodeB;
    final Nodeable_LinkedList<Double> actual   = nodeA.getNextNode();
    assertEquals(expected, actual);
  }
  
  /** Tests that the data object of a {@linkplain Nodeable_LinkedList} can be set. */
  @Test
  public void test_Nodable_DataObject_CanBeSet() {
    final Double expected = new Double(69.69);
    
    final Nodeable_LinkedList<Double> node = new NodeLinkedList<Double>();
    node.setDataObject(expected);
    
    final Double actual = node.getDataObject();
    assertEquals(expected, actual);
  }
  /** Tests that the next node of a {@linkplain Nodeable_LinkedList} can be set. */
  @Test
  public void test_Nodable_NextNode_CanBeSet() {
    final Nodeable_LinkedList<String> nodeA = new NodeLinkedList<String>();
    final Nodeable_LinkedList<String> nodeB = new NodeLinkedList<String>();
    
    nodeA.setNextNode(nodeB);
    
    final Nodeable_LinkedList<String> expected = nodeB;
    final Nodeable_LinkedList<String> actual = nodeA.getNextNode();
    assertEquals(expected, actual);
  }
}