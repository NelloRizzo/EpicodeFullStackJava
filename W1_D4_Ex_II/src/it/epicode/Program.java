package it.epicode;

import it.epicode.code.Dipartimento;
import it.epicode.code.Dipendente;
import it.epicode.code.DipendenteFullTime;
import it.epicode.code.DipendentePartTime;
import it.epicode.code.PuoIniziareALavorare;
import it.epicode.code.Volontario;

public class Program {

	public static void effettuaCheckIn(PuoIniziareALavorare l) {
		l.checkIn();
	}

	public static void main(String[] args) {
		Dipendente[] array = { new DipendenteFullTime("0001", 1000, Dipartimento.AMMINISTRAZIONE),
				new DipendentePartTime("0002", 240, 50, Dipartimento.PRODUZIONE),
				new DipendenteFullTime("0003", 2000, Dipartimento.VENDITE) };

		int somma = 0;
		for (int i = 0; i < array.length; ++i) {
			Dipendente d = array[i];
			System.out.println(d.getMatricola() + '\t' + d.getStipendio());
			somma += d.calculateSalary();
		}
		System.out.println("Totale:\t" + somma);

		// enhanced-for
		for (Dipendente d : array) {
			System.out.println(d.getMatricola());
		}

		effettuaCheckIn(new Volontario("Paperino", 35, "Non so fare nulla"));
		effettuaCheckIn(new DipendentePartTime("0002", 240, 50, Dipartimento.PRODUZIONE));
	}
}
