package com.cgi.poei.mediatheque;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cgi.poei.mediatheque.exception.InscriptionException;

@Stateless
public class InscripteurUsager {
	
	@PersistenceContext(unitName="mediatheque")
	private EntityManager entityManager;
	
	public Usager inscrire(String nom, String prenom, LocalDate dateNaissance) throws InscriptionException {
		InscriptionException inscriptionException = new InscriptionException();
		if(nom == null || "".equals(nom)) {
			inscriptionException.ajouterRaison("nom", "Le nom est obligatoire");
		}
		if(prenom == null || "".equals(prenom)) {
			inscriptionException.ajouterRaison("prenom", "Le prenom est obligatoire");
		}
		if (dateNaissance != null) {
			LocalDate maintenant = LocalDate.now();
			if (dateNaissance.isAfter(maintenant)) {
				inscriptionException.ajouterRaison("dateNaissance", "La date de naissance doit être antérieure à aujourd'hui");
			}
		}
		if (inscriptionException.isKo()) {
			throw inscriptionException;
		}
		
		Usager usager = new Usager(genererCode(nom, prenom, dateNaissance), prenom, nom, dateNaissance);
		entityManager.persist(usager);
		return usager;
		
	}

	public Usager getByCode(String code) {
		return entityManager.createQuery("select u from Usager u where u.code = :code", Usager.class)
				            .setParameter("code", code).getSingleResult();
	}

	private String genererCode(String nom, String prenom, LocalDate dateNaissance) {
		String annee = dateNaissance != null ? String.valueOf(dateNaissance.getYear()) : "0000";
		String debutNom = nom.length() == 1 ? nom + nom : nom.substring(0, 2);
		return debutNom + prenom.substring(0, 1) + annee;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void deleteByCode(String code) {
		entityManager.createQuery("delete from Usager u where u.code = :code")
		             .setParameter("code", code)
		             .executeUpdate();
	}
	
}




















