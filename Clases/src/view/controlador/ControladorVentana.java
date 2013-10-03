package view.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entidades.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControladorVentana implements Initializable {
	
	@FXML private TextField txtNombre, txtPaterno, 
		txtMaterno, txtEdad;	
	@FXML private ComboBox<String> cbSexo;
	@FXML private Label lblMensaje;
	@FXML private TableView<Persona> tvPersona;
	private Persona p;
	 //Evento para guardar
	@FXML protected void guardar(){
		try {
			if(txtNombre.getText().trim().isEmpty()|
					txtPaterno.getText().trim().isEmpty()|
					txtMaterno.getText().trim().isEmpty()|
					txtEdad.getText().trim().isEmpty()){
				lblMensaje.setText("Faltan datos por ingresar");
			}
			else{
				Persona p = new Persona(txtNombre.getText(),
						txtPaterno.getText(),
						txtMaterno.getText(),
						cbSexo.getValue(),
						Integer.valueOf(txtEdad.getText()));
				lblMensaje.setText(p.guardar());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(p==null)
			p=new Persona();
		try {
			tvPersona.setItems(p.getDatos());
			tvPersona.getSelectionModel().setCellSelectionEnabled(true);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML protected void mostrar(ActionEvent e){
		try{
			p = (Persona)tvPersona.getSelectionModel().getSelectedItem();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

}
