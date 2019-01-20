package challenge_Library;

/**
 * Exception that is intended to be thrown when an empty file name has been 
 * encountered.
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
@SuppressWarnings("serial")
public class EmptyFileNameException extends LibraryException {
  
  
  /**
   * Initializes a Library exception.
   */
  public EmptyFileNameException() {
    super();
  }
  /**
   * Initializes an empty file name exception with the given 
   * {@code errorMessage}.
   * @param errorMessage The reason for the error message.
   */
  public EmptyFileNameException(String errorMessage) {
    super(errorMessage);
  }
  
  
}