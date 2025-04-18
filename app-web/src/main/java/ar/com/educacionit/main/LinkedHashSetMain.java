package ar.com.educacionit.main;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		
		LinkedHashSet<String> nombres = new LinkedHashSet<>();
		
		nombres.add("Fernando");
		nombres.add("Maximiliano");
		nombres.add("Roberto");
		nombres.add("Laura");
		nombres.add("Luciana");
		nombres.add("Mariela");
		nombres.add("Matias");
		nombres.add("Mauro");
		
		boolean resultado = nombres.remove("Maximiliano");
		System.out.println(resultado);
		
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String nombre = (String) itNombres.next();
			System.out.println(nombre);
			}
		
	}

}
