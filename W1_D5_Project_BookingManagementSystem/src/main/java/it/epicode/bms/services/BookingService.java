package it.epicode.bms.services;

import java.util.List;
import java.util.Optional;

import it.epicode.bms.entities.Booking;
import it.epicode.bms.services.dto.AddBookingDto;

/**
 * Servizio per la gestione delle prenotazioni.
 */
public interface BookingService extends CrudService<Booking> {

	/**
	 * Aggiunge una prenotazione.
	 * 
	 * @param dto i dati per la costruzione della prenotazione.
	 * @return la prenotazione creata (o {@code Optional.empty()} se non è stato
	 *         possibile portare a termine l'operazione).
	 */
	Optional<Booking> addBooking(AddBookingDto dto);

	/**
	 * 
	 * @return l'elenco di tutte le prenotazioni.
	 */
	List<Booking> getAll();

	/**
	 * Recupera tutte le prenotazioni di un utente.
	 * 
	 * @param userEmail l'indirizzo di posta elettronica dell'utente.
	 * @return l'elenco di tutte le prenotazioni dell'utente.
	 */
	List<Booking> getAllByUser(String userEmail);
}
