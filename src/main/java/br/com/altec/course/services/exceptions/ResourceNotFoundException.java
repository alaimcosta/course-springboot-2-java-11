package br.com.altec.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {  	//Passo o ID que não encontrei
		super("Resource not found. Id " + id);		 //chamo o construtor da super classe
	}
	
}
