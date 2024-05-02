package it.epicode.dao.implementations;

import it.epicode.dao.PersonDao;
import it.epicode.entities.Person;

public class JpaPersonDao extends JpaDao<Person> implements PersonDao {

	public JpaPersonDao() {
		super(Person.class);
	}

}
