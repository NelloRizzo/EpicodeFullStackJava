package it.epicode.contacts.services;

import java.util.List;
import java.util.Optional;

import it.epicode.contacts.entities.Address;
import it.epicode.contacts.entities.User;

public interface ApplicationService {

	Optional<User> save(User u);

	List<User> getAll();

	Optional<Address> addAddress(long userId, Address a);
	
}
