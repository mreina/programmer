package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import modelo.Conexion;

public class Persona {
	
	//Atributos
	private String nombre,apaterno, amaterno,sexo;
	private Integer edad;
	private Conexion con;
	private ObservableList<Persona> tabla;
	//wAAWAA
	
	
	//Constructor: Permite inicializar los atributos
	//de una clase.
	public Persona(){
		this.nombre = "";
		this.apaterno=amaterno=sexo="";
		this.edad=0;
		this.con = new Conexion();
		tabla=FXCollections.observableArrayList();
	}
	public Persona(String _nombre, String _apaterno, 
			String _amaterno,String _sexo, Integer _edad){
		this.nombre=_nombre;
		this.apaterno=_apaterno;
		this.amaterno=_amaterno;
		this.sexo=_sexo;
		this.edad=_edad;		
		this.con=new Conexion();
	}
	
	//GET
	public String getNombre(){
		return this.nombre;
	}	
	public String getApaterno() {
		return apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public String getSexo() {
		return sexo;
	}
	public Integer getEdad() {
		return edad;
	}
	
	//SET
	public void setNombre(String _nombre){
		this.nombre=_nombre;
	}	
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public String toString(){
		return this.nombre + " " + 
				this.apaterno + " " + 
				this.amaterno + " " +
				this.sexo + " " + 
				this.edad;
	}	
	

	//Métodos
	public String guardar(){
		String mensaje="";
		try {
			if(con.conectar()==true){
				String query="insert into persona values(default,?,?,?,?,?)";
				PreparedStatement comando = con.getConexion().
						prepareStatement(query);
				comando.setString(1, this.nombre);
				comando.setString(2, this.apaterno);
				comando.setString(3, this.amaterno);
				comando.setString(4, this.sexo);
				comando.setInt(5, this.edad);
				comando.executeUpdate();
				mensaje="Datos insertados con éxito";
			}
			
		} catch (Exception e) {
			mensaje="No se insertaron los datos.";
		}
		finally{
			con.desconectar();
		}
		return mensaje;
		
	}
	
	public ObservableList<Persona> getDatos() throws SQLException{
		ResultSet rs = null;
		Persona p=null;
		try{
			if(con.conectar()==true){
				String query="select * from persona";
				PreparedStatement comando = con.getConexion().prepareStatement(query);
				rs=comando.executeQuery();
				while(rs.next()){
					p=new Persona();
					p.setNombre(rs.getString("nombre"));
					p.setAmaterno(rs.getString("materno"));
					p.setApaterno(rs.getString("paterno"));
					p.setSexo(rs.getString("sexo"));
					p.setEdad(rs.getInt("edad"));					
					tabla.add(p);					
				}
				
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			rs.close();
			con.desconectar();
		}
		return tabla;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
