package it.epicode.fiscalcodegenerator.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class PersonalData {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Gender gender;
	private Long birthCityId;
}
