package com.cgi.poei.mediatheque;

import com.cgi.poei.mediatheque.document.Document;
import com.cgi.poei.mediatheque.exception.ExemplaireDejaEmprunteException;

public class Exemplaire {

	private final String code;
	private final Document document;
	private Pret pret;
	private NotificateurDeRetourDePret notificateurDeRetourDePret;
	
	public Exemplaire(String code, Document document) {
		this.code = code;
		this.document = document;
		this.document.getExemplaires().add(this);
	}
	
	public boolean isEmprunte() {
		return this.getPret() != null;
	}

	public Document getDocument() {
		return document;
	}

	public Pret getPret() {
		return pret;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setNotificateurDeRetourDePret(NotificateurDeRetourDePret notificateurDeRetourDePret) {
		this.notificateurDeRetourDePret = notificateurDeRetourDePret;
	}
	
	public void setPret(Pret pret) throws ExemplaireDejaEmprunteException {
		if (pret != null && isEmprunte()) {
			throw new ExemplaireDejaEmprunteException(this);
		}
		if (pret == null && this.notificateurDeRetourDePret != null) {
			this.notificateurDeRetourDePret.notifierRetour(this);
		}
		this.pret = pret;
	}
	
}
