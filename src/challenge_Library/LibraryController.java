package challenge_Library;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LibraryController extends BorderPane {
	@FXML private TableView mTableView;
	@FXML private TextField filterText_Title;
	@FXML private TextField filterText_Author;
	@FXML private TextField filterText_Genre;
	@FXML private TextField filterText_Year;
	@FXML private TextField filterText_Subject;
	@FXML private TextField filterText_Edition;
	@FXML private TextField filterText_Audience;
	@FXML private TextField filterText_InStock;
	@FXML private TextField filterText_TotalCopies;
	
	public LibraryController() {
		super();
		
		FXMLFileLoader.initFXMLfor(this);
	}
}