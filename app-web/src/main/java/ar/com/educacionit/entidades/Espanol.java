package ar.com.educacionit.entidades;

import java.util.Objects;

import ar.com.educacionit.interfaces.IIdioma;

public class Espanol implements IIdioma {

	private String nombre = "Espanol";
	
	public Espanol(String nombre) {
		this.nombre = nombre;
	}

	public Espanol() {
		
	}
	
	@Override
	public void decir(String palabra) {
		
		System.out.println("En Español: " + palabra);

	}

	@Override
	public String toString() {
		return "Espanol";
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
		Espanol other = (Espanol) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	
}
