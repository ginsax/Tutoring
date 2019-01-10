package challenge_Library;

import java.util.Comparator;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
  @FXML private TableView<LibraryBook> mTableView;
  /** The table view containing all the books on display. */
  @FXML private TableColumn<LibraryBook, BookSeriesInformation> mColumnSeries;
  
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
  
  /** The toggle button filter that allows the user to filter by availability. */
  @FXML private ToggleGroup mInStockToggleGroup;
  
  /**
   * Constructs a LibraryController, loading books from the default file.
 * @throws EmptyFileNameException 
   */
  public LibraryController(final String fileName) throws EmptyFileNameException {
    super();
    FXMLFileLoader.initFXMLfor(this);
    
    if(fileName.isEmpty()) throw new EmptyFileNameException();
    
    loadBooksFromFile(fileName);
  }
  
  /**
   * Loads all the books located within the given file. 
 * @throws EmptyFileNameException 
   */
  private void loadBooksFromFile(final String fileName) {
	  
	  final IOModule bookIO = new IOModule();
	  final ObservableList<LibraryBook> bookList = bookIO.retrieveBooksFromFile(fileName);
	  
	  ObjectProperty<Comparator<LibraryBook>> comparator = new SimpleObjectProperty<>((book1, book2) -> book1.compareTo(book2));
	  
	  final SortedList<LibraryBook> sortedBookList = new SortedList<LibraryBook>(bookList, comparator.get());
	  
	  mTableView.setItems(sortedBookList);
	  sortedBookList.comparatorProperty().bind(mTableView.comparatorProperty());
	  
	  mTableView.setOnSort(e -> {
		  sortedBookList.comparatorProperty().unbind();
		  
		  if (mTableView.getSortOrder().size() == 0) {
			  sortedBookList.comparatorProperty().bind(comparator);
			  
			  mTableView.setSortPolicy(param -> true);
		  } else {
			  sortedBookList.comparatorProperty().bind(mTableView.comparatorProperty());
		  }
	  });
  }
}