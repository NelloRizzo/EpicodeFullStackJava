package it.epicode.bw1.transportcompany.dao.v1;

import java.util.List;

import it.epicode.bw1.transportcompany.dao.ResellerDao;
import it.epicode.bw1.transportcompany.dao.exceptions.DaoException;
import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.utils.C;

public class ResellerDaoImpl extends DaoImpl<Reseller> implements ResellerDao {

	public ResellerDaoImpl() {
		super(Reseller.class);
	}

	@Override
	public List<Reseller> findAll() {
		try {
			return em.createNamedQuery(C.T.Reseller.Queries.SELECT_ALL, Reseller.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}

}
