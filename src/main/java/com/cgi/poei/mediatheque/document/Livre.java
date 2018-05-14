package com.cgi.poei.mediatheque.document;

import java.time.Year;

public class Livre extends Document {
	private String isbn;
	private String auteur;

	public Livre(String isbn, String titre, String auteur, String editeur, Year anneeEdition) {
		super(titre, editeur, anneeEdition);
		this.isbn = isbn;
		this.auteur = auteur;
	}

	@Override
	public String getIdentifiant() {
		return isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Livre) {
			Livre livre = (Livre) obj;
			return livre.isbn.equals(this.isbn);
		}
		return false;
	}

}
