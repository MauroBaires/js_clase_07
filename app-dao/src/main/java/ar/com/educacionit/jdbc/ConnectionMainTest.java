package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ar.com.educacionit.domain.Producto;

public class ConnectionMainTest {
	
	public static void main (String[] args) {
		
		Connection connection;
		
		try {
			connection = AdministradorDeConexiones.obtenerConexion();
			
			System.out.println("Conectado correctamente");
			
			
			System.out.println("-----productoConId-----");
			// El producto deberia llegar desde un formulario. NO LLEGA CON EL ID
			//Producto p = new Producto("Test", 110.10f, "TEST8", 1l); // por eso uso constructor sin ID
			//System.out.println(p); // id = null
			
			//Producto productoConId = createProducto(connection, p);
			//System.out.println(productoConId);
			//System.out.println("-----------------------------------------------------------");
			//System.out.println("");
			
			System.out.println("-----selectByAll-----");
			Collection<Producto> productos = selectAll(connection);

			//recorrer
			
			for(Producto producto : productos ) {
				System.out.println(producto);
			}

			System.out.println("");
			System.out.println("-----selectById-----");
			long id = 2L;			
			Producto pConId2 = selectById(connection,2l);
			System.out.println("Producto con id" + id + ":\n" + pConId2);
			
			System.out.println("");
			System.out.println("-----selectByCodigo-----");
			String codigoBuscado = "000006";
			Producto pByCodigo = selectByCodigo(connection, codigoBuscado);
			String codigoBuscado2 = "000008";
			Producto pByCodigo2 = selectByCodigo(connection, codigoBuscado);
			
			
			System.out.println("");
			/*System.out.println("-----Update producto-----");
			long idAEditar = 2l;
			Producto productoEditado = new Producto("Camisa", 11.10f, "000026", 10l);
			Producto productoActualizado = updateProducto(connection, idAEditar,productoEditado);
			updateProducto(connection, idAEditar, pConId2);
			System.out.println(productoActualizado);*/
			
			//System.out.println("");
			//System.out.println("---- Delete Producto-----");
			//long idABorrar = 13l;
			//deleteProducto(connection, idABorrar);
			//System.out.println("");
			
			connection.close();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			//connection.close();
		}
				
	}
	
	// creo un nuevo metodo static
	
	public static Collection <Producto> selectAll(Connection connection) throws SQLException {
		
		String sqlSelect = "SELECT * FROM productos";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		while(resultSet.next()) { // encontro registros?
			Long id = resultSet.getLong(1); // Id,
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			Producto producto = new Producto(id,titulo,precio,codigo,tipoProducto);
			//System.out.println(producto);
			productos.add(producto);
			
			}
		
		statement.close();
		
		return productos;
		
	}
	
	
	public static Producto selectById(Connection connection, long idProducto) throws SQLException {
		
		String sqlSelect = "SELECT * FROM productos WHERE id = " + idProducto;
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Producto producto = null;
		
		if (resultSet.next()) { // si encontro un producto
			
			Long id = resultSet.getLong(1); // id
			String titulo = resultSet.getString(2); // titulo
			Float precio = resultSet.getFloat(3); // precio
			String codigo = resultSet.getString(4); // codigo 
			Long tipoProducto = resultSet.getLong(5); // tipo de producto
			
			producto = new Producto(id, titulo, precio, codigo, tipoProducto);
			
			//System.out.println(producto);
										
		}
		
		statement.close();
		return producto;
	}

	
	public static Producto createProducto(Connection connection, Producto producto) throws Exception {
		
		String sql = "INSERT INTO productos (titulo, precio, codigo, id_tipo_producto)" 
				+ "VALUES ('"+producto.getTitulo()
				+"', '"+producto.getPrecio()+"', '"
				+producto.getCodigo()+"', '"
				+producto.getTipoProducto()+"')";
		
		PreparedStatement stament = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		stament.execute();
		
		ResultSet resultSet = stament.getGeneratedKeys();
		
		if(resultSet.next()) { //si se creo el producto
			Long pk = resultSet.getLong(1);
			producto.setId(pk);
		} else {
			throw new Exception("No se ha podido obtener el Id generado");
		}
		
		stament.close();
		
		return producto;
		
	}

	public static Producto updateProducto(Connection connection, Long idProducto, Producto producto) throws Exception {
		
		Producto productoBuscado = selectById(connection, idProducto);
		if(productoBuscado == null) {
			throw new Exception("No existe producto con id " + idProducto);
		}
		
		String sqlSelect = "UPDATE productos "
				+ "SET titulo='"+producto.getTitulo() +"',"
				+ "precio='"+producto.getPrecio() +"',"
				+ "codigo='"+producto.getCodigo() +"',"
				+ "id_tipo_producto='"+producto.getTipoProducto() +"'"
				+ "WHERE id='"+ idProducto +"'";
		
		Statement statement = connection.createStatement();
		int updated = statement.executeUpdate(sqlSelect);
		
		statement.close();
		
		if(updated != 1) {
			throw new Exception("No se ha podido modificar los datos del producto con el id: " + idProducto);
		}
		
		producto = selectById(connection, idProducto); // Consulta producto actualizado
		
		return producto;
	}
	
	public static Producto deleteProducto(Connection connection, long id) throws Exception {
		
		Producto productoBuscado = selectById(connection, id);
		
		if(productoBuscado == null) {
			throw new Exception("No existe el producto con el id: " + id);
		}
		
		String sql = "DELETE FROM productos WHERE id = " + id;
		
		Statement statement = connection.createStatement();
		
		int deleted = statement.executeUpdate(sql);
		
		statement.close();
		
		if(deleted != 1) { // si no lo borro me va a devolver algo distinto a 1
			throw new Exception("No se ha podido eliminar el producto con el id " + id);
		}
		
		return productoBuscado;
	}

	public static Producto selectByCodigo(Connection connection, String codigoProducto) throws SQLException {
		
		String sqlSelect = "SELECT * FROM productos WHERE codigo = '" + codigoProducto + "'";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Producto producto = null; 
		if(resultSet.next()) {
			Long id = resultSet.getLong(1); // id
			String titulo = resultSet.getString(2);
			Float precio = resultSet.getFloat(3);
			String codigo = resultSet.getString(4);
			Long tipoProducto = resultSet.getLong(5);
			
			producto = new Producto(id, titulo, precio, codigo, tipoProducto);
			//System.out.println(producto);
		}
		
		statement.close();
		resultSet.close();
		
		return producto;
	}
	
}
