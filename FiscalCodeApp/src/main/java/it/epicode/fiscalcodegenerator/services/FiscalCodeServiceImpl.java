package it.epicode.fiscalcodegenerator.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.fiscalcodegenerator.dto.Gender;
import it.epicode.fiscalcodegenerator.dto.PersonalData;
import it.epicode.fiscalcodegenerator.entities.CityEntity;

@Service
public class FiscalCodeServiceImpl implements FiscalCodeService {

	@Autowired
	private CityService cities;

	@Override
	public String calculateFiscalCode(PersonalData data) {
		var fc = new StringBuilder() //
				.append(handleLastName(data.getLastName())) //
				.append(handleFirstName(data.getFirstName())) //
				.append(handleBirthday(data.getBirthday(), data.getGender())) //
				.append(handleBirthCity(data.getBirthCityId()));
		fc.append(calculateCheckCode(fc.toString()));
		return fc.toString();
	}

	private static class ConsonantsVowelsSeparator {
		public final StringBuilder consonants = new StringBuilder();
		public final StringBuilder vowels = new StringBuilder();

		public ConsonantsVowelsSeparator(String text) {
			text.chars() // apre uno stream sui caratteri contenuti nella stringa
					.filter(c -> Character.isAlphabetic(c)) // fa passare solo i caratteri alfabetici
					.mapToObj(c -> (char) Character.toUpperCase(c)) // li mette in maiuscolo
					.forEach(c -> {
						// controlla se si tratta di una vocale
						if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
							vowels.append(c);
						} else { // altrimenti si tratta di una consonante
							consonants.append(c);
						}
					});
		}
	}

	private String handleLastName(String lastName) {
		var cv = new ConsonantsVowelsSeparator(lastName);
		return String.format("%s%sXXX", cv.consonants, cv.vowels).substring(0, 3);
	}

	private String handleFirstName(String firstName) {
		var cv = new ConsonantsVowelsSeparator(firstName);
		if (cv.consonants.length() > 3) {
			cv.consonants.delete(1, 2);
		}
		return String.format("%s%sXXX", cv.consonants, cv.vowels).substring(0, 3);
	}

	private String handleBirthday(LocalDate birthday, Gender gender) {
		String months = "ABCDEHLMPRST"; // tabella dei mesi
		var month = months.charAt(birthday.getMonthValue() - 1);
		int day = birthday.getDayOfMonth() + (gender == Gender.FEMALE ? 40 : 0);
		return String.format("%ty%c%02d", birthday, month, day);
	}

	private String handleBirthCity(long birthCityId) {
		return cities.getCityById(birthCityId).orElse(CityEntity.builder().withCadastral("X000").build())
				.getCadastral();
	}

	private char calculateCheckCode(String fc) {
		int[] odds = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23 };
		var sum = 0;
		for (var i = 0; i < 15; i++) {
			var c = fc.charAt(i);
			var depl = Character.isDigit(c) ? c - '0' : c - 'A';
			sum += (i % 2 == 0) ? odds[depl] : depl;
		}
		return (char) (sum % 26 + 'A');
	}
}
