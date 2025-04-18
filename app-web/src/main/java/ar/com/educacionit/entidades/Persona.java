package ar.com.educacionit.entidades;

import java.util.Arrays;

import ar.com.educacionit.exceptions.checked.NoSabeException;
import ar.com.educacionit.interfaces.IIdioma;

public class Persona {

	private String nombre;
	private String apellido;
	private IIdioma idiomaNativo; //importo interfaz y la implementacion
	private IIdioma[] idiomas;
	
	
	//Constructor por defecto
	public Persona() {
	}
	
	//COnstructor parametrizado
	
	public Persona(String nombre, String apellido, IIdioma idiomaNativo) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
		this.idiomas = new IIdioma[0];

	}

	
	public void aprender(IIdioma nuevoIdioma) {
		//hay que controlar que el nuevo idioma no este en la lista! (TAREA)
		
		IIdioma[] actuales = new IIdioma[this.idiomas.length + 1];
		int i = 0;
		for (IIdioma idiomaQueSabe : this.idiomas) {
			actuales[i++] = idiomaQueSabe;
		}
		
		actuales[i] = nuevoIdioma;
		this.idiomas = actuales;
		
	}
	
	public void decir(String palabra) {
		
		this.idiomaNativo.decir(palabra);
	}
	
	//sobrecarga de metodos
	
	public void decir(String palabra, IIdioma unIdioma) throws NoSabeException {
		
		boolean sabeEseIdioma = false;
		for(IIdioma idiomaQueSabe : this.idiomas) {
			if(idiomaQueSabe.equals(unIdioma)) {
				sabeEseIdioma = true;
				break;
			}
		}
		
		if(sabeEseIdioma) {
			unIdioma.decir(palabra);
		}else {
			// unIdioma.noSeDecir(palabra);
			throw new NoSabeException(this.nombre + " - " 
									+ this.apellido 
									+ "," + palabra, null);
		}
	}
	

	@Override
	public String toString() {
		
		return "Persona: "
				+ "\nNombre: " + nombre 
				+ "\nApellido: " + apellido 
				+ "\nIdioma Nativo: " + idiomaNativo 
				+ "\nIdiomas: "
				+ Arrays.toString(idiomas);
	}

	
	
	
}
