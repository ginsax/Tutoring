package challenge_Library;

/**
 * Exception that is intended to be thrown when an invalid book series name 
 * has been encountered.
 * @author jacobwatson
 * @version 1.0
 * @since 01/18/2019
 */
@SuppressWarnings("serial")
public class InvalidBookSeriesNameException extends LibraryException {

  /**
   * Initializes a InvalidBookSeriesNameException.
   */
  public InvalidBookSeriesNameException() {
    super();
  }
  /**
   * Initializes an invalid book series name exception with the given 
   * {@code errorMessage}.
   * @param errorMessage The reason for the error message.
   */
  public InvalidBookSeriesNameException(String errorMessage) {
    super(errorMessage);
  }
  
}