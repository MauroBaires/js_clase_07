package ar.com.educacionit.interfaces;

public interface IIdioma {
	//Creamos nuestro contrato
	public void decir(String palabra); //Solo coloco la firma. Hasta version 8 de Java
	
	
	// todas las clases que implementen esta interfaz, tendran disponible el metodo "no se decir"
	public default void noSeDecir(String palabra) {
		System.out.println("No se decir... " + palabra);
	}
}
