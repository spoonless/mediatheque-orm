package com.cgi.poei.mediatheque.document;

import java.time.Year;

public class Revue extends Document {

	private String issn;

	public Revue(String issn, String titre, String editeur, Year anneEdition) {
		super(titre, editeur, anneEdition);
		this.issn = issn;
	}


	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	@Override
	public String getIdentifiant() {
		return issn;
	}

}
