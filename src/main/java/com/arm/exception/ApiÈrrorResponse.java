package com.arm.exception;

public class ApiÈrrorResponse {

	
	private String errorMessage;
	private String path;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return path;
	}

	public void getUrl(final String requestedURI) {
		this.path = requestedURI;
	}
	
}
