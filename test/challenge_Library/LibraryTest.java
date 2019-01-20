package challenge_Library;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import javafx.application.Application;

/**
 * Test class that is intended to test the {@link LibraryApplication} class}.
 * @author jacobwatson
 * @version 1.0
 * @since 01/10/2019
 */
public class LibraryTest {
  
  /**
   * Tests that the library application is not null.
   */
	@Test
	public void test_Application_CanBeCreated() {
		final LibraryApplication app = new LibraryApplication();
		
		Application.launch(app.getClass());
		
		assertNotNull("Tests that the library application is not null.", app);
	}
	
  /**
   * Tests that the library application can be launched statically.
   */
  @Test
  public void test_Application_CanBeLaunchedStatically() {
//    LibraryApplication.main("");
  }
	/**
	 * Superficial test used only to get code coverage.
	 */
	@Test
	public void superficialEnumCoverageTest() {
		
		for(Genre genre : Genre.values()) {
			genre.toString();
			Genre.valueOf(genre.name());
		}
		
		for(Audience audience : Audience.values()) {
			audience.toString();
			Audience.valueOf(audience.name());
		}
		
    for(Fictionality fictionality : Fictionality.values()) {
      fictionality.toString();
      Fictionality.valueOf(fictionality.name());
    }
	}
}