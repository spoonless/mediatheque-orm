package com.cgi.poei.mediatheque;

import java.util.List;

import com.cgi.poei.mediatheque.exception.PasAssezAgeException;
import com.cgi.poei.mediatheque.exception.QuotaEmpruntDepasseException;

public interface Emprunteur {
	
	String getNomComplet();
	
	void emprunter(Pret pret) throws QuotaEmpruntDepasseException, PasAssezAgeException;

	List<Pret> getPrets();
}
