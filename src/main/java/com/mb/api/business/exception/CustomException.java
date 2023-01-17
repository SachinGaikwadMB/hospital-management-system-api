package com.mb.api.business.exception;

import com.mb.api.business.constant.StatusCode;

public class CustomException extends RuntimeException
{

	private static final long serialVersionUID = 1L;
	
	private StatusCode statusCode;
	
	public CustomException() {}
	
	public CustomException(StatusCode statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public StatusCode getStatusCode()
	{
		return statusCode;
	}

}
