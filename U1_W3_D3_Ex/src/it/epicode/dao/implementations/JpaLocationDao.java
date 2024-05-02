package it.epicode.dao.implementations;

import it.epicode.entities.Location;

public class JpaLocationDao extends JpaDao<Location> {

	public JpaLocationDao() {
		super(Location.class);
	}

}
