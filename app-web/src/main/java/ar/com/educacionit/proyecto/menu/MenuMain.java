package ar.com.educacionit.proyecto.menu;

import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		Menu menu = new Menu();

		Integer continuar = null; // bandera/flag
		
		do {
			
			Integer opcion = menu.getObtenerOpcion(teclado);
			
			MenuEnum menuEnum = MenuEnum.getByCodigo(opcion);
			
			// System.out.println(menuEnum);
			IAccion accion = MenuAccionFactory.getIAccion(menuEnum);
			System.out.println(accion);
			
			System.out.println("---------------------");
			System.out.println("¿Desea continuar? (1 = si // 0 = no)");
			continuar = teclado.nextInt();
			
		} while (continuar == 1);
		
		teclado.close();
		System.out.println("Fin del programa");
	}

}
