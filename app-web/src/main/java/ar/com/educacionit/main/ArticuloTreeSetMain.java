package ar.com.educacionit.main;

import java.util.Set;
import java.util.TreeSet;

import ar.com.educacionit.entidades.Articulo;

public class ArticuloTreeSetMain{

	public static void main(String[] args) {
		
		Set<Articulo> articulos = new TreeSet<Articulo>();
		
		Articulo articulo = new Articulo("Libro 1", "Pepe", 321f);
		Articulo articulo2 = new Articulo("Libro 2", "Juan", 352f);
		Articulo articulo3 = new Articulo("Libro 3", "Roberto", 125f);
		
		articulos.add(articulo);
		articulos.add(articulo2);
		//articulos.add(articulo3);
		
		System.out.println(articulos);
	}

}
