package com.cgi.poei.mediatheque.db;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cgi.poei.mediatheque.Adresse;
import com.cgi.poei.mediatheque.Usager;

public class DemoRelationOrm {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mediatheque");
		EntityManager em = emf.createEntityManager();

		try {
//			Usager usager = new Usager("Z", "Diego", "De la vega", LocalDate.of(1832, Month.APRIL, 12));
//
//			Adresse adresse = new Adresse();
//			adresse.setRue("24 rue des palmiers");
//			adresse.setCodePostal("33120");
//			adresse.setVille("Arcachon");
//			
//			usager.setAdresse(adresse);
//			
//			em.getTransaction().begin();
//			em.persist(usager);
//			em.getTransaction().commit();
			
			Usager usager = em.find(Usager.class, 21);
			
			System.out.println(usager.getNomComplet());
			

		} finally {
			em.close();
			emf.close();
		}
	}

}
