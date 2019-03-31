package challenge_Library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafxRule.JavaFXThreadingRule;

/**
 * Test class that is intended to test the {@link LibraryController} class}.
 * 
 * @author jacobwatson
 * @version 1.0
 * @since 01/19/2019
 */
public class LibraryControllerTest {
	/** Required to run tests on JavaFX thread. */
	@Rule
	public JavaFXThreadingRule mThreadingRule = new JavaFXThreadingRule();

	/** The library controller that is to be tested. */
	private LibraryController mLibraryController;

	/**
	 * Tests that the library controller can clear filters.
	 * 
	 * @throws EmptyFileNameException    if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_CanClearFilters()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "title";
		final String nameOfMethod = "clear";

		TableView<SolutionLibraryBook> tableView = null;
		Method clearFiltersMethod = null;

		for (final Method method : LibraryController.class.getDeclaredMethods()) {

			if (method.getName().toLowerCase().contains(nameOfMethod)) {
				clearFiltersMethod = method;
				clearFiltersMethod.setAccessible(true);
			}
		}

		for (final Field field : LibraryController.class.getDeclaredFields()) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				textField.setText("Skyward");

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				clearFiltersMethod.invoke(mLibraryController);

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that a library controller can handle a file name that is empty.
	 * 
	 * @throws EmptyFileNameException
	 */
	@Test(expected = EmptyFileNameException.class)
	public void test_LibraryController_CanHandleEmptyFileName() throws EmptyFileNameException {
		new LibraryController("");
	}

	/**
	 * Tests that a library controller can handle a file name that is null.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test
	public void test_LibraryController_CanHandleLoadingNullFileName()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfMethod = "load";

		for (final Method method : LibraryController.class.getDeclaredMethods()) {

			if (method.getName().toLowerCase().contains(nameOfMethod)) {
				final Method loadBooksFromFileMethod = method;
				loadBooksFromFileMethod.setAccessible(true);
				loadBooksFromFileMethod.invoke(mLibraryController, "");

				assertNotNull("Tests that a library controller can handle a file name that is null.",
						mLibraryController.getErrorAlert());
			}
		}
	}

	/**
	 * Tests that a library controller can handle a file name that is empty.
	 * 
	 * @throws EmptyFileNameException
	 */
	@Test(expected = EmptyFileNameException.class)
	public void test_LibraryController_CanHandleNullFileName() throws EmptyFileNameException {
		new LibraryController(null);
	}

	/**
	 * Tests that a library controller can load from a file.
	 * 
	 * @throws EmptyFileNameException
	 */
	@Test
	public void test_LibraryController_CanLoadFromFile() throws EmptyFileNameException {
		mLibraryController = new LibraryController("Test.csv");

		assertNotNull(mLibraryController);
	}

	/**
	 * Tests that a library controller can remove its sort order.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_CanRemoveSortOrder()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : LibraryController.class.getDeclaredFields()) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);

				tableView.getSortOrder().add(tableView.getColumns().get(0));
				tableView.getSortOrder().add(tableView.getColumns().get(1));

				tableView.sort();
			}
		}
	}

	/**
	 * Tests that a library controller can sort the table view.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_CanSort()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : LibraryController.class.getDeclaredFields()) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);

				tableView.sort();
			}
		}
	}

	/**
	 * Tests that the audience combo box of a library controller filters as
	 * expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_ComboBox_Audience_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "audience";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(ComboBox.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final ComboBox<Audience> comboBox = (ComboBox<Audience>) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				comboBox.getSelectionModel().select(Audience.Children);

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				comboBox.getSelectionModel().select(null);

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the genre combo box of a library controller filters as expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_ComboBox_Genre_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "genre";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(ComboBox.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final ComboBox<Genre> comboBox = (ComboBox<Genre>) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				comboBox.getSelectionModel().select(Genre.Thriller);

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				comboBox.getSelectionModel().select(null);

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the audience combo box of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterComboBox_Audience_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "audience";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(ComboBox.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final ComboBox<Audience> comboBox = (ComboBox<Audience>) field.get(mLibraryController);

				assertNotNull("Tests that the audience combo box of a library controller is not null.", comboBox);
			}
		}
	}

	/**
	 * Tests that the genre combo box of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterComboBox_Genre_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "genre";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(ComboBox.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final ComboBox<Genre> comboBox = (ComboBox<Genre>) field.get(mLibraryController);

				assertNotNull("Tests that the genre combo box of a library controller is not null.", comboBox);
			}
		}
	}

	/**
	 * Tests that the author filter text field of a library controller filters as
	 * expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterTextBox_Author_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "author";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				textField.setText("Robert Jordan");

				expected = 2;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 2 items.", expected, actual);

				textField.clear();

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the author filter text field of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void test_LibraryController_FilterTextBox_Author_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "author";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				assertNotNull("Tests that the author filter text field of a library controller is not null.",
						textField);
			}
		}
	}

	/**
	 * Tests that the ISBN-13 filter text field of a library controller filters as
	 * expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterTextBox_ISBN_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "isbn";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				textField.setText("978-0812517729");

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				textField.clear();

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the ISBN-13 filter text field of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void test_LibraryController_FilterTextBox_ISBN_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "isbn";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				assertNotNull("Tests that the ISBN-13 filter text field of a library controller is not null.",
						textField);
			}
		}
	}

	/**
	 * Tests that the year published filter text field of a library controller
	 * filters as expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterTextBox_PublishingYear_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "year";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				textField.setText("1991");

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				textField.clear();

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the title filter text field of a library controller filters as
	 * expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_FilterTextBox_Title_FiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "title";
		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				textField.setText("Skyward");

				expected = 1;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 1 item.", expected, actual);

				textField.clear();

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that clearing the filters will restore the table to having all 8 items.", expected,
						actual);
			}
		}
	}

	/**
	 * Tests that the title filter text field of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void test_LibraryController_FilterTextBox_Title_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "title";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				assertNotNull("Tests that the title filter text field of a library controller is not null.", textField);
			}
		}
	}

	/**
	 * Tests that the year published filter text field of a library controller is
	 * not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void test_LibraryController_FilterTextBox_Year_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final String nameOfField = "year";
		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TextField.class) && field.getName().toLowerCase().contains(nameOfField)) {

				final TextField textField = (TextField) field.get(mLibraryController);

				assertNotNull("Tests that the year published filter text field of a library controller is not null",
						textField);
			}
		}
	}

	/**
	 * Tests that the checkbox of a library controller is not null.
	 * 
	 * @throws EmptyFileNameException   if the given {@code fileName} is empty.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void test_LibraryController_InStockCheckBox_IsNotNull()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final Field[] fields = LibraryController.class.getDeclaredFields();

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(CheckBox.class)) {
				final CheckBox toggleButton = (CheckBox) field.get(mLibraryController);

				assertNotNull("Tests that checkbox of a library controller is not null.", toggleButton);
			}
		}
	}

	/**
	 * Tests that the checkbox of a library controller filters as expected.
	 * 
	 * @throws EmptyFileNameException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_LibraryController_InStockCheckBoxFiltersCorrectly()
			throws EmptyFileNameException, IllegalArgumentException, IllegalAccessException {
		mLibraryController = new LibraryController("SimpleTest.csv");

		final Field[] fields = LibraryController.class.getDeclaredFields();
		TableView<SolutionLibraryBook> tableView = null;

		for (final Field field : fields) {
			field.setAccessible(true);

			if (field.getType().equals(TableView.class)) {
				tableView = (TableView<SolutionLibraryBook>) field.get(mLibraryController);
			}

			if (field.getType().equals(CheckBox.class)) {
				final CheckBox toggleButton = (CheckBox) field.get(mLibraryController);

				int expected = 8;
				int actual = tableView.getItems().size();
				assertEquals("Tests that an unfiltered table has 6 items.", expected, actual);

				toggleButton.setSelected(true);

				expected = 5;
				actual = tableView.getItems().size();
				assertEquals("Tests that a filtered table has only 3 items.", expected, actual);

				toggleButton.setSelected(false);

				expected = 8;
				actual = tableView.getItems().size();
				assertEquals("Tests that unselecting the filter checkbox will restore the table to having all 8 items.",
						expected, actual);
			}
		}
	}

}