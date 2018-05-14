package com.cgi.poei.mediatheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cgi.poei.mediatheque.exception.ExemplaireDejaEmprunteException;

public class Pret {
	
	public static final int NB_PRETS_AUTORISES = 6;
	
	private final Exemplaire exemplaire;
	private final Emprunteur emprunteur;
	private final LocalDate dateEmprunt;
	private final LocalDate dateRetour;
	
	public static boolean isQuotaDepasse(int size) {
		return size > NB_PRETS_AUTORISES;
	}

	public Pret(Exemplaire exemplaire, Emprunteur emprunteur, int dureePretEnJour) throws ExemplaireDejaEmprunteException {
        this.exemplaire = exemplaire;
        this.emprunteur = emprunteur;
        this.dateEmprunt = LocalDate.now();
        this.dateRetour = this.dateEmprunt.plusDays(dureePretEnJour);
        this.exemplaire.setPret(this);
    }
    
    public boolean isDepasse() {
    	return this.dateRetour.isBefore(LocalDate.now());
    }
    
    public Exemplaire getExemplaire() {
		return exemplaire;
	}
    
    public LocalDate getDateRetour() {
		return dateRetour;
	}

    @Override
	public String toString() {
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
		return emprunteur.getNomComplet() + " emprunte " + 
			   exemplaire.getDocument().getTitre() + 
			   " jusqu'au " + dateTimeFormatter.format(dateRetour);
	}
}
