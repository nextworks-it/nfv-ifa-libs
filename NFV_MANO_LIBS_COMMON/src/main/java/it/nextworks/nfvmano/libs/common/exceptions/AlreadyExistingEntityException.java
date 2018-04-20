package it.nextworks.nfvmano.libs.common.exceptions;

/**
 * Exception launched when an entity to be created already exists.
 * 
 * @author nextworks
 *
 */
public class AlreadyExistingEntityException extends Exception {

	public AlreadyExistingEntityException() {
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistingEntityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistingEntityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistingEntityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistingEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
