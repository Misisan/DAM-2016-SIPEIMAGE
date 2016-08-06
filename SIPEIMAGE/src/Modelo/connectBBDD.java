package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectBBDD {

	// Conector para el driver de la BBDD
	private static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//Variables para los datos de la BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	
	//Objeto para poder interactuar con la BBDD
	private static Connection conexion = null;
	private static connectBBDD INSTANCE = null;
	
	//Constructor
	private connectBBDD(){
		
		//Datos de la BBDD
		host = "mysql.hostinger.es";
		bbdd = "u722998185_sipe";
		user = "u722998185_sipe";
		pass = "sipeimage";
		
		//Conexión
		try{
			//Cargar el controlador MYSQL para poder conectar con la BBDD
			Class.forName(CONTROLADOR_MYSQL);
			
			//Conectar a la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd, this.user, this.pass);
			if(conexion != null){
				System.out.println("Conexión OK");
			}
			
		}catch( SQLException excepcionSQL ){ //Cath para la conexión a la BBDD
			//Imprimir en pantalla el error
			excepcionSQL.printStackTrace();
		}catch( ClassNotFoundException noEncontroClase){ //Catch para el controlador
			noEncontroClase.printStackTrace();
		}
	}
	
	//Método para el Singletone
	public static Connection getConexion(){
		if(conexion==null){
			INSTANCE = new connectBBDD();			
		}
		return conexion;
	}
	
	public String toString(){
		return "BBDD sipeimage";
	}
	
}
