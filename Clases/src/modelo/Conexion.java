package modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
	/*
	 * Clase que permite conectarse a PostgreSQL
	 */
	private String usuario;
	private String contrasenia;
	private String baseDatos;
	private String driver;
	private Connection con;
	
	public Conexion(){
		usuario="postgres";
		contrasenia="utcvtic";
		baseDatos="jdbc:postgresql://127.0.0.1:5432/prueba";
		driver="org.postgresql.Driver";
	}
	/*
	 * El m�todo Conectar permite establecer la conexion a la base de datos
	 * Contiene el bloque TRY-CATCH para controlar errores de ejecuci�n.
	 */
	public boolean conectar(){
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(baseDatos,usuario, 
					contrasenia);
			System.out.println("Conectado");
			return true;			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}
	
	/*
	 * El m�todo desconectar permite cerrar la conexi�n 
	 */
	
	public boolean desconectar(){
		try {	
			con.close();
			System.out.println("Desconectado");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * El m�todo getConexion permite recuperar la conexion para poder
	 * realizar los procesos de insertar, eliminar y actualizar.
	 */
	
	public Connection getConexion(){
		return con;
	}
	
	
	
	
}
