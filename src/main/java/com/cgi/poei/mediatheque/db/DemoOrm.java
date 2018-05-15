package com.cgi.poei.mediatheque.db;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cgi.poei.mediatheque.Usager;

public class DemoOrm {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mediatheque");
		EntityManager em = emf.createEntityManager();

		try {
			
			// Récupérer tous les usagers
			TypedQuery<Usager> query = em.createQuery("select u from Usager u", Usager.class);
			System.out.println("Tous les usagers");
			for (Usager usager : query.getResultList()) {
				System.out.println(usager.getNomComplet());
			}
			
			// Récupérer tous les usagers né entre le ? et le ?
			System.out.println("Tous les usagers entre deux dates");
			query = em.createQuery("select u from Usager u where u.dateNaissance between :premiereDate and :secondeDate", Usager.class);
			query.setParameter("premiereDate", LocalDate.of(2000, Month.JANUARY, 1));
			query.setParameter("secondeDate", LocalDate.of(2010, Month.DECEMBER, 31));
			for (Usager usager : query.getResultList()) {
				System.out.println(usager.getNomComplet());
			}
			
			em.getTransaction().begin();
			// Supprimer tous les usagers dont le nom commmence par Y
			em.createQuery("delete from Usager u where upper(u.nom) like 'Y%'")
			  .executeUpdate();
			em.getTransaction().commit();
			

		} finally {
			em.close();
			emf.close();
		}
	}

}
