package ar.com.educacionit.proyecto;

import java.util.Scanner;

import ar.com.educacionit.impl.ProductoDAOjdbcImpl;
import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.GenericException;

public class DeleteProductoByIdMain {

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in); 
		
		System.out.println("Ingrese el ID del producto a eliminar: ");
		
		Long id = teclado.nextLong();
		
		ProductoDAO productoDao = new ProductoDAOjdbcImpl();
		
		try {
			Producto productoPorID = productoDao.deleteById(id);
			
			System.out.println("Se ha eliminado el producto: "+ productoPorID);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con id="+ id);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
		
	}

}
