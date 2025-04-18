package ar.com.educacionit.herencia;

public class BuscadorMain {

	public static void main(String[] args) {
		
		
		Buscador bs = new Buscador();
		bs.buscar();
		
		Integer cantidad = bs.getCantidadResultados();
		
		if (bs.hayResultados()) {
			Articulo[] articulos = bs.getResultados();
			
			for (Articulo articulo : articulos) {
				System.out.println(articulo);
			}
		}
		
	}

}
