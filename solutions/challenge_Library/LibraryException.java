package challenge_Library;

/**
 * Abstract super class for exceptions that can be encountered within the
 * challenge_Library project.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/19/2019
 */
@SuppressWarnings("serial")
public abstract class LibraryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The reason for this exception being thrown. */
	private final String mErrorMessage;

	/**
	 * Initializes a Library exception.
	 */
	public LibraryException() {
		super();
		mErrorMessage = super.getMessage();
	}

	/**
	 * Initializes an Library exception with the given {@code errorMessage}.
	 * 
	 * @param errorMessage The reason for the error message.
	 */
	public LibraryException(final String errorMessage) {
		mErrorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return mErrorMessage;
	}
}