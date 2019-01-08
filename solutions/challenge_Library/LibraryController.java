package challenge_Library;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LibraryController extends BorderPane {
	@FXML private TableView mTableView;
	@FXML private TextField filterText_Title;
	@FXML private TextField filterText_Author;
	@FXML private TextField filterText_Year;
	@FXML private ComboBox filter_Genre;
	@FXML private ComboBox filter_Audience;
	@FXML private TextField filterText_InStock;
	
	public LibraryController() {
		super();
		
		FXMLFileLoader.initFXMLfor(this);
	}
}