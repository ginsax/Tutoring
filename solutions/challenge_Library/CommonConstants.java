package challenge_Library;


/**
 * Constants commonly used through out the library challenge.
 * @author jacobwatson
 * @since 01/18/2019
 */
public abstract class CommonConstants {
  
  /** 
   * The default value used for the publishing year of a book. 
   * Value = {@value #DEFAULT_PUBLISHING_YEAR}. 
   */
  final static int DEFAULT_PUBLISHING_YEAR = 0000;
  
  /** 
   * The default value used for the stock of a book. 
   * Value = {@value #DEFAULT_STOCK}. 
   */
  final static int DEFAULT_STOCK =  -1;
  
  /** 
   * The default value used for the author of a book. 
   * Value = {@value #DEFAULT_AUTHOR}. 
   */
  final static String DEFAULT_AUTHOR = "No Author";
  
  /** 
   * The default value used for the ISBN of a book. 
   * Value = {@value #DEFAULT_ISBN}. 
   */
  final static String DEFAULT_ISBN = "000-0000000000";
  
  /** 
   * The default value used for the series of a book. 
   * Value = {@value #DEFAULT_SERIES}. 
   */
  final static String DEFAULT_SERIES = "No Series";
  
  /** 
   * The default value used for the title of a book. 
   * Value = {@value #DEFAULT_TITLE}. 
   */
  final static String DEFAULT_TITLE = "No Book Title";
  
  /** 
   * The default value used for the intended audience of a book. 
   * Value = {@value #DEFAULT_AUDIENCE}. 
   */
  static final Audience DEFAULT_AUDIENCE = Audience.DefaultAudience;
  
  /** 
   * The default value used for the fictionality of a book. 
   * Value = {@value #DEFAULT_FICTIONALITY}. 
   */
  static final Fictionality DEFAULT_FICTIONALITY = Fictionality.DefaultFictionality;
  
  /** 
   * The default value used for the genre of a book. 
   * Value = {@value #DEFAULT_GENRE}. 
   */
  static final Genre DEFAULT_GENRE = Genre.DefaultGenre;
  
}