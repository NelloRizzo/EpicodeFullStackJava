package it.epicode.bms.services;

import java.util.Optional;

import it.epicode.bms.entities.BaseEntity;

/**
 * Generica interfaccia per la definizione dei metodi CRUD comuni a tutte le
 * entità.
 *
 * @param <T> tipo dell'entità gestita.
 */
public interface CrudService<T extends BaseEntity> {
	/**
	 * Valida e salva un'entità.
	 * 
	 * @param entity l'entità da gestire.
	 * @return L'entità salvata (o {@code Optional.empty()} se non è stato possibile
	 *         portare a termine l'operazione).
	 */
	T save(T entity);

	/**
	 * Recupera un'entità tramite la chiave.
	 * 
	 * @param id la chiave dell'entità da recuperare.
	 * @return L'entità corrispondente alla chiave (o {@code Optional.empty()} se
	 *         non è stato possibile portare a termine l'operazione).
	 */
	Optional<T> getById(Long id);

	/**
	 * Elimina tramite la chiave.
	 * 
	 * @param id la chiave dell'elemento da eliminare.
	 */
	void delete(Long id);

	/**
	 * Elimina tutte le entità.
	 */
	void deleteAll();
}
