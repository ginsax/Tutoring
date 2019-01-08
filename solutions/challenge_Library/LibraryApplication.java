package challenge_Library;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LibraryApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		final double MIN_WIDTH 	= Screen.getPrimary().getVisualBounds().getWidth() 	/ 2;
		final double MIN_HEIGHT= Screen.getPrimary().getVisualBounds().getHeight() / 2;
		
		stage.setMinWidth	(MIN_WIDTH);
		stage.setMinHeight	(MIN_HEIGHT);
		
		stage.centerOnScreen();
		stage.setTitle("Library Challenge");
		
		final LibraryController root = new LibraryController();
		final Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}