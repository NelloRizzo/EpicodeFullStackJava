package it.epicode.dao;

import java.util.Optional;

import it.epicode.entities.Event;

/**
 * Interfaccia di definizione del DAO.
 *
 */
public interface EventDao extends AutoCloseable {
	/**
	 * Salva un evento.
	 * 
	 * @param e l'evento da salvare.
	 */
	void save(Event e);

	/**
	 * Recupera un evento attraverso la chiave.
	 * 
	 * @param id chiave dell'evento da recuperare.
	 * @return l'evento richiesto, se trovato, oppure un {@code Optional} vuoto.
	 */
	Optional<Event> getById(long id);

	/**
	 * Elimina un evento.
	 * 
	 * @param e l'evento da eliminare.
	 */
	void delete(Event e);
}
