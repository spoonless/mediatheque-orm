package com.cgi.poei.mediatheque.db;

import java.time.Year;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cgi.poei.mediatheque.document.Livre;

public class DemoHeritageOrm {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mediatheque");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Livre livre = new Livre("333666", "1984", "Georges Orwell", "manning", Year.of(1948));
			em.persist(livre);
			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}
	}

}
