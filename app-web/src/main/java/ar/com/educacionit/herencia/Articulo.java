package ar.com.educacionit.herencia;

public abstract class Articulo {
	
		private String nombre;
		private Float precio;
		
				
		
		//constructor
		
		public Articulo(String nombre) {
			inicializar(nombre);
		}

		public Articulo(String nombre, Float precio) {
			
			inicializar(nombre);
			this.precio = precio;
		} 
		
		private void inicializar(String nombre) {
			this.nombre = nombre;
			
		}

		@Override
		public String toString() {
			return "Articulo ["
					+ "nombre = " + nombre + 
					", precio = $" + precio + "]";
		}		
	
		
		
		
		
}
