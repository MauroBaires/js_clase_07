package ar.com.educacionit.entidades;

public class Articulo implements Comparable<Articulo>{

	//Atributos de instancia
	
	private String nombre;
	private String autor;
	private Float precio;
	
	
	
	public Articulo(String nombre, String autor, Float precio) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public Float getPrecio() {
		return precio;
	}



	public void setPrecio(Float precio) {
		this.precio = precio;
	}



	@Override
	public int compareTo(Articulo otroArticulo) {
		
		Articulo esteArticulo = this;
		
		return esteArticulo.getPrecio().compareTo(otroArticulo.getPrecio());
		
	}


	//toString() 
	
	@Override
	public String toString() {
		return "Articulo [nombre = " 
					+ nombre 
					+ ", autor = " 
					+ autor 
					+ ", precio = $" 
					+ precio + "]\n";
	}
	
}
