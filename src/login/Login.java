package login;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The initial login window when the program is launched, which uses the Login.fxml file.
 */
public class Login extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,300,226);
			primaryStage.setScene(scene);
			primaryStage.setTitle("School Management System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
