package view.load;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Persona extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/Persona.fxml"));
		Scene escena = new Scene(root);
		primaryStage.setScene(null);
		primaryStage.setScene(escena);
		primaryStage.show();
	}
	
	

}
