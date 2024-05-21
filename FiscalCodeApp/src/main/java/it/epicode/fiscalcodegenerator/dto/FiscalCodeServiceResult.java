package it.epicode.fiscalcodegenerator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class FiscalCodeServiceResult {
	private PersonalData data;
	private String fiscalCode;
}
