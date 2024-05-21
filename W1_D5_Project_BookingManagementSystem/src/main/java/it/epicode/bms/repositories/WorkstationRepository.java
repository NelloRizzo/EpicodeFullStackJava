package it.epicode.bms.repositories;

import java.util.List;
import java.util.Optional;

import it.epicode.bms.entities.Workstation;

public interface WorkstationRepository extends EntityRepository<Workstation> {

	/**
	 * Elenca le postazioni sulla base del tipo e della città.
	 * 
	 * @param type il tipo di postazione richiesta.
	 * @param city la città per la quale effettuare la ricerca (con operatore
	 *             {@code LIKE}).
	 * @return l'elenco delle postazioni richieste.
	 */
	List<Workstation> findAllByTypeAndBuildingCityLike(Workstation.Type type, String city);

	/**
	 * Cerca una postazione a partire dal suo codice.
	 * 
	 * @param code il codice della postazione da cercare.
	 * @return la postazione che corrisponde al codice (o {@code Optional.empty()}
	 *         se non esiste).
	 */
	Optional<Workstation> findOneByCode(String code);
}
