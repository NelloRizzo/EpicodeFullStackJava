package it.epicode.bms.services;

import java.util.List;

import it.epicode.bms.entities.BaseEntity;

/**
 * Definizione di un servizio per elencare le entità.
 *
 * @param <T> Tipo dell'entità gestita.
 */
public interface ListableService<T extends BaseEntity> {

	/**
	 * @return tutte le entità.
	 */
	List<T> getAll();
}
