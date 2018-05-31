package com.cgi.poei.mediatheque;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;


public class InscripteurUsagerTest {
	
	@Test
	public void testInscriptionPersisante() throws Exception {
		EntityManager emMock = mock(EntityManager.class);
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		inscripteurUsager.setEntityManager(emMock);
		
		Usager usager = inscripteurUsager.inscrire("Michou", "Charle", LocalDate.of(1999, Month.AUGUST, 15));
		
		verify(emMock).persist(usager);
	}

	@Test
	public void testQuandJInscrisLeCodeCommencePar2LettresDuNomEt1LettreDuPrenomSuiviDeLAnnee() throws Exception {
		EntityManager emMock = mock(EntityManager.class);
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		inscripteurUsager.setEntityManager(emMock);
		
		Usager usager = inscripteurUsager.inscrire("Michou", "Charle", LocalDate.of(1999, Month.AUGUST, 15));
		
		assertEquals("MiC1999", usager.getCode());
	}

	@Test
	public void testQuandJInscrisEtLAnneeEstNulleAlorsLeCodeFinitPar0000() throws Exception {
		EntityManager emMock = mock(EntityManager.class);
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		inscripteurUsager.setEntityManager(emMock);
		
		Usager usager = inscripteurUsager.inscrire("Michou", "Charle", null);
		
		Assert.assertEquals("MiC0000", usager.getCode());
	}

	@Test
	public void testQuandJInscrisSiLeNomNeContientQuUneLettreAlorsOnDoubleLaLettre() throws Exception {
		EntityManager emMock = mock(EntityManager.class);
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		inscripteurUsager.setEntityManager(emMock);
		
		Usager usager = inscripteurUsager.inscrire("M", "Charle", null);

		Assert.assertEquals("MMC0000", usager.getCode());
	}

}
