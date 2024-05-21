package it.epicode.fiscalcodegenerator.services;

import it.epicode.fiscalcodegenerator.dto.PersonalData;

public interface FiscalCodeService {
	public String calculateFiscalCode(PersonalData data);
}
