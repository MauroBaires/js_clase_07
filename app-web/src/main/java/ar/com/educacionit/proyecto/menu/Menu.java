package ar.com.educacionit.proyecto.menu;

import java.util.Scanner;

public class Menu {

	public void mostrarMenu() {
		
		System.out.println("Ingrese una opcion:");
		System.out.println("1 - Crear");
		System.out.println("2 - Buscar por ID");
		System.out.println("3 - Buscar por Codigo");
		System.out.println("4 - Actualizar");
		System.out.println("5 - Eliminar por ID");
		System.out.println("6 - Eliminar por Codigo");
		System.out.println("7 - Listar todos");
		System.out.println("8 - Buscar por titulo");
		
	}
	
	public Integer getObtenerOpcion(Scanner teclado) {
		
		Integer opcion = null;
		
		do {
			this.mostrarMenu();
			opcion = teclado.nextInt();
		} while (opcion < 0 || opcion > 8);
		
		return opcion;
	}
	
}
