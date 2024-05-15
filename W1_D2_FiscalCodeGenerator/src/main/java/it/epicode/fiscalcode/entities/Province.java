package it.epicode.fiscalcode.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Province {
	private long id;
	private String name;
	private String acronym;
}
