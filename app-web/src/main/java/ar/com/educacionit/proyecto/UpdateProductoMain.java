package ar.com.educacionit.proyecto;

import java.util.Scanner;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.impl.ProductoDAOjdbcImpl;

public class UpdateProductoMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el ID del producto que desea actualizar");
		
		Long id = teclado.nextLong();

		ProductoDAO productoDao = new ProductoDAOjdbcImpl();
		
		try {
			Producto producto = productoDao.getById(id);
			
			if(producto != null) {
				System.out.println(producto);
				
				//subir el precio un 10%
				Float precioActual = producto.getPrecio();
				Float precioActualizado = precioActual * 1.1f;
				producto.setPrecio(precioActualizado);
				
				//titulo
				producto.setTitulo("PC de escritorio");
				
				producto = productoDao.update(producto); 
				System.out.println(producto);
				System.out.println("Producto actualizado correctamente");
				
				
			} else {
				System.err.println("No existe el producto id = " + id);
			}
			
		} catch (GenericException e) {
			
			System.err.println(e.getMessage());
			
		} finally {
			teclado.close();
		}
		
	}

}
