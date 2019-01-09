package challenge_Library;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * The controller of the main class.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public class LibraryController extends BorderPane {
  
  /** The table view containing all the books on display. */
  @FXML private TableView<LibraryObject> mTableView;
  
  /** The combo box that allows the user to filter by audience. */
  @FXML private ComboBox<Audience> filter_Audience;
  /** The combo box that allows the user to filter by genre. */
  @FXML private ComboBox<Genre> filter_Genre;
  
  /** The filter text that allows the user to filter by author. */
  @FXML private TextField filterText_Author;
  /** The filter text that allows the user to filter by title. */
  @FXML private TextField filterText_Title;
  /** The filter text that allows the user to filter by year. */
  @FXML private TextField filterText_Year;
  
  /** The toggle buttpn filter that allows the user to filter by availability. */
  @FXML private ToggleGroup mInStockToggleGroup;
  
  /**
   * Constructs a LibraryController. Defaults the Genre and Audience combo 
   * boxes.
   */
  public LibraryController() {
    super();
    
    FXMLFileLoader.initFXMLfor(this);
    
    populateGenreComboBox();
    populateAudienceComboBox();
  }
  
  /**
   * Populates the 'Genre' combo box.
   */
  private void populateGenreComboBox() {
    filter_Genre.getItems().addAll(
        Genre.Drama, 
        Genre.Encyclopedia, 
        Genre.Fantasy, 
        Genre.History, 
        Genre.Mystery, 
        Genre.Romance, 
        Genre.Science, 
        Genre.ScienceFiction, 
        Genre.TextBook, 
        Genre.Thriller);
  }
  /**
   * Populates the 'Audience' combo box.
   */
  private void populateAudienceComboBox() {
    filter_Audience.getItems().addAll(
        Audience.Adult, 
        Audience.Children, 
        Audience.YoungAdult);
  }
}