package challenge_Library;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Main entry level of the Library Application.
 * @author jacobwatson
 * @version 1.0
 * @since 01/07/2019
 */
public class LibraryApplication extends Application {
  
  /**
   * Main method, this is called to start the application.
   * @param args String arguments passed on to application.
   */
  public static void main(final String... args) {
    Application.launch(args);
  }
  
  @Override
  public void start(final Stage stage) throws EmptyFileNameException {
    final double MIN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth() /
                             2;
    final double MIN_HEIGHT = Screen.getPrimary().getVisualBounds()
        .getHeight() /
                              2;
    
    stage.setMinWidth(MIN_WIDTH);
    stage.setMinHeight(MIN_HEIGHT);
    
    stage.centerOnScreen();
    stage.setTitle("Library Challenge");
    
    final LibraryController root = new LibraryController("Test.csv");
    final Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}