package it.epicode.bw1.transportcompany.dao.v1;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.bw1.transportcompany.dao.Dao;
import it.epicode.bw1.transportcompany.dao.exceptions.PersistException;
import it.epicode.bw1.transportcompany.entities.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DaoImpl<T extends BaseEntity> implements Dao<T> {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	private static final String PERSISTENCE_UNIT = "TransportCompany";

	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	protected final EntityManager em = emf.createEntityManager();

	protected final Class<? extends T> type;

	public DaoImpl(Class<? extends T> type) {
		this.type = type;
	}

	@Override
	public T save(T entity) {
		try {
			var t = em.getTransaction();
			t.begin();
			em.persist(entity);
			t.commit();
			log.debug("Saved {}", entity);
			return entity;
		} catch (Exception e) {
			log.error("Exception in save()", e);
			throw new PersistException(e);
		}
	}

	@Override
	public void close() throws Exception {
		em.close();
		emf.close();
	}

	@Override
	public Optional<T> find(long id) {
		try {
			var entity = em.find(type, id);
			if (entity != null)
				return Optional.of(entity);
		} catch (Exception e) {
			log.error(String.format("Exception finding entity by id = %s", id), e);
		}
		return Optional.empty();
	}

	@Override
	public void save(List<T> entities) {
		try {
			var t = em.getTransaction();
			t.begin();
			entities.stream().forEach(em::persist);
			t.commit();
		} catch (Exception e) {
			log.error("Exception in save()", e);
			throw new PersistException(e);
		}
	}
}
