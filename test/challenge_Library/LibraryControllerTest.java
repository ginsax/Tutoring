package challenge_Library;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;

import javafxRule.JavaFXThreadingRule;


/**
 * Test class that is intended to test the {@link LibraryController} class}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/19/2019
 */
public class LibraryControllerTest {
  /** Required to run tests on JavaFX thread. */
  @Rule public JavaFXThreadingRule mThreadingRule = new JavaFXThreadingRule();
  
  /** The library controller that is to be tested. */
  private LibraryController mLibraryController;
  
  /**
   * Tests that a library controller can load from a file.
   * @throws EmptyFileNameException
   */
  @Test
  public void test_LibraryController_CanLoadFromFile() throws EmptyFileNameException {
    mLibraryController = new LibraryController("Test.csv");
    
    assertNotNull(mLibraryController);
  }
  /**
   * Tests that a library controller can handle a file name that is empty.
   * @throws EmptyFileNameException
   */
  @Test (expected = EmptyFileNameException.class)
  public void test_LibraryController_CanHandleEmptyFileName() throws EmptyFileNameException {
    mLibraryController = new LibraryController("");
    
    assertNotNull(mLibraryController);
  }
  /**
   * Tests that a library controller can handle a file name that is null.
   * @throws EmptyFileNameException
   */
  @Test (expected = EmptyFileNameException.class)
  public void test_LibraryController_CanHandleNullFileName() throws EmptyFileNameException {
    mLibraryController = new LibraryController(null);
    
    assertNotNull(mLibraryController);
  }
}