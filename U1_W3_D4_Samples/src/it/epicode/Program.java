package it.epicode;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Persistence;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static final String PERSISTENCE_UNIT = "JPA_Inheritance";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Recapito> recapiti = new ArrayList<>();

		var email = new Email("nellorizzo@live.it", false);
		var address = new IndirizzoPostale(false, "via del Deposito", "4", "Paperopoli", "00000", "PP");
		recapiti.add(email);
		recapiti.add(address);
		recapiti.add(new SitoWeb(true, "http://www.microsoft.com"));
		recapiti.forEach(System.out::println);

		try (var emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT); //
				var em = emf.createEntityManager()) {
			var t = em.getTransaction();
			t.begin();
			recapiti.forEach(em::persist);
			t.commit();
			
			log.debug("Result List:");
			var q = em.createQuery("SELECT r FROM Recapito r");
			List<Recapito> result = q.getResultList();
			result.forEach(r -> log.debug("{}", r));
			log.debug("Result Stream:");
			q.getResultStream().forEach(r -> log.debug("{}", r));
			log.debug("Con named query:");
			q = em.createNamedQuery("TUTTI_I_RECAPITI");
			q.getResultStream().forEach(r -> log.debug("{}", r));
			
			log.debug("Named query con parametri:");
			q = em.createNamedQuery("RECAPITO_PER_TIPOLOGIA");
			q.setParameter("lavorativo", false);
			q.getResultStream().forEach(r -> log.debug("{}", r));

		} catch (Exception e) {
			log.error("Errore", e);
		}
	}

}
