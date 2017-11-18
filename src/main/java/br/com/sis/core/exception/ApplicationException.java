package br.com.sis.core.exception;

public class ApplicationException extends RuntimeException{

	public ApplicationException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 7041561271605315612L;
}
