package it.epicode.dao.implementations;

import it.epicode.entities.Event;

public class JpaEventDao extends JpaDao<Event> {

	public JpaEventDao() {
		super(Event.class);
	}

}
