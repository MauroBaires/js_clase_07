package ar.com.educacionit.main;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		
		TreeSet<Integer> alturas = new TreeSet<>();
		
		//treeSet las va a insertar ordenadas
			
			alturas.add(172);
			alturas.add(167);
			alturas.add(182);
			alturas.add(153);
			alturas.add(171);
			
			System.out.println(alturas);
			
			// Java 11
			
			Set<String> nombres2 = Set.of("Fernando", "Lorena", "Mariana", "Diego");
		
			TreeSet<String> nombres = new TreeSet<>(nombres2);
			System.out.println("nombres " + nombres);
			System.out.println("Nombres 2 " + nombres2);
			
	}

}
