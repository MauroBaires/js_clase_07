package ar.com.educacionit.herencia;

public class Electronico extends Articulo {
	
	private String marca;

	public Electronico(String nombre, String marca) {
		super(nombre);
		this.marca = marca;
	}
	
	public Electronico(String nombre, float precio, String marca) {
		super(nombre, precio);
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Electronico [marca=" + marca + ", =" + super.toString() + "]";
	}

	
	
	
	
}
