package com.cgi.poei.mediatheque.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class MediathequeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MediathequeException() {
	}
	
	public MediathequeException(String message) {
		super(message);
	}

}
