package challenge_Library;

import java.util.Comparator;
import java.util.function.Predicate;

import challenge_Library.fxml.FXMLFileLoader;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

// TODO: Auto-generated Javadoc
/**
 * The controller of the main class.
 * @author jacobwatson
 * @version 1.0
 * @since 01/08/2019
 */
public class LibraryController extends BorderPane {
  
  /** The sorted book comparator. */
  private ObjectProperty<Comparator<LibraryBook>> sortedBookComparator;
  
  /** The table view containing all the books on display. */
  @FXML private TableView<LibraryBook> mTableView;
  /** The table view containing all the books on display. */
  @FXML private TableColumn<LibraryBook, BookSeriesInformation> mColumnSeries;
  
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
  /** The filter text that allows the user to filter by ISBN. */
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
    
    final ObservableList<LibraryBook> bookList 			= loadBooksFromFile(fileName);
    final FilteredList<LibraryBook> filteredBookList 	= createFilteredListFrom(bookList);
    final SortedList<LibraryBook> sortedBookList 		= new SortedList<LibraryBook>(filteredBookList, sortedBookComparator.get());
    setSortPrioritiesFor(sortedBookList);
  }
  
  /**
   * Creates a filtered, predicated list from the given {@code bookList}.
   * @param bookList A collection of LibraryBooks that are to be filtered.
   * @return Returns a filtered list of library books.
   */
  private FilteredList<LibraryBook> createFilteredListFrom(final ObservableList<LibraryBook> bookList) {
	  final FilteredList<LibraryBook> filteredBookList = new FilteredList<LibraryBook>(bookList, p -> true);
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateTitle 			= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateTitle.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getTitle().toLowerCase().contains(filterText_Title.getText().toLowerCase()), 
						  filterText_Title.textProperty()));
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateAuthor 		= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateAuthor.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getAuthor().toLowerCase().contains(filterText_Author.getText().toLowerCase()), 
						  filterText_Author.textProperty()));
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateYear 			= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateYear.bind(Bindings.createObjectBinding(() -> 
						  book -> ("" + book.getPublishingYear()).contains(filterText_Year.getText()), 
						  filterText_Year.textProperty()));
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateISBN 			= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateISBN.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getISBN().toLowerCase().contains(filterText_ISBN.getText().toLowerCase()), 
						  filterText_ISBN.textProperty()));
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateGenre 		= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateGenre.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getGenre().equals(filter_Genre.getSelectionModel().getSelectedItem()) || filter_Genre.getSelectionModel().getSelectedItem() == null, 
						  filter_Genre.getSelectionModel().selectedItemProperty()));
	  
	  final ObjectProperty<Predicate<LibraryBook>> predicateAudience 	= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  predicateAudience.bind(Bindings.createObjectBinding(() -> 
						  book -> book.getAudience().equals(filter_Audience.getSelectionModel().getSelectedItem()) || filter_Audience.getSelectionModel().getSelectedItem() == null, 
						  filter_Audience.getSelectionModel().selectedItemProperty()));
	  
//	  final ObjectProperty<Predicate<LibraryBook>> predicateInStock 		= new SimpleObjectProperty<Predicate<LibraryBook>>();
	  
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
  private void setSortPrioritiesFor(final SortedList<LibraryBook> sortedBookList) {
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
  private ObservableList<LibraryBook> loadBooksFromFile(final String fileName) {
	  final IOModule bookIO = new IOModule();
	  final ObservableList<LibraryBook> bookList = bookIO.retrieveBooksFromFile(fileName);
	  
	  sortedBookComparator = new SimpleObjectProperty<>((book1, book2) -> book1.compareTo(book2));
	  
	  
	  return bookList;
  }
}