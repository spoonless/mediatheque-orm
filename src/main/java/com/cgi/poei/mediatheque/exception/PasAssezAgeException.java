package com.cgi.poei.mediatheque.exception;

public class PasAssezAgeException extends MediathequeException {
	private static final long serialVersionUID = 5311198363443127954L;

	public PasAssezAgeException(int ageRequis) {
		super("L'âge requis pour emprunter ce document est " + ageRequis + " ans.");
	}
}
