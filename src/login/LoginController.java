package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * The controller for the Login FXML file of the login window.
 */
public class LoginController implements Initializable{
	/**
	 * Displays a message indicating whether or not the application is connected to the database.
	 */
	@FXML
	private Label databaseStatus;
	/**
	 * The username prompt field.
	 */
	@FXML
	private TextField usernameBox;
	/**
	 * The password field prompt.
	 */
	@FXML
	private PasswordField passwordBox;
	/**
	 * The button for attempting to login to the system using the correct credentials.
	 */
	@FXML
	private Button loginButton;
	/**
	 * This label appears beside the login button and informs the user that they have entered incorrect credentials.
	 */
	@FXML
	private Label loginStatus;
	
	//object for accessing the LoginModel class
	LoginModel loginModel = new LoginModel();
	
	/**
	 * Initializes the window to state whether there is an active database connection as defined in the DatabaseConnection class.
	 * If there is a connection, "Connected to Database" will appear in the databaseStatus label.
	 * If a connection cannot be made, "Not Connected to Database" will appear in the databaseStatus label.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(loginModel.isConnected()) {
			databaseStatus.setText("Connected To Database");
		}
		else {
			databaseStatus.setText("Not Connected To Database");
		}
	}
	
	/**
	 * Executed when the Login button is pressed.
	 * The method will check if the username and password that have been entered are valid by
	 * checking if they correspond to entries in the login table.
	 * If they do, the current windows will close and the adminLogin method will be run.
	 * Otherwise, a loginStatus label will output the text "Wrong credentials!".
	 * @param event
	 */
	@FXML
	public void login(ActionEvent event) {
		try {
			if(loginModel.credentialCheck(usernameBox.getText(), passwordBox.getText())) {
				Stage stage = (Stage)loginButton.getScene().getWindow();
				stage.close();
				adminLogin();
			}
			else {
				loginStatus.setText("Wrong" + "\n" + "credentials!");
			}
		} catch(Exception e) {
			
		}
	}
	
	/**
	 * Creates a new window that will load the admin dashboard, which is the main page of the system, using the AdminFXML file.
	 */
	public void adminLogin() {
		try {
			Stage adminstage = new Stage();
			Pane adminroot = FXMLLoader.load(getClass().getResource("/admin/Admin.fxml"));
			Scene scene = new Scene(adminroot);
			adminstage.setScene(scene);
			adminstage.setTitle("Admin Dashboard");
			adminstage.setResizable(false);
			adminstage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
