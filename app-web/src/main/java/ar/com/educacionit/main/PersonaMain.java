package ar.com.educacionit.main;

import ar.com.educacionit.entidades.Espanol;
import ar.com.educacionit.entidades.Ingles;
import ar.com.educacionit.entidades.Portugues;
import ar.com.educacionit.exceptions.checked.NoSabeException;
import ar.com.educacionit.entidades.Persona;

public class PersonaMain {

	public static void main(String[] args) {
		

		Persona p1 = new Persona();
		System.out.println(p1);
		
		System.out.println("----------------------------");
		
		Persona p2 = new Persona("Pedro", "Rodriguez", new Espanol());
		System.out.println(p2);
		
		System.out.println("----------------------------");
		
		//otra manera de crear una nueva Persona. Instanciando el idioma
		Ingles ingles = new Ingles();
		Espanol espanol = new Espanol();
		Portugues portugues = new Portugues(); 
		
		Persona p3 = new Persona("Laura", "Gimenez", ingles);
		System.out.println(p3);
		
		System.out.println("----------------------------");
		
		p2.aprender(ingles);			
		p2.aprender(portugues);
		System.out.println(p2);
		
		p2.decir("Palabra");
		p3.decir("Palabra");
		
		try {
			p2.decir("hola", ingles);
		} catch (NoSabeException e) {
			e.printStackTrace();
		}
		
		p3.aprender(espanol);
		
		p3.aprender(portugues);

		System.out.println(p3);
		
		try {
			p3.decir("hola", ingles);
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p3.decir("hola", new Ingles());
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			p3.decir("hola", espanol);
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p3.decir("hola", new Espanol());
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			p3.decir("hola", portugues);
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p3.decir("hola", new Portugues());
		} catch (NoSabeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");
		
	}

}
