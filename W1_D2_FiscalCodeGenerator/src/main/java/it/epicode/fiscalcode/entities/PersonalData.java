package it.epicode.fiscalcode.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
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
public class PersonalData {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Gender gender;
	private String birthCity;
}
