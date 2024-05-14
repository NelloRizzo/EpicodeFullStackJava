package it.epicode.fiscalcode.services;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import it.epicode.fiscalcode.entities.Gender;
import it.epicode.fiscalcode.entities.PersonalData;

@Component
public class FiscalCodeServiceImpl implements FiscalCodeService {

//	 * è composto dai seguenti blocchi:
//	 * 
//	 * - 3 lettere per il cognome 
//	 * - 3 lettere per il nome 
//	 * - l'anno di nascita (numero) 
//	 * - il mese della data di nascita (lettera) 
//	 * - il giorno della data di nascita (numero) 
//	 * - il codice del comune di nascita 
//	 * - il carattere di controllo
	@Override
	public String generateFiscalCode(PersonalData data) {
		String fc = handleLastName(data.getLastName()) + //
				handleFirstName(data.getFirstName()) + //
				handleBirthday(data.getBirthday(), data.getGender()) + //
				handleBirthCity(data.getBirthCity());
		fc = fc + calculateCheckCode(fc);
		return fc;
	}

	// Cognome
	// Sono necessari come detto prima 3 caratteri per rappresentare il cognome,
	// e sono la prima la seconda e la terza consonante del cognome.
	// E' possibile che le consonanti siano meno di tre, in questo caso è possibile
	// aggiungere le vocali nell'ordine in cui compaiono nel cognome.
	// Per cognomi più corti di 3 caratteri, è possibile sostituire il carattere
	// mancante con la lettera X.
	// Chiaramente se ci sono cognomi con più parti, è necessario rimuovere gli
	// spazi e considerare tutto come un cognome unico.
	private String handleLastName(String lastName) {
		var cv = new ConsonantsVowelsSeparator(lastName);
		return (cv.getConsonants() + cv.getVowels() + "XXX") // creo uno stringone con consonanti + vocali + X
				.substring(0, 3); // e di questo prendo solo i primi 3 caratteri
	}

	// Per il nome il discorso è analogo con la particolarità che se il nome
	// è composto da 4 o più consonanti vengono prese nell'ordine la prima,
	// la terza e la quarta.
	// Anche qui potremmo trovarci nella situazione di un numero di consonanti
	// minore
	// di 3 e allo stesso modo si aggiungo le vocali.
	// Ripetiamo anche qui che se il nome è più corto di 3 lettere è possibile
	// sostituire i caratteri mancanti con delle X.
	// Se il nome fosse composto da più nomi, bisogna considerarlo tutto assieme.
	private String handleFirstName(String firstName) {
		var cv = new ConsonantsVowelsSeparator(firstName);
		var cons = cv.getConsonants();
		if (cons.length() > 3) // se le consonanti sono più di 3
			// devo scartare la seconda
			cons = cons.substring(0, 1) + cons.substring(2);
		return (cons + cv.getVowels() + "XXX").substring(0, 3);
	}

	// Anno di nascita
	// Per l'anno vengono prese semplicemente le ultime due cifre.
	// Mese
	// Per quanto riguarda il mese c'è una tabella di conversione che riportiamo
	// qui di seguito. Ad ogni mese corrisponde una lettera dell'alfabeto:
	// ABCDEHLMPRST
	// Giorno
	// In questo caso è sufficiente riportare il numero del giorno,
	// con il particolare che per le donne questo numero dev'essere aumentato di 40!
	private String handleBirthday(LocalDate birthday, Gender gender) {
		String months = "ABCDEHLMPRST"; // tabella dei mesi
		// prendo il valore del mese corrispondente a quello della nascita
		var month = months.charAt(birthday.getMonthValue() - 1);
		// prendo il giorno di nascita, aggiungo 40 se il sesso è DONNA
		int day = birthday.getDayOfMonth() + (gender == Gender.FEMALE ? 40 : 0);
		// %ty interpreta il primo parametro (birthday) come un anno a 2 cifre
		// %c indica che il secondo parametro è un carattere
		// %02d indica che il terzo parametro è un intero che occuperà 2 posizioni
		// nel caso in cui sia < 10 prima dovrà essere posto uno 0
		return String.format("%ty%c%02d", birthday, month, day);
	}

	// E' composto da quattro caratteri alfanumerici.
	// E' il codice del comune rilevati dai volumi dei codici dei comuni italiani.
	// Ci sono database che contengono tutti i comuni d'italia con relativi codici.
	private String handleBirthCity(String birthCity) {
		return birthCity.toUpperCase().substring(0, 4);
	}

	// Si comincia con il prendere i caratteri del codice fiscale fin qui calcolato
	// che sono 15, si prendono quelli in posizione pari e si convertono con i
	// numeri corrispondenti della prima tabella. Tutti questi numeri vengono
	// sommati.
	// Allo stesso modo con i caratteri dispari che devono essere convertiti però
	// utilizzando la seconda tabella e vengono tutti sommati.
	// I valori ottenuti vengono a loro volta sommati e il totale viene diviso per
	// 26.
	// Il resto della divisione dev'essere convertito usando l'ultima tabella.
	// Il carattere corrispondente è il codice di controllo!
	private char calculateCheckCode(String fc) {
		// tabella dei caratteri di posizione dispari
		int[] odds = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23 };
		// accumulatore per la somma
		var sum = 0;
		for (var i = 0; i < 15; i++) {
			// prendo il carattere nella posizione i-esima
			var c = fc.charAt(i);
			// trovo la posizione del carattere nella propria famiglia
			// se c è una cifra c - '0' rappresenta il valore della cifra come numero
			// se c è una lettera c - 'A' rappresenta la posizione del carattere
			// nell'alfabeto
			var depl = Character.isDigit(c) ? c - '0' : c - 'A';
			sum += (i % 2 == 0) ? odds[depl] : depl;
		}
		// prendo la somma calcolo il risultao della divisione per 26 e lo trasformo in lettera
		return (char) (sum % 26 + 'A');
	}
}
