package me.crm.error_response;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientNotFoundException(Throwable cause) {
		super(cause);
	}

	public ClientNotFoundException(String message) {
		super(message);
	}
}
