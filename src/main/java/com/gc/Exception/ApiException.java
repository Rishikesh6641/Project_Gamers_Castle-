package com.gc.Exception;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException{
	
	public ApiException(String msg)
	{
		super(msg);
	}
}
