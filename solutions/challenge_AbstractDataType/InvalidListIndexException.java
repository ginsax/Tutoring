package challenge_AbstractDataType;

/**
 * An exception that is thrown when the length of a list is greater than the
 * given index.
 * @author jacobwatson
 * @version 1.0
 * @since 03/29/2019
 */
class InvalidListIndexException extends RuntimeException {
  /** The default serial version identifier. */
  private static final long serialVersionUID = 1L;
  private final int         mIndex, mLength;
  
  
  /** Instantiates a new Invalid List Index Exception. */
  InvalidListIndexException(final int index, final int length) {
    mIndex = index;
    mLength = length;
  }
  
  @Override
  public String getMessage() {
    return String
        .format("The index [%d] is greater than the length of this list [%d].",
                mIndex,
                mLength);
  }
}