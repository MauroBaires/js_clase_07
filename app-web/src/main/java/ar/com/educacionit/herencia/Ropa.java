package ar.com.educacionit.herencia;

public class Ropa extends Articulo {

	private String talla;

	
	public Ropa(String nombre, String talla) {
		super(nombre);
		this.talla = talla;
	}
	
	public Ropa(String nombre, float precio, String talla) {
		super(nombre, precio);
		this.talla = talla;
	}

	@Override
	public String toString() {
		return "Ropa [talla=" + talla + ", " + super.toString() + "]";
	}

	
	
	
}
