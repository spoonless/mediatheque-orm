package com.cgi.poei.mediatheque;

import java.util.Comparator;

public class PretParDateRetourComparator implements Comparator<Pret> {

	@Override
	public int compare(Pret p1, Pret p2) {
		return p1.getDateRetour().compareTo(p2.getDateRetour());
	}

}
