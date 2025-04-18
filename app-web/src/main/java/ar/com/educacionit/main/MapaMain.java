package ar.com.educacionit.main;

import java.util.HashMap;
import java.util.Map;

public class MapaMain {

	public static void main(String[] args) {
		System.out.println("Mapa");
		//crea
		Map<Integer, String> diasSemana = new HashMap<>();
		
		//carga
		diasSemana.put(1, "Lunes");
		diasSemana.put(2, "Martes");
		diasSemana.put(3, "Miercoles");
		diasSemana.put(4, "Jueves");
		diasSemana.put(5, "Viernes");
		diasSemana.put(6, "Sabado");
		diasSemana.put(7, "Domingo");
		
		System.out.println(diasSemana);
		
	}

}
