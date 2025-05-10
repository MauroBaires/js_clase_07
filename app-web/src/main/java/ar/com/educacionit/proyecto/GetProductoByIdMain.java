package ar.com.educacionit.proyecto;

import java.util.Scanner;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.impl.ProductoDAOjdbcImpl;

public class GetProductoByIdMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);			
		
		System.out.println("Ingrese el ID del producto:");
		
		Long id = teclado.nextLong();
		
		ProductoDAO productoDao = new ProductoDAOjdbcImpl();
		
		try {
			Producto productoPorId = productoDao.getById(id);
			
			
			System.out.println(productoPorId);
			
		} catch (GenericException e) {
			
			System.err.println("No se ha encontrado el producto con el Id: " +  id );
			System.err.println(e.getMessage());
			
		} finally {
			teclado.close();
		}
		
	}

}
