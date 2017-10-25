package com.shop.web.exception;

public class ServiceCommunicationException extends Exception {

	private static final long serialVersionUID = -2486385329596144954L;

	private final String code;
	private final String message;

	public ServiceCommunicationException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
