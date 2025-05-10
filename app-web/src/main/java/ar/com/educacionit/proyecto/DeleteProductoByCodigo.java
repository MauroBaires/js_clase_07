package ar.com.educacionit.proyecto;

import java.util.Scanner;

import ar.com.educacionit.impl.ProductoDAOjdbcImpl;
import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.GenericException;

public class DeleteProductoByCodigo {

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in); 
		
		System.out.println("Ingrese el codigo del producto a eliminar: ");
		
		String codigo = teclado.next();
		
		ProductoDAO productoDao = new ProductoDAOjdbcImpl();
		
		try {
			Producto productoPorCodigo = productoDao.deleteByCodigo(codigo);
			
			System.out.println("Se ha eliminado el producto: "+ productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con el codigo=" + codigo);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
		
	}

}
