package ar.com.educacionit.exceptions.checked;

public class DivisionPorCeroException extends Exception{

	public DivisionPorCeroException(String message) {
		super("Hay un error ---> " + message);
		
	}

	
	

	
	
}
