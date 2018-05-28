package com.cgi.poei.mediatheque.exception;

import java.util.HashMap;
import java.util.Map;

public class InscriptionException extends MediathequeException {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> raisons = new HashMap<>();
	
	public void ajouterRaison(String champ, String raison) {
		raisons.put(champ, raison);
	}
	
	public boolean isKo() {
		return ! raisons.isEmpty();
	}
	
	public Map<String, String> getRaisons() {
		return raisons;
	}

}
