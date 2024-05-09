package it.epicode.bw1.transportcompany.dao.v1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import it.epicode.bw1.transportcompany.dao.FleetDao;
import it.epicode.bw1.transportcompany.dao.exceptions.DaoException;
import it.epicode.bw1.transportcompany.entities.fleet.Mantenance;
import it.epicode.bw1.transportcompany.entities.fleet.Vehicle;
import it.epicode.bw1.transportcompany.entities.utils.C;

public class FleetDaoImpl extends DaoImpl<Vehicle> implements FleetDao {

	public FleetDaoImpl() {
		super(Vehicle.class);
	}

	@Override
	public List<Vehicle> findAll() {
		try {
			return em.createNamedQuery(C.T.Vehicle.Queries.SELECT_ALL, Vehicle.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<Mantenance> getInMantenance() {
		try {
			return em.createNamedQuery(C.T.Mantenance.Queries.SELECT_ALL, Mantenance.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<Mantenance> getInService() {
		try {
			return em.createNamedQuery(C.T.Mantenance.Queries.SELECT_ALL, Mantenance.class).getResultList();
		} catch (Exception e) {
			log.error("Exception in findAll()", e);
			throw new DaoException(e);
		}
	}

	@Override
	public Optional<Vehicle> getVechicleInMantenance(Vehicle v) {
		try {
			return em.createNamedQuery(C.T.Mantenance.Queries.SELECT_MANTENANCE_VEHICLE, Mantenance.class)
					.setParameter("vehicle", v).getResultStream().map(Mantenance::getVehicle).findAny();
		} catch (Exception e) {
			log.error("Exception in getVechicleInMantenance()", e);
			throw new DaoException(e);
		}
	}

	@Override
	public void setInMantenance(Vehicle v) {
		try {
			var t = em.getTransaction();
			t.begin();
			var m = new Mantenance(v, LocalDateTime.now(), null);
			em.persist(m);
			t.commit();
		} catch (Exception e) {
			log.error("Exception when setting in mantenance", e);
			throw new DaoException(e);
		}
	}

	@Override
	public void setInService(Vehicle v) {
		try {
			var m = em.createNamedQuery(C.T.Mantenance.Queries.SELECT_MANTENANCE_VEHICLE, Mantenance.class)
					.setParameter("vehicle", v).getResultStream().findAny().orElseThrow();
			var t = em.getTransaction();
			t.begin();
			m.setEnd(LocalDateTime.now());
			em.persist(m);
			t.commit();
		} catch (Exception e) {
			log.error("Exception when setting in mantenance", e);
			throw new DaoException(e);
		}
	}

}
