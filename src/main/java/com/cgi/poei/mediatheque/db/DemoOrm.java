package com.cgi.poei.mediatheque.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cgi.poei.mediatheque.Usager;

public class DemoOrm {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mediatheque");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createNativeQuery("select * from Usager", Usager.class);
			List<?> list = query.getResultList();
			
			for (Object object : list) {
				Usager usager = (Usager) object;
				System.out.println(usager.getNomComplet());
			}
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
