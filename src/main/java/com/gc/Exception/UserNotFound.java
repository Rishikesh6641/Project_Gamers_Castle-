package com.gc.Exception;

@SuppressWarnings("serial")
public class UserNotFound extends Exception{
	public UserNotFound(String msg){
		super(msg);
	}
}
