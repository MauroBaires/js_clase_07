package ar.com.educacionit.proyecto;

import java.util.Scanner;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.impl.ProductoDAOjdbcImpl;

public class CreateProductoMain {

	public static void main(String[] args) {

		//QUe necesita el producto
		//id, titulo, precio, codigo, tipo_producto
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese titulo:");
		String titulo = teclado.next();
		
		System.out.println("Ingrese precio:");
		float precio = teclado.nextFloat();
		
		System.out.println("Ingrese codigo producto:");
		String codigo = teclado.next();
		
		System.out.println("Ingrese tipo de producto:");
		long tipoProducto = teclado.nextLong();
		
		
		ProductoDAO productoDao = new ProductoDAOjdbcImpl();
		
		Producto nuevoProducto = new Producto(titulo, precio, codigo, tipoProducto);
		
		try {
			nuevoProducto = productoDao.create(nuevoProducto);
			System.out.println("Se ha creado el producto: ID=" + nuevoProducto.getId());
		} catch (GenericException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (DuplicatedException e) {
			System.err.print(e.getMessage());
		} finally {
			teclado.close();
		}

	}

}
