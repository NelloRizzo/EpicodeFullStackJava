package it.epicode.dao.implementations;

import it.epicode.dao.EventDao;
import it.epicode.entities.Event;

public class JpaEventDao extends JpaDao<Event> implements EventDao {

	public JpaEventDao() {
		super(Event.class);
	}

}
