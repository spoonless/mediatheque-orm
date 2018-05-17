package com.cgi.poei.mediatheque.db;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cgi.poei.mediatheque.Adresse;
import com.cgi.poei.mediatheque.Exemplaire;
import com.cgi.poei.mediatheque.Pret;
import com.cgi.poei.mediatheque.Usager;
import com.cgi.poei.mediatheque.document.Livre;
import com.cgi.poei.mediatheque.exception.MediathequeException;

public class DemoRelationOrm {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mediatheque");
		EntityManager em = emf.createEntityManager();

		try {
			//testerCreationUsager(em);
			testerEmprunt(em);
			
		} catch (MediathequeException e) {
			System.err.println("L'opération n'est pas possible");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void testerEmprunt(EntityManager em) throws MediathequeException{
		Livre livre = new Livre("isbn", "titre", "auteur", "editeur", Year.of(1996));
		Exemplaire exemplaire = new Exemplaire("code", livre);

		try {
			em.getTransaction().begin();
			Usager usager = em.find(Usager.class, 21);
			Pret pret = new Pret(exemplaire, usager, 14);
			usager.emprunter(pret);
			em.getTransaction().commit();
		} catch(MediathequeException e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	private static void testerCreationUsager(EntityManager em) {
		Usager usager = new Usager("Z", "Diego", "De la vega", LocalDate.of(1832, Month.APRIL, 12));

		Adresse adresse = new Adresse();
		adresse.setRue("24 rue des palmiers");
		adresse.setCodePostal("33120");
		adresse.setVille("Arcachon");
		
		usager.setAdresse(adresse);
		
		em.getTransaction().begin();
		em.persist(usager);
		em.getTransaction().commit();
		
	}

}
