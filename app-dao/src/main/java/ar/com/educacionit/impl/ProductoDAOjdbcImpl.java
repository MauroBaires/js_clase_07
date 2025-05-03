package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdbc.AdministradorDeConexiones;

public class ProductoDAOjdbcImpl implements ProductoDAO {

	@Override
	public Producto create(Producto producto) throws GenericException, DuplicatedException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		/*String sql = "INSERT INTO productos (titulo, precio, codigo, id_tipo_producto)" 
				+ "VALUES ('"+producto.getTitulo()
				+"', '"+producto.getPrecio()+"', '"
				+producto.getCodigo()+"', '"
				+producto.getTipoProducto()+"')"; */
		
		String sql = "INSERT INTO productos (titulo, precio, codigo, id_tipo_producto)"
					+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) { //si se creo el producto
				Long pk = resultSet.getLong(1);
				producto.setId(pk);
			} else {
				throw new GenericException("No se ha podido obtener el Id generado");
			}
			
			statement.close();
						
			
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("Clave duplicada, no se ha podido registrar el producto");
			}
			
			throw new GenericException("No se ha podido crear el producto", e); 
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new GenericException("Problema, cerrando la conexion. Verifique en la base de datos", e);
			}
		}
		
		return producto;
	
	}

	// --------------- Collection ---------------------- //
	
	@Override
	public Collection<Producto> findAll() throws GenericException {
		
Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sql = "SELECT * FROM productos";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();
			
			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se han podido obtener los productos", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexión, verifique en la base de datos", e);
			}
		}
		
		
	}

	
	
	// ---------------getById-----------------  //
	
	@Override
	public Producto getById(Long id) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sql = "SELECT * FROM productos WHERE id = " + id;
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery(sql);  
					
			Producto producto = null; 
			if(resultSet.next()) {
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
 					
		} catch (SQLException e) {
			
			throw new GenericException("No se ha podido obtener el producto", e);
		
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new GenericException("Problema, cerrando la conexion. Verifique en la base de datos." , e);
			}
		}
				
		return null;
	}

	
	
		// ------------------------------UPDATE ---------------------- //
	
	
	@Override
	public Producto update(Producto producto) throws GenericException {
		
		Producto productoBuscado = this.getById(producto.getId());
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(productoBuscado == null) {
			throw new GenericException("No existe producto id:" + producto.getId(), null);
		}
		
		String sql = "UPDATE productos "
				+ " set titulo = ? ,"
				+ " precio = ? ,"
				+ " id_tipo_producto = ?"
				+ " WHERE id = ?";
try {
			PreparedStatement statement =  connection.prepareStatement(sql);
			
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setLong(3, producto.getTipoProducto());
			statement.setLong(4, producto.getId());
			
			int updated = statement.executeUpdate();
							
			statement.close();
			
			if(updated !=1) { //encontró registros?
				throw new Exception("No se ha podido modificar los datos del producto id:"+ producto.getId());
			}
			
			producto = this.getById(producto.getId());
			
			return producto;
		}catch (Exception e) {
			throw new GenericException("No se ha podido actualizar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	
	
	// -----------------------DELETE BY ID ----------------------------- //
	
	
	@Override
	public Producto deleteById(long id) throws GenericException {
		Producto producto = this.getById(id);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if (producto == null){
			throw new GenericException("No existe el producto con el id: "+ id);
		}
		
		String sql = "DELETE FROM productos WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			int deleted = statement.executeUpdate();
			statement.close();
			
			if (deleted != 1) {
				throw new GenericException("No se ha podido eliminar el producto id: " + id);
			}
			
			statement.close();
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new GenericException("Problema, cerrando la conexion. Verifique en la BD" , e);
			}
			
			
		}
		return producto;
		
	}

	
	// ---------------------GET ByCodigo-------------------------------- //
	

	
	@Override
	public Producto getByCodigo(String codigo) throws GenericException {
Producto producto = this.getByCodigo(codigo);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(producto == null) {
			throw new GenericException("No existe producto id:" + codigo, null);
		}		
		
		String sql = "DELETE FROM PRODUCTOS WHERE codigo = ? ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, codigo);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted !=1) {
				throw new GenericException("No se ha podido eliminar el producto id:" + codigo);
			}
		}catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
		
		return producto;

	}

	
	
	
	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sql = "SELECT * from productos WHERE UPPER(titulo) LIKE '%"+titulo+"%'";
		
		try {
			PreparedStatement statement =  connection.prepareStatement(sql);
			
			//setear los parametros
			//statement.setNString(0, titulo);
			
			ResultSet resultSet = statement.executeQuery();
					
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();
			
			return productos;
			
		}catch (SQLException e) {
			throw new GenericException("No se ha podido hacer la busqueda", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema, cerrando la conexion, verique en la base de datos",e1);
			}
						
		}
		
	}
	
//metodos privados 
	
private Producto productoFromResultSet(ResultSet rs) throws SQLException {
		
		Producto producto;
		
		Long id = rs.getLong(1);
		String titulo = rs.getString(2);
		Float precio = rs.getFloat(3);
		String codigo = rs.getString(4);
		Long tipoProducto = rs.getLong(5);
		
		producto = new Producto(id, titulo, precio, codigo, tipoProducto);
		
		return producto;
	}

@Override
public Producto deleteByCodigo(String codigo) throws GenericException {
	// TODO Auto-generated method stub
	return null;
}

}
