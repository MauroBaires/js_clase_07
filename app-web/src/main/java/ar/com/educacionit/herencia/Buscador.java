package ar.com.educacionit.herencia;

public class Buscador {
	
	//atributos
	private String claveBusqueda;
	private Integer cantidadResultados;
	private Articulo[] resultados;
	
	public Buscador() {
		this.resultados = new Articulo[0];
		this.cantidadResultados = 0;
		this.claveBusqueda = "";
	}

	// Clave busqueda
	
	public String getClaveBusqueda() {
		/*if ( this.claveBusqueda == null ) {
			return "";
		} 
		return this.claveBusqueda; */
		// Ternario
		// return (this.claveBusqueda == null) ? "" : this.claveBusqueda;
		return this.claveBusqueda;
	}
	
	public void setClaveBusqueda(String claveBusqueda) {
		/* if(claveBusqueda != null) {
			this.claveBusqueda = claveBusqueda;			
		} */
		this.claveBusqueda = claveBusqueda.toLowerCase();
	}

	public Integer getCantidadResultados() {
		/* if ( this.resultados == null) {
			return 0;
		} else {
			return this.resultados.length; // tamaño del array
		} */
		return this.resultados.length;
	}

	public Articulo[] getResultados() {
		/* if ( this.resultados == null) {
			return new String[0];
		}*/ 
		return this.resultados;
	}

	public void buscar() {
		// select * from articulos where titulo like 
		
		Articulo[] resultados = new Articulo[] {
				
				new Ropa("Pantalon largo", 22.2f, "Xl"),
				new Electronico("Celular", 20.1f, "Sony"),
				new Bazar("Bowl", 32.2f, 1),
				new Ropa("Pantalon Running", 40.2f, "L"),
				new Electronico("PC", 50.2F, "Lenovo"),
				
		};
		
		this.resultados = resultados;
		this.cantidadResultados = resultados.length;
		
	}
	
	public boolean hayResultados() {
		
		return this.cantidadResultados == 0 ? false : true; //opcion ternaria
		
	}
	
}
