package com.cgi.poei.mediatheque.document;

import java.time.Year;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.poei.mediatheque.Section;

@Entity
@DiscriminatorValue("film")
public class Film extends Document {

	public static final int NB_PRETS_FILMS_AUTORISES = 3;
	private static int nbFilms;
	
	private String realisateur;
	private String isbn;
	
	protected Film() {
		
	}

	public Film(String isbn, String titre, String realisateur, String editeur, Year anneeEdition) {
		this(isbn, titre, realisateur, editeur, anneeEdition, Section.TOUT_PUBLIC);
	}

	public Film(String isbn, String titre, String realisateur, String editeur, Year anneeEdition, Section section) {
		super(titre, editeur, anneeEdition, section);
		this.isbn = isbn;
		this.realisateur = realisateur;
		Film.nbFilms++;
	}

	public String getRealisateur() {
		return realisateur;
	}
	
	public String getDistributeur() {
		return getEditeur();
	}

	@Override
	public String getIdentifiant() {
		return getIsbn();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public static int getNbFilms() {
		return nbFilms;
	}
}
