package challenge_AbstractDataType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for testing {@linkplain NodeStack NodeStacks}.
 * @author jacobwatson
 * @version 1.0
 * @since 03/31/2019
 */
public class Test_NodeStack {
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * data object constructor is not null.
   */
  @Test
  public void test_Nodable_DataObjectConstructor_DataObject_IsNotNull() {
    final Float dataObject = new Float(69.2f);
    final I_NodeStack<Float> node = new NodeStack<Float>(dataObject);
    
    assertNotNull(node.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * next node constructor is not null.
   */
  @Test
  public void test_Nodable_DefaultConstructor_DataObject_IsNotNull() {
    final I_NodeStack<Float> nodeB = new NodeStack<Float>();
    final I_NodeStack<Float> nodeA = new NodeStack<Float>();
    
    nodeA.setNextNode(nodeB);
    
    final I_NodeStack<Float> expected = nodeB;
    final I_NodeStack<Float> actual = nodeA.getNextNode();
    assertEquals(expected,
                 actual);
  }
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * next node constructor is not null.
   */
  @Test
  public void test_Nodable_NextNodeConstructor_NextNode_CanBeSet() {
    final I_NodeStack<Float> nodeB = new NodeStack<Float>();
    final I_NodeStack<Float> nodeA = new NodeStack<Float>(nodeB);
    
    final I_NodeStack<Float> expected = nodeB;
    final I_NodeStack<Float> actual = nodeA.getNextNode();
    assertEquals(expected,
                 actual);
  }
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * parameterized constructor is not null.
   */
  @Test
  public void test_Nodable_ParameterizedConstructor_DataObject_IsNotNull() {
    final I_NodeStack<Float> nodeB = new NodeStack<Float>();
    final Float dataObject = new Float(69.0f);
    final I_NodeStack<Float> nodeA = new NodeStack<Float>(nodeB,
                                                                   dataObject);
    
    final I_NodeStack<Float> expected = nodeB;
    final I_NodeStack<Float> actual = nodeA.getNextNode();
    assertEquals(expected,
                 actual);
    assertEquals(dataObject,
                 nodeA.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * default constructor can be set.
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_CanBeSet() {
    final I_NodeStack<String> node = new NodeStack<String>();
    final String dataObject = "I am a data object";
    
    node.setDataObject(dataObject);
    
    assertNotNull(node.getDataObject());
  }
  
  /**
   * Tests that the data object of a {@linkplain I_NodeStack} created with the
   * default constructor is null.
   */
  @Test
  public void test_NodableDefaultConstructor_DataObject_IsNull() {
    final I_NodeStack<Double> node = new NodeStack<Double>();
    
    assertNull(node.getDataObject());
  }
  
  /**
   * Tests that a {@linkplain I_NodeStack} created with the default constructor
   * is not null.
   */
  @Test
  public void test_NodableDefaultConstructor_IsNotNull() {
    final I_NodeStack<Integer> node = new NodeStack<Integer>();
    
    assertNotNull(node);
  }
}