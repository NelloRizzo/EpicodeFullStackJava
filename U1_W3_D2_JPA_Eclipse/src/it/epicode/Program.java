package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.data.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	// il nome del contesto di persistenza è il nome della PERSISTENCE UNIT
	// all'interno del file persistence.xml
	private static final String PERSISTENCE_UNIT = "JPA_Sample";

	public static void main(String[] args) {
		// per creare l'Entity Manager ho bisogno di un elemento di sistema che si
		// occupa di crearlo effettivamente
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		// il factory è in grado di costruire l'Entity Manager
		EntityManager em = emf.createEntityManager();
		try {
			var p = new Persona(1, "Paperon", "De' Paperoni", "44444444");
			log.debug("Ho creato la persona: {}", p);
			// una transasione è una "sessione di lavoro" sul DB
			EntityTransaction trans = em.getTransaction();
			// la transazione va iniziata
			trans.begin();
			log.debug("Salvo la persona con persist()");
			// a questo punto possiamo eseguire tutte le operazioni che vogliamo
			// salvo la persona sul database
			em.persist(p);

			log.debug("Commissiono la transazione sul db");
			// quando abbiamo finito commissiono le modifiche al db
			trans.commit();

			var item = em.find(Persona.class, 1);
			log.debug("Ho recuperato la persona con id=1: {}", item);

			trans.begin();
			item.setCognome("de Paperoni");
			em.persist(item);
			trans.commit();
			
			item = em.find(Persona.class, 1);
			log.debug("Ho recuperato la persona con id=1: {}", item);
			
			trans.begin();
			em.remove(item);
			log.debug("Elimino la persona con id=1");
			trans.commit();
			
			item = em.find(Persona.class, 1);
			if (item == null) {
				log.debug("La persona con id=1 non esiste più");
			} else {
				log.debug("Ho recuperato la persona con id=1: {}", item);
			}
		} catch (Exception e) {
			log.error("Eccezione durante le operazioni", e);
		} finally {
			em.close();
			emf.close();
		}
	}

}
