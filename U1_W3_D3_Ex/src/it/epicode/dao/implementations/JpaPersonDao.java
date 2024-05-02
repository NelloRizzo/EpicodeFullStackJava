package it.epicode.dao.implementations;

import it.epicode.entities.Person;

public class JpaPersonDao extends JpaDao<Person> {

	public JpaPersonDao() {
		super(Person.class);
	}

}
