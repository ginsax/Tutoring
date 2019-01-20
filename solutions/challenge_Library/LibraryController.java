package challenge_Library;

import java.util.Comparator;
import java.util.function.Predicate;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
  /** 
   * Alert that will be displayed if there is an issue with retrieving books 
   * from a file.
   */
  private Alert mErrorAlert;
  
  /** The sorted book comparator. */
  private ObjectProperty<Comparator<SolutionLibraryBook>> sortedBookComparator;
  
  /** The table view containing all the books on display. */
  @FXML private TableView<SolutionLibraryBook> mTableView;
  /** The table view containing all the books on display. */
  @FXML private TableColumn<SolutionLibraryBook, BookSeries> mColumnSeries;
  
  /** The combo box that allows the user to filter by genre. */
  @FXML private ComboBox<Genre> filter_Genre;
  /** The combo box that allows the user to filter by audience. */
  @FXML private ComboBox<Audience> filter_Audience;
  
  /** The filter text that allows the user to filter by title. */
  @FXML private TextField filterText_Title;
  /** The filter text that allows the user to filter by author. */
  @FXML private TextField filterText_Author;
  /** The filter text that allows the user to filter by year. */
  @FXML private TextField filterText_Year;
  /** The filter text that allows the user to filter by year. */
  @FXML private TextField filterText_ISBN;
  
  /** The toggle button filter that allows the user to filter by availability. */
  @FXML private ToggleGroup mInStockToggleGroup;
  
  /**
   * Constructs a LibraryController, loading books from the given file.
   * @param fileName String file name that holds the book information.
   * @throws EmptyFileNameException The given {@code fileName} is empty.
   */
  public LibraryController(final String fileName) throws EmptyFileNameException {
    super();
    FXMLFileLoader.initFXMLfor(this);
    
    if(fileName.isEmpty()) throw new EmptyFileNameException();
    
    final ObservableList<SolutionLibraryBook> bookList        = loadBooksFromFile(fileName);
    final FilteredList<SolutionLibraryBook> filteredBookList  = createFilteredListFrom(bookList);
    final SortedList<SolutionLibraryBook> sortedBookList      = new SortedList<SolutionLibraryBook>(filteredBookList, 
    																																				        sortedBookComparator.get());
    setSortPrioritiesFor(sortedBookList);
  }
  
  /**
   * Creates a filtered, predicated list from the given {@code bookList}.
   * @param bookList A collection of LibraryBooks that are to be filtered.
   * @return Returns a filtered list of library books.
   */
  private FilteredList<SolutionLibraryBook> createFilteredListFrom(final ObservableList<SolutionLibraryBook> bookList) {
	  final FilteredList<SolutionLibraryBook> filteredBookList = new FilteredList<SolutionLibraryBook>(bookList, p -> true);
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateTitle 			= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateTitle.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getTitle().toLowerCase().contains(filterText_Title.getText().toLowerCase()), 
						  filterText_Title.textProperty()));
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateAuthor 		= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateAuthor.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getAuthor().toLowerCase().contains(filterText_Author.getText().toLowerCase()), 
						  filterText_Author.textProperty()));
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateYear 			= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateYear.bind(Bindings.createObjectBinding(() -> 
						  book -> ("" + book.getPublishingYear()).contains(filterText_Year.getText()), 
						  filterText_Year.textProperty()));
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateISBN 			= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateISBN.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getISBN().toLowerCase().contains(filterText_ISBN.getText().toLowerCase()), 
						  filterText_ISBN.textProperty()));
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateGenre 		= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateGenre.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getGenre().equals(filter_Genre.getSelectionModel().getSelectedItem()) || filter_Genre.getSelectionModel().getSelectedItem() == null, 
						  filter_Genre.getSelectionModel().selectedItemProperty()));
	  
	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateAudience 	= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  predicateAudience.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getAudience().equals(filter_Audience.getSelectionModel().getSelectedItem()) || filter_Audience.getSelectionModel().getSelectedItem() == null, 
						  filter_Audience.getSelectionModel().selectedItemProperty()));
	  
//	  final ObjectProperty<Predicate<SolutionLibraryBook>> predicateInStock 		= new SimpleObjectProperty<Predicate<SolutionLibraryBook>>();
	  
//	  Bind the above predicates to filter the list. 
	  filteredBookList.predicateProperty().bind(Bindings.createObjectBinding(() -> 
	  					predicateTitle			.get() .and(
	  					predicateAuthor		.get()).and(
	  					predicateYear			.get()).and(
	  					predicateISBN			.get()).and(
	  					predicateGenre		.get()).and(
	  					predicateAudience	.get()), 
			  predicateTitle, 
			  predicateAuthor, 
			  predicateYear, 
			  predicateISBN, 
			  predicateGenre, 
			  predicateAudience));
	  
	  return filteredBookList;
  }

  /**
   * Sets the sort priorities for the table when it is otherwise unsorted.
   * @param sortedBookList A sorted list of LibraryBooks to add to the table.
   */
  private void setSortPrioritiesFor(final SortedList<SolutionLibraryBook> sortedBookList) {
    mTableView.setItems(sortedBookList);
    sortedBookList.comparatorProperty().bind(mTableView.comparatorProperty());
    
    mTableView.setOnSort(e -> {
      sortedBookList.comparatorProperty().unbind();
      
      if (mTableView.getSortOrder().size() == 0) {
        sortedBookList.comparatorProperty().bind(sortedBookComparator);
        
        mTableView.setSortPolicy(param -> true);
      } else {
        sortedBookList.comparatorProperty().bind(mTableView.comparatorProperty());
      }
    });
  }
  
  
  /**
   * Loads all the books located within the given file.
   * @param fileName String file name that holds the book information.
   * @return Returns a sorted list of LibraryBooks that have been retrieved from a file.
   */
  private ObservableList<SolutionLibraryBook> loadBooksFromFile(final String fileName) {
	  final IOModule bookIO = new IOModule();
	  ObservableList<SolutionLibraryBook> bookList = FXCollections.observableArrayList();
	  
    try {
      bookList = bookIO.retrieveBooksFromFile(fileName);
    }
    catch (EmptyFileNameException e) {
      mErrorAlert = new Alert(AlertType.ERROR, 
                              e.getMessage(), 
                              ButtonType.OK);
      mErrorAlert.show();
    }
	  
	  sortedBookComparator = new SimpleObjectProperty<>((book1, book2) -> book1.compareTo(book2));
	  
	  
	  return bookList;
  }
  
  /**
   * Returns the alert dialog that is designed to be displayed in the event of 
   * any IOExceptions thrown.
   * @return Returns the error alert dialog.
   */
  public Alert getErrorAlert() {
    return mErrorAlert;
  }
}