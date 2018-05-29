package com.cgi.poei.mediatheque;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class InscripteurUsagerTest {
	
	@Test
	public void testQuandJInscrisLeCodeCommencePar2LettresDuNomEt1LettreDuPrenomSuiviDeLAnnee() throws Exception {
		EntityManager emMock = mock(EntityManager.class);
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		inscripteurUsager.setEntityManager(emMock);
		
		Usager usager = inscripteurUsager.inscrire("Michou", "Charle", LocalDate.of(1999, Month.AUGUST, 15));
		
		assertEquals("MiC1999", usager.getCode());
		verify(emMock).persist(usager);
	}

	
	@Test
	public void testLeCodeCommencePar2LettresDuNomEt1LettreDuPrenomSuiviDeLAnnee() {
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		
		String code = inscripteurUsager.genererCode("Michou", "Charle", LocalDate.of(1999, Month.AUGUST, 15));
		
		Assert.assertEquals("MiC1999", code);
	}

	@Test
	public void testLAnneeEstNulleAlorsLeCodeFinitPar0000() {
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		
		String code = inscripteurUsager.genererCode("Michou", "Charle", null);
		
		Assert.assertEquals("MiC0000", code);
	}

	@Test
	public void testSiLeNomNeContientQuUneLettreAlorsOnDoubleLaLettre() {
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		
		String code = inscripteurUsager.genererCode("M", "Charle", null);

		Assert.assertEquals("MMC0000", code);
	}
}
