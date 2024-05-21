package it.epicode.bms.services;

import java.util.Optional;

import it.epicode.bms.entities.Workstation;

public interface WorkstationService extends CrudService<Workstation>, ListableService<Workstation> {

	/**
	 * Cerca una postazione tramite il codice.
	 * 
	 * @param code il codice della postazione da cercare.
	 * @return la postazione corrispondente (o {@code Optional.empty()} se non è
	 *         stato possibile portare a termine l'operazione).
	 */
	Optional<Workstation> getByCode(String code);
}
