package com.cgi.poei.mediatheque.document;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.cgi.poei.mediatheque.Exemplaire;
import com.cgi.poei.mediatheque.Section;

public abstract class Document {

	private List<Exemplaire> exemplaires = new ArrayList<>();

	private Section section;
	private String titre;
	private String editeur;
	private Year anneeEdition;
	
	public Document(String titre, String editeur, Year anneeEdition) {
		this(titre, editeur, anneeEdition, Section.TOUT_PUBLIC);
	}

	public Document(String titre, String editeur, Year anneeEdition, Section section) {
		this.titre = titre;
		this.editeur = editeur;
		this.anneeEdition = anneeEdition;
		this.section = section;
	}

	public abstract String getIdentifiant();

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Year getAnneeEdition() {
		return anneeEdition;
	}
	
	public void setAnneeEdition(Year anneeEdition) {
		this.anneeEdition = anneeEdition;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(ArrayList<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	public Section getSection() {
		return section;
	}
	
	@Override
	public String toString() {
		return titre;
	}

}
