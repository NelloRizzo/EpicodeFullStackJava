package it.epicode.bw1.transportcompany.dao.v1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import it.epicode.bw1.transportcompany.dao.TravelDocumentDao;
import it.epicode.bw1.transportcompany.dao.exceptions.DaoException;
import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.tickets.Subscription;
import it.epicode.bw1.transportcompany.entities.tickets.TravelDocument;
import it.epicode.bw1.transportcompany.entities.users.User;
import it.epicode.bw1.transportcompany.entities.utils.C;

public class TravelDocumentDaoImpl extends DaoImpl<TravelDocument> implements TravelDocumentDao {

	public TravelDocumentDaoImpl() {
		super(TravelDocument.class);
	}

	@Override
	public Optional<Subscription> getFirstSubscription() {
		try {
			return em.createNamedQuery(C.T.Subscription.Queries.SELECT_ALL, Subscription.class).getResultStream()
					.findAny();
		} catch (Exception e) {
			log.error("Exception getting first subscription", e);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Subscription> addSubscription(User user, Subscription subscription) {
		try {
			var trans = em.getTransaction();
			trans.begin();
			subscription.setOwner(user);
			em.persist(subscription);
			trans.commit();
			return Optional.of(subscription);
		} catch (DaoException e) {
			log.error("Dao exception adding subscription", e);
			throw e;
		} catch (Exception e) {
			log.error("Exception adding subscription", e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<TravelDocument> getDocumentsByPeriod(LocalDateTime from, LocalDateTime to) {
		try {
			return em.createNamedQuery(C.T.TravelDocument.Queries.DOCUMENTS_BY_PERIOD, TravelDocument.class)
					.setParameter("from", from).setParameter("to", to).getResultList();
		} catch (Exception e) {
			log.error("Error getting documents", e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<TravelDocument> getDocumentsByPeriodAndReseller(LocalDateTime from, LocalDateTime to, Reseller r) {
		try {
			return em
					.createNamedQuery(C.T.TravelDocument.Queries.DOCUMENTS_BY_PERIOD_AND_RESELLER, TravelDocument.class)
					.setParameter("from", from).setParameter("to", to).setParameter("reseller", r).getResultList();
		} catch (Exception e) {
			log.error("Error getting documents", e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<TravelDocument> findAll() {
		try {
			return em.createNamedQuery(C.T.TravelDocument.Queries.SELECT_ALL, TravelDocument.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}
}
