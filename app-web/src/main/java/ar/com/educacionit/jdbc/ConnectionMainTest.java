package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.educacionit.entidades.Producto;

public class ConnectionMainTest {
	
	public static void main (String[] args) {
		
		Connection connection;
		
		try {
			connection = AdministradorDeConexiones.obtenerConexion();
			
			System.out.println("Conectado correctamente");
			
			select(connection);
			
			connection.close();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			//connection.close();
		}
				
	}
	
	// creo un nuevo metodo static
	
	public static void select(Connection connection) throws SQLException {
		
		String sqlSelect = "SELECT * FROM productos";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		
		while(resultSet.next()) { // encontro registros?
			Long id = resultSet.getLong(1); // Id,
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			Producto producto = new Producto(id,titulo,precio,codigo,tipoProducto);
			System.out.println(producto);
			
			}
		
		statement.close();
		
	}

}
