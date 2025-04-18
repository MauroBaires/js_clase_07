package ar.com.educacionit.entidades;

import java.util.Objects;

import ar.com.educacionit.interfaces.IIdioma;

public class Ingles implements IIdioma{

	private String nombre = "Ingles";
	
	public Ingles(String nombre) {
		this.nombre = nombre;
	}

	public Ingles() {
		
	}
	
	@Override
	public void decir(String palabra) {

		System.out.println("En ingles: " + palabra);
		
	}

	@Override
	public String toString() {
		return "Ingles";
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
		Ingles other = (Ingles) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
