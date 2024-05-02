package it.epicode.dao;

import it.epicode.entities.Passport;
import it.epicode.entities.Person;
import it.epicode.entities.PersonKey;

public interface PersonDao {
	void save(Person p);

	Person getById(PersonKey key);

	Passport getPassport(long id);

}
