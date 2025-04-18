package ar.com.educacionit.main;

import ar.com.educacionit.entidades.Calculadora;
import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class CalculadoraMain3 {

	public static void main(String[] args){
		
		int a = 20;
		int b = 0;
		
		boolean continuar = true;
		
		//do while se ejecuta aunque sea una vez
		//y al final evalua una condicion
		
		do {
		
			try {
			
				Calculadora.dividir(a,b);
				continuar = false;
			
			} catch (DivisionPorCeroException e) {
			
				e.printStackTrace();
				// b= 1;
				continuar = false;
			}
			
		} while (continuar);
		
		System.out.println("Fin");

	}

}
