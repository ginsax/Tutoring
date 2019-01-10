package challenge_Library;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;

import org.junit.Test;

import javafx.application.Application;
import javafx.collections.ObservableList;

public class LibraryTest {

	@Test
	public void test_Application_CanBeCreated() {
		final LibraryApplication_Test app = new LibraryApplication_Test();
		
		Application.launch(app.getClass());
		
		assertNotNull(app);
	}
	
	@Test
	public void test_Controller_CanBeCreated() {
		LibraryController controller = null;
		try {
			controller = new LibraryController("Test.csv");
		} catch (EmptyFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(controller);
	}
}