package com.cgi.poei.mediatheque.exception;

import com.cgi.poei.mediatheque.Exemplaire;

public class ExemplaireDejaEmprunteException extends MediathequeException {

	private static final long serialVersionUID = 1L;
	
	public ExemplaireDejaEmprunteException(Exemplaire exemplaire) {
		super("Exemplaire " + exemplaire.getDocument().getTitre() + " dejà emprunté");
	}

}
