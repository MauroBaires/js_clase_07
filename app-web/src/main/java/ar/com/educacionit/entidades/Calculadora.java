package ar.com.educacionit.entidades;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class Calculadora {

	public static int dividir(int a, int b) throws DivisionPorCeroException {

		if(b == 0) {
			throw new DivisionPorCeroException("No se puede dividir por cero");
		}
		
		return a / b;
		
	}
	
}
