package it.epicode.dao.implementations;

import it.epicode.dao.LocationDao;
import it.epicode.entities.Location;

public class JpaLocationDao extends JpaDao<Location> implements LocationDao{

	public JpaLocationDao() {
		super(Location.class);
	}

}
