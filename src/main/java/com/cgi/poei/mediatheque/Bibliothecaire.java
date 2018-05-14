package com.cgi.poei.mediatheque;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.cgi.poei.mediatheque.document.Document;
import com.cgi.poei.mediatheque.document.Livre;

public class Bibliothecaire {
	
	public static void main(String[] args) {
		List<Livre> documents = new ArrayList<>();
		
		documents.add(new Livre("isbn", "La ferme des animaux", "Georges Orwell", "editeur", Year.of(1998)));
		documents.add(new Livre("isbn", "1984", "Georges Orwell", "editeur", Year.of(1948)));
		documents.add(new Livre("isbn", "Le talon de fer", "Georges Orwell", "editeur", Year.of(1948)));
		
		Bibliothecaire k = new Bibliothecaire();
		Document livre = k.chercher(documents, "1984");
		System.out.println(livre.getAnneeEdition());
	}
	
	public <T extends Document> T chercher(List<T> documents, String titre) {
		for (T document : documents) {
			if (document.getTitre().equals(titre)) {
				return document;
			}
		}
		return null;
	}

	public void ajouter1984(List<? super Livre> documents) {
		documents.add(new Livre("isbn", "1984", "Georges Orwell", "editeur", Year.of(1948)));
	}
	
	public void doSomethingGromit(List<?> list) {
		list.size();
	}

}
