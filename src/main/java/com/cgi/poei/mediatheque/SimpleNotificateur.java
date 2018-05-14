package com.cgi.poei.mediatheque;

public class SimpleNotificateur implements NotificateurDeRetourDePret {

	@Override
	public void notifierRetour(Exemplaire exemplaire) {
		System.out.println("Le document" + exemplaire.getDocument().getTitre() + " est à nouveau disponible");
	}

}
