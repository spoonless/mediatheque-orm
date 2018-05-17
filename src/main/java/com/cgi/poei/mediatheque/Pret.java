package com.cgi.poei.mediatheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.cgi.poei.mediatheque.exception.ExemplaireDejaEmprunteException;

@Entity
public class Pret {
	
	public static final int NB_PRETS_AUTORISES = 6;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Transient
	private Exemplaire exemplaire;

	@ManyToOne(targetEntity=Usager.class)
	private Emprunteur emprunteur;
	private LocalDate dateEmprunt;
	private LocalDate dateRetour;
	
	public static boolean isQuotaDepasse(int size) {
		return size > NB_PRETS_AUTORISES;
	}
	
	protected Pret() {
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
    
    public Emprunteur getEmprunteur() {
		return emprunteur;
	}

    @Override
	public String toString() {
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
		return emprunteur.getNomComplet() + " emprunte " + 
			   exemplaire.getDocument().getTitre() + 
			   " jusqu'au " + dateTimeFormatter.format(dateRetour);
	}
}
