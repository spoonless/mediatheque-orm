package com.cgi.poei.mediatheque;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;


public class InscripteurUsagerTest {
	
	@Test
	public void testLeCodeCommencePar2LettresDuNomEt1LettreDuPrenomSuiviDeLAnnee() {
		InscripteurUsager inscripteurUsager = new InscripteurUsager();
		
		String code = inscripteurUsager.genererCode("Michou", "Charle", LocalDate.of(1999, Month.AUGUST, 15));
		
		Assert.assertEquals("MiC1999", code);;
	}

}
