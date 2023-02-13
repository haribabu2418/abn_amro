package com.arm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ApiÈrrorResponse handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ApiÈrrorResponse error = new ApiÈrrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.getUrl(request.getRequestURI());

		return error;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiÈrrorResponse handleException(final Exception exception, final HttpServletRequest request) {

		ApiÈrrorResponse error = new ApiÈrrorResponse();
		error.setErrorMessage(exception.getMessage());
		error.getUrl(request.getRequestURI());
		return error;
	}
}
