package ar.com.educacionit.entidades;

import java.util.Objects;

import ar.com.educacionit.interfaces.IIdioma;

public class Portugues implements IIdioma {

	private String nombre = "Portugues";
	
	
	
	public Portugues(String nombre) {
		this.nombre = nombre;
	}

	public Portugues() {
		
	}
	
	@Override
	public void decir(String palabra) {
		
		System.out.println("En portugues: " + palabra);
		
	}
	
	@Override
	public String toString() {
		return "Portugues";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portugues other = (Portugues) obj;
		return Objects.equals(nombre, other.nombre);
	}
	

	
}
