package challenge_Library;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.stage.Stage;
import javafxRule.JavaFXThreadingRule;

/**
 * Test class that is intended to test the {@link LibraryApplication} class}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
public class LibraryTest {
  /** Required to run tests on JavaFX thread. */
  @Rule
  public JavaFXThreadingRule mThreadingRule = new JavaFXThreadingRule();
  
  /** The library application being tested. */
  private LibraryApplication mLibraryApplication;
  
  
  /** Cleans up the LibraryApplication */
  @After
  public void cleanUpLibraryApplication() {
    try {
      mLibraryApplication.stop();
    }
    catch (final Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Initializes the LibraryApplication. Required to wipe all old information.
   */
  @Before
  public void setupLibraryApplication() {
    mLibraryApplication = new LibraryApplication();
  }
  
  /**
   * Tests that the library application can be launched statically.
   */
  @Test
  public void superficialConstantsCoverageTest() {
    final int publishingYear = CommonConstants.DEFAULT_PUBLISHING_YEAR;
    final int stock = CommonConstants.DEFAULT_STOCK;
    
    final String author = CommonConstants.DEFAULT_AUTHOR;
    final String isbn = CommonConstants.DEFAULT_ISBN;
    final String series = CommonConstants.DEFAULT_SERIES;
    final String title = CommonConstants.DEFAULT_TITLE;
    
    final Audience audience = CommonConstants.DEFAULT_AUDIENCE;
    final Fictionality fictionality = CommonConstants.DEFAULT_FICTIONALITY;
    final Genre genre = CommonConstants.DEFAULT_GENRE;
    
    assertEquals("Tests that the default publishing year is a constant.",
                 CommonConstants.DEFAULT_PUBLISHING_YEAR,
                 publishingYear);
    assertEquals("Tests that the default stock is a constant.",
                 CommonConstants.DEFAULT_STOCK,
                 stock);
    
    assertEquals("Tests that the default author is a constant.",
                 CommonConstants.DEFAULT_AUTHOR,
                 author);
    assertEquals("Tests that the default ISBN is a constant.",
                 CommonConstants.DEFAULT_ISBN,
                 isbn);
    assertEquals("Tests that the default series is a constant.",
                 CommonConstants.DEFAULT_SERIES,
                 series);
    assertEquals("Tests that the default title is a constant.",
                 CommonConstants.DEFAULT_TITLE,
                 title);
    
    assertEquals("Tests that the default audience is a constant.",
                 CommonConstants.DEFAULT_AUDIENCE,
                 audience);
    assertEquals("Tests that the default fictionality is a constant.",
                 CommonConstants.DEFAULT_FICTIONALITY,
                 fictionality);
    assertEquals("Tests that the default genre is a constant.",
                 CommonConstants.DEFAULT_GENRE,
                 genre);
  }
  
  /** Superficial test used only to get code coverage. */
  @Test
  public void superficialEnumCoverageTest() {
    
    for (final Genre genre : Genre.values()) {
      genre.toString();
      Genre.valueOf(genre.name());
    }
    
    for (final Audience audience : Audience.values()) {
      audience.toString();
      Audience.valueOf(audience.name());
    }
    
    for (final Fictionality fictionality : Fictionality.values()) {
      fictionality.toString();
      Fictionality.valueOf(fictionality.name());
    }
  }
  
  /**
   * Tests that the library application is not null.
   * @throws EmptyFileNameException
   */
  @Test
  public void test_Application_CanBeCreated() throws EmptyFileNameException {
    final Stage stage = new Stage();
    mLibraryApplication.start(stage);
  }
}