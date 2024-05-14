package it.epicode.fiscalcode.services;

import it.epicode.fiscalcode.entities.PersonalData;

public interface FiscalCodeService {
	/**
	 * Calcola il codice fiscale di una persona.
	 * 
	 * @param data i dati anagrafici della persona.
	 * @return il codice fiscale associato ai dati passati in input.
	 */
	String generateFiscalCode(PersonalData data);
}
