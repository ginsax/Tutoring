package challenge_AbstractDataType;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for testing {@linkplain NodeQueue QueueNodes}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/28/2019
 */
public class NodeQueue_Test {
  
  
  /**
   * Tests that a {@linkplain Nodeable_Queue} created with the default 
   * constructor is not null. 
   */
  @Test
  public void test_NodableDefaultConstructor_IsNotNull() {
    final Nodeable_Queue<Integer> node = new NodeQueue<Integer>();
    
    assertNotNull(node);
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with 
   * the default constructor is null. 
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_IsNull() {
    final Nodeable_Queue<Double> node = new NodeQueue<Double>();
    
    assertNull(node.getDataObject());
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with 
   * the default constructor can be set. 
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_CanBeSet() {
    final Nodeable_Queue<String> node = new NodeQueue<String>();
    String dataObject = "I am a data object";
    
    node.setDataObject(dataObject);
    
    assertNotNull(node.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with the 
   * data object constructor is not null. 
   */
  @Test
  public void test_Nodable_DataObjectConstructor_DataObject_IsNotNull() {
  	final Float dataObject = new Float(69.2f);
    final Nodeable_Queue<Float> node = new NodeQueue<Float>(dataObject);
    
    assertNotNull(node.getDataObject());
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with the 
   * next node constructor is not null. 
   */
  @Test
  public void test_Nodable_NextNodeConstructor_NextNode_CanBeSet() {
	  final Nodeable_Queue<Float> nodeB = new NodeQueue<Float>();
	  final Nodeable_Queue<Float> nodeA = new NodeQueue<Float>(nodeB);
	  
	  final Nodeable_Queue<Float> expected = nodeB;
	  final Nodeable_Queue<Float> actual = nodeA.getNextNode();
	  assertEquals(expected, actual);
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with the 
   * next node constructor is not null. 
   */
  @Test
  public void test_Nodable_DefaultConstructor_DataObject_IsNotNull() {
	  final Nodeable_Queue<Float> nodeB = new NodeQueue<Float>();
	  final Nodeable_Queue<Float> nodeA = new NodeQueue<Float>();
	  
	  nodeA.setNextNode(nodeB);
	  
	  final Nodeable_Queue<Float> expected = nodeB;
	  final Nodeable_Queue<Float> actual = nodeA.getNextNode();
	  assertEquals(expected, actual);
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
	  final Nodeable_Queue<Float> nodeB = new NodeQueue<Float>();
	  final Float dataObject = new Float(69.0f);
	  final Nodeable_Queue<Float> nodeA = new NodeQueue<Float>(nodeB, dataObject);
	  
	  final Nodeable_Queue<Float> expected = nodeB;
	  final Nodeable_Queue<Float> actual = nodeA.getNextNode();
	  assertEquals(expected, actual);
	  assertEquals(dataObject, nodeA.getDataObject());
  }
}