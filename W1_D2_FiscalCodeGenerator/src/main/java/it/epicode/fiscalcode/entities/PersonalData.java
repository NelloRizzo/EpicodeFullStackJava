package it.epicode.fiscalcode.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 
Dati di input:

- cognome -> String
- nome -> String 
- data di nascita -> LocalDate
- il sesso -> ???? 
- il codice del comune di nascita -> String (per il momento)

 */
@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class PersonalData {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Gender gender;
	private String birthCity;
	private String birthProvince;
}
