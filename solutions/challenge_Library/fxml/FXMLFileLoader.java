package challenge_Library.fxml;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

/**
 * Simplifies the task of loading the relevant fxml files for each node.
 * 
 * @author jacobwatson
 * @version 0.1
 */
public class FXMLFileLoader {
	
	/**
	 * Returns the class name of <code>object</code> as a string.
	 * <p>
	 * Given an object, CustomFXMLLoader will load the fxml files related to it.
	 * 
	 * @param object
	 *          Object that needs it's fxml files loaded.
	 * @return The class name of <code>object</code>, as a string.
	 */
	public static String getClassNameForLoading(final Object object) {
		final String pathToFile = object.getClass().getName();
		
		final int index = pathToFile.lastIndexOf(".");
		
		final String pathName = String.format("/%s/fxml/%s.fxml",
		    pathToFile.substring(0, index), pathToFile.substring(index + 1));
		return pathName;
	}
	
	/**
	 * Initializes the FXML for subclasses.
	 * <p>
	 * This implementation requires that the .fxml file has the same name as the
	 * .java file.
	 * 
	 * @param object
	 *          Object which needs it's fxml files loaded.
	 */
	public static void initFXMLfor(final Object object) {
		final String className = getClassNameForLoading(object);
		
		final FXMLLoader fxmlLoader = new FXMLLoader(
		    object.getClass().getResource(className));
		fxmlLoader.setRoot(object);
		fxmlLoader.setController(object);
		
		try {
			fxmlLoader.load();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}