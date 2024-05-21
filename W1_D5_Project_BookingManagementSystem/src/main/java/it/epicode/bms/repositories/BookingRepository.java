package it.epicode.bms.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import it.epicode.bms.entities.Booking;

public interface BookingRepository extends EntityRepository<Booking> {

	/**
	 * Ricerca le prenotazioni di un utente tramite il suo indirizzo di posta
	 * elettronica.
	 * 
	 * @param email l'indirizzo di posta elettronica.
	 * @return le prenotazioni dell'utente.
	 */
	public List<Booking> findAllByUserEmail(String email);

	/**
	 * Cerca una prenotazione per un utente in una data.
	 * 
	 * @param email l'indirizzo di posta elettronica dell'utente.
	 * @param date  la data per cui effettuare la ricerca.
	 * @return la prenotazione relativa all'utente (o {@code Optional.empty()} se
	 *         non esiste alcuna prenotazione).
	 */
	public Optional<Booking> findFirstByUserEmailAndDate(String email, LocalDate date);

	/**
	 * Cerca una prenotazione per una postazione in una data.
	 * 
	 * @param id   la chiave della postazione.
	 * @param date la data in cui cercare.
	 * @return la prenotazione cercata (o {@code Optional.empty()} se non esiste
	 *         alcuna prenotazione).
	 */
	public Optional<Booking> findFirstByWorkstationIdAndDate(Long id, LocalDate date);
}
