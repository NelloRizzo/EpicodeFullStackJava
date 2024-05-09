package it.epicode.bw1.transportcompany.dao.factories;

import it.epicode.bw1.transportcompany.dao.FleetDao;
import it.epicode.bw1.transportcompany.dao.ResellerDao;
import it.epicode.bw1.transportcompany.dao.TravelDocumentDao;
import it.epicode.bw1.transportcompany.dao.UserDao;
import it.epicode.bw1.transportcompany.dao.v1.FleetDaoImpl;
import it.epicode.bw1.transportcompany.dao.v1.ResellerDaoImpl;
import it.epicode.bw1.transportcompany.dao.v1.TravelDocumentDaoImpl;
import it.epicode.bw1.transportcompany.dao.v1.UserDaoImpl;

public class DaoFactoryImpl implements DaoFactory {
	@Override
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}

	@Override
	public TravelDocumentDao getTravelDocumentDao() {
		return new TravelDocumentDaoImpl();
	}

	@Override
	public ResellerDao getResellerDao() {
		return new ResellerDaoImpl();
	}

	@Override
	public FleetDao getFleetDao() {
		return new FleetDaoImpl();
	}
}
