package connexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.Cliente;
import models.Video;

public class Connector {
	
	private String connection = "jdbc:mysql://localhost:33060";
	private String user = "root";
	private String pass = "password";
	private Connection conexion;
	
	private void connect() {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conexion = DriverManager.getConnection(connection,user,pass);
        	System.out.println("ServerConnected");
        	
        }catch(SQLException | ClassNotFoundException ex) {
        	System.out.println("no se ha podido establecer la conexion con la base de datos");
        	System.out.println(ex);
        }
	}
	
	private void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion con el servidor");
		}catch(SQLException ex) {
			System.out.println(ex);

		}
	}
	
	public Cliente leer(String id){
		Cliente cliente = new Cliente();
		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
			String consultaMostrarArticulos = "SELECT * FROM Clientes WHERE id="+id;
			
	        java.sql.ResultSet resultado = statement.executeQuery(consultaMostrarArticulos);
	        
	        while (resultado.next()) {
	        	int id2 = resultado.getInt("id");
	            String nombre = resultado.getString("nombre");
	            String apellido = resultado.getString("apellido");
	            String direccion = resultado.getString("direccion");
	            int dni = resultado.getInt("dni");
	            String fecha = resultado.getString("fecha");
	            cliente.setId(id2);
	            cliente.setNombre(nombre);
		        cliente.setApellido(apellido);
		        cliente.setDireccion(direccion);
		        cliente.setDni(dni);
		        cliente.setFecha(fecha);
		        
	        }
	        
	        closeConnection();
	        return cliente;
            
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		closeConnection();
		return null;
	}
	
	public Video leerVideo(String id){
		Video video = new Video();
		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
			String consultaMostrarArticulos = "SELECT * FROM Videos WHERE id="+id;
			
	        java.sql.ResultSet resultado = statement.executeQuery(consultaMostrarArticulos);
	        
	        while (resultado.next()) {
	        	int id2 = resultado.getInt("id");
	            String title = resultado.getString("title");
	            String director = resultado.getString("director");
	            int cli_id = resultado.getInt("cli_id");
	            video.setId(id2);
	            video.setDirector(director);
	            video.setTitle(title);
	            video.setCliId(cli_id);
	        }
	        closeConnection();
	        return video;
            
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		closeConnection();
		return null;
	}
	
	public boolean escribir(String nombreTextField, String apellidoTextField, String direccionTextField, String dniTextField, String fechaTextField) {
		
		try {
			Cliente cliente = new Cliente();
            cliente.setNombre(nombreTextField);
	        cliente.setApellido(apellidoTextField);
	        cliente.setDireccion(direccionTextField);
	        cliente.setDni(Integer.parseInt(dniTextField));
	        cliente.setFecha(fechaTextField);

			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
			// Define la sentencia SQL para la inserción
            String sql = "INSERT INTO Clientes (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la sentencia SQL
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);


            // Establece los valores de los parámetros en el PreparedStatement
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setInt(4, cliente.getDni());
            preparedStatement.setString(5, cliente.getFecha());

            int rowsAffected = preparedStatement.executeUpdate();
            
	        closeConnection();
	         
            if (rowsAffected > 0) {
            	return true;
            } else {
                return false;
            }
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean escribirVideo(String tituloTextField, String directorTextField, String clienteTextField) {
		
		try {
			Video video = new Video();
			video.setTitle(tituloTextField);
			video.setDirector(directorTextField);
			video.setCliId(Integer.parseInt(clienteTextField));

			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
			// Define la sentencia SQL para la inserción
            String sql = "INSERT INTO Videos (title, director, cli_id) VALUES (?, ?, ?)";

            // Crea un PreparedStatement para ejecutar la sentencia SQL
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);


            // Establece los valores de los parámetros en el PreparedStatement
            preparedStatement.setString(1, video.getTitle());
            preparedStatement.setString(2, video.getDirector());
            preparedStatement.setInt(3, video.getCliId());

            int rowsAffected = preparedStatement.executeUpdate();
            
	        closeConnection();
	         
            if (rowsAffected > 0) {
            	return true;
            } else {
                return false;
            }
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean quitar(String id){

		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
            String sql = "DELETE FROM Clientes WHERE id = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id));

            int rowsAffected = preparedStatement.executeUpdate();
            
            closeConnection();
            
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
	        
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean quitarVideo(String id){

		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB2");
			
            String sql = "DELETE FROM Videos WHERE id = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id));

            int rowsAffected = preparedStatement.executeUpdate();
            
            closeConnection();
            
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
	        
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
}