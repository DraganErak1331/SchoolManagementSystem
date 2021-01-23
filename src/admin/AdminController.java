package admin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * The controller for the AdminFXML file of the login window.
 */
public class AdminController implements Initializable{
	/**
	 * The textfield where the user enters the first name of the student to add.
	 */
	@FXML
	private TextField firstName;
	/**
	 * The textfield where the user enters the last name of the student to add.
	 */
	@FXML
	private TextField lastName;
	/**
	 * The textfield where the user enters the email of the student to add.
	 */
	@FXML
	private TextField email;
	/**
	 * The field where the user selects the date of birth of the student to add
	 */
	@FXML
	private DatePicker dob;
	/**
	 * The table view that will display all of the entries in the system.
	 */
	@FXML
	private TableView<StudentData> studentTable;
	/**
	 * The first column in the table view that displays all of the IDs in each student in the system.
	 */
	@FXML
	private TableColumn<StudentData, String> idColumn;
	/**
	 * The second column in the table view that displays the first name for each student in the system.
	 */
	@FXML
	private TableColumn<StudentData, String> firstNameColumn;
	/**
	 * The third column in the table view that displays the last name for each student in the system.
	 */
	@FXML
	private TableColumn<StudentData, String> lastNameColumn;
	/**
	 * The fourth column in the table view that displays the email for each student in the system.
	 */
	@FXML
	private TableColumn<StudentData, String> emailColumn;
	/**
	 * The fifth column in the table view that displays the date of birth for each student in the system.
	 */
	@FXML
	private TableColumn<StudentData, String> dobColumn;
	/**
	 * The text field where the user enters the username they would like the added admin to have.
	 */
	@FXML
	private TextField adminUsername;
	/**
	 * The text field where the user enters the password they would like the added admin to have.
	 */
	@FXML
	private TextField adminPassword;
	
	//The list that will contain each student in the system, or more specifically, each entry in the students table.
	private ObservableList<StudentData> data;
	//object for accessing the AdminModel class
	AdminModel adminModel = new AdminModel();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	/**
	 * Occurs when the Load/Refresh Data button is pressed. This method will extract each row from the students table using the sqlLoadTable method.
	 * It will then go through each StudentData element in the ObservableList and assign each property of the element to it's respective column in the TableView.
	 * It must be pressed to refreshed the data displayed in the TableView.
	 * @param event
	 * @throws SQLException
	 */
	@FXML
	private void loadStudentData(ActionEvent event) throws SQLException{
		data = adminModel.sqlLoadTable(data);
		
		idColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("ID"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("lastName"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("email"));
		dobColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("DOB"));
		
		studentTable.setItems(null);
		studentTable.setItems(data);
	}
	
	/**
	 * Occurs when the Add Student button is clicked. It will take all of the filled in text boxes in the Add Students section 
	 * of the window and run the sqlAddStudent method to add the student data to the students table.
	 * @param event
	 */
	@FXML
	private void addStudent(ActionEvent event) {
		adminModel.sqlAddStudent(firstName, lastName, email, dob);
	}
	
	/**
	 * Occurs when the Delete Student button is clicked. It will run the sqlDeleteStudent method to delete the
	 * selected student from the students table.
	 * @param event
	 */
	@FXML
	private void deleteStudent(ActionEvent event) {
		adminModel.sqlDeleteStudent(studentTable);
	}
	
	/**
	 * Occurs when the Clear Form button in the Add Student section is clicked. It will make all of the fields in the Add Student section blank.
	 * @param event
	 */
	@FXML
	private void clearStudentFields(ActionEvent event) {
		firstName.setText("");
		lastName.setText("");
		email.setText("");
		dob.setValue(null);
	}
	
	/**
	 * Occurs when the Add Admin button is clicked. It will take all of the filled in text boxes in the Add Admin section 
	 * of the window and run the sqlAddAdmin method to add the admin data to the login table.
	 * @param event
	 */
	@FXML
	private void addAdmin(ActionEvent event) {
		adminModel.sqlAddAdmin(adminUsername, adminPassword);
	}
	
	/**
	 * Occurs when the Clear Form button in the Add Admin section is clicked. It will make all of the fields in the Add Admin section blank.
	 * @param event
	 */
	@FXML
	private void clearAdminFields(ActionEvent event) {
		adminUsername.setText("");
		adminPassword.setText("");
	}
	
}
