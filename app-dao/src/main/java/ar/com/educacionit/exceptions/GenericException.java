package ar.com.educacionit.exceptions;

public class GenericException extends Exception {

	//Constructor parametrizado que recibe solo el mensaje
	public GenericException(String message) {
		
		super(message);
	}

	//Constructor parametrizado que recibe solo el mensaje
	public GenericException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	

}
