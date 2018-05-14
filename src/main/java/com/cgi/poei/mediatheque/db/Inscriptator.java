package com.cgi.poei.mediatheque.db;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cgi.poei.mediatheque.Usager;

public class Inscriptator {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Code : ");
		String code = scanner.nextLine();

		System.out.print("Nom : ");
		String nom = scanner.nextLine();

		System.out.print("Prenom : ");
		String prenom = scanner.nextLine();
		
		System.out.print("Date naissance (jj/mm/aaaa) : ");
		String dateNaissanceEntree = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateNaissance = LocalDate.parse(dateNaissanceEntree, formatter);

		Usager usager = new Usager(code, prenom, nom, dateNaissance);
		
		try {
			UsagerDao usagerDao = new UsagerDao();
			usagerDao.inscrire(usager);
		} catch (SQLException e) {
			System.err.println("Désolé, il y a eu un problème");
			e.printStackTrace();
		}
	}

}
