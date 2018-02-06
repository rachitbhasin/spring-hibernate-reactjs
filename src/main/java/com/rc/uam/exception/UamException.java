/**
 * 
 */
package com.rc.uam.exception;

/**
 * @author Rachit Bhasin
 *
 */
public class UamException extends Exception{
	private static final long serialVersionUID = 1L;

	public UamException() {
		// TODO Auto-generated constructor stub
	}

	public UamException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UamException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public UamException(String message, Throwable throwable) {
		super(message, throwable);
		// TODO Auto-generated constructor stub
	}
}
