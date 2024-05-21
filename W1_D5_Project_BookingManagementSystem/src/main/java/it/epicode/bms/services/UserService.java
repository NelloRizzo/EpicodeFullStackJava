package it.epicode.bms.services;

import java.util.Optional;

import it.epicode.bms.entities.User;

public interface UserService extends CrudService<User>, ListableService<User> {

	/**
	 * Recupera l'utente tramite email.
	 * 
	 * @param email l'email dell'utente da recuperare.
	 * @return l'utente cercato (o {@code Optional.empty()} se non è stato possibile
	 *         trovare l'utente).
	 */
	Optional<User> getByEmail(String email);
}
