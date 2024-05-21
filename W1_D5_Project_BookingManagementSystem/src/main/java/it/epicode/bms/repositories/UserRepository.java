package it.epicode.bms.repositories;

import java.util.Optional;

import it.epicode.bms.entities.User;

public interface UserRepository extends EntityRepository<User> {

	/**
	 * Cerca un utente tramite l'email.
	 * 
	 * @param email l'email dell'utente da cercare.
	 * @return l'utente corrispondente all'email (o {@code Optional.empty()} se non
	 *         esiste).
	 */
	Optional<User> findFirstByEmail(String email);
}
