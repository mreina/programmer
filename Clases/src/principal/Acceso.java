package principal;

import java.io.IOException;

import view.load.Persona;

import com.sun.prism.paint.Paint;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Acceso extends Application {
	
	private Persona p;
	private Stage priStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Menu.fxml"));
		
		Scene escena =  new Scene(root);
		
		this.priStage= new Stage();
		this.priStage=primaryStage;
		this.priStage.setTitle("MENU");
		this.priStage.setScene(escena);
		this.priStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML protected void clicVentana1(ActionEvent e){
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Persona.fxml"));
			Scene escena = new Scene(root);			
			stage.setScene(escena);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)e.getSource()).getScene().getWindow());
			stage.show();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
