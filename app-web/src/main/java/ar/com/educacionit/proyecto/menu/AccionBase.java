package ar.com.educacionit.proyecto.menu;

import java.util.Scanner;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.impl.ProductoDAOjdbcImpl;

public class AccionBase {

	protected Scanner teclado;
	protected ProductoDAO pdao;
	
	public AccionBase() {
		pdao = new ProductoDAOjdbcImpl();
	}
	
	public void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}
}
