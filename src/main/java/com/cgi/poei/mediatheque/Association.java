package com.cgi.poei.mediatheque;

import java.util.ArrayList;

import com.cgi.poei.mediatheque.exception.PasAssezAgeException;
import com.cgi.poei.mediatheque.exception.QuotaEmpruntDepasseException;

public class Association implements Emprunteur {

	@Override
	public String getNomComplet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emprunter(Pret pret) throws QuotaEmpruntDepasseException, PasAssezAgeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Pret> getPrets() {
		// TODO Auto-generated method stub
		return null;
	}

}
