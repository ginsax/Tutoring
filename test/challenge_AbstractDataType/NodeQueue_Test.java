package challenge_AbstractDataType;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for testing {@linkplain Node_Queue QueueNodes}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/24/2019
 */
public class NodeQueue_Test {
  
  
  /**
   * Tests that a {@linkplain Nodeable_Queue} created with the default 
   * constructor is not null. 
   */
  @Test
  public void test_NodableDefaultConstructor_IsNotNull() {
    final Nodeable_Queue<Integer> node = new Node_Queue<Integer>();
    
    assertNotNull(node);
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with 
   * the default constructor is null. 
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_IsNull() {
    final Nodeable_Queue<Double> node = new Node_Queue<Double>();
    
    assertNull(node.getDataObject());
  }
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with 
   * the default constructor can be set. 
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_CanBeSet() {
    final Nodeable_Queue<String> node = new Node_Queue<String>();
    String dataObject = "I am a data object";
    
    node.setDataObject(dataObject);
    
    assertNotNull(node.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain Nodeable_Queue} created with the 
   * parameterized constructor is not null. 
   */
  @Test
  public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
  	final Float dataObject = new Float(69.2f);
    final Nodeable_Queue<Float> node = new Node_Queue<Float>(dataObject);
    
    assertNotNull(node.getDataObject());
  }
}