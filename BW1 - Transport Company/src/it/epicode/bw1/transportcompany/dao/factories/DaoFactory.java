package it.epicode.bw1.transportcompany.dao.factories;

import it.epicode.bw1.transportcompany.dao.FleetDao;
import it.epicode.bw1.transportcompany.dao.ResellerDao;
import it.epicode.bw1.transportcompany.dao.TravelDocumentDao;
import it.epicode.bw1.transportcompany.dao.UserDao;

public interface DaoFactory {
	UserDao getUserDao();

	TravelDocumentDao getTravelDocumentDao();

	ResellerDao getResellerDao();
	
	FleetDao getFleetDao();
}
