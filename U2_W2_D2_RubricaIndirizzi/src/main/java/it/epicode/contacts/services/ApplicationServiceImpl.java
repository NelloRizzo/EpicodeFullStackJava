package it.epicode.contacts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.contacts.entities.User;
import it.epicode.contacts.repositories.UsersRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private UsersRepository users;

	@Override
	public Optional<User> save(User u) {
		return Optional.of(users.save(u));
	}

	@Override
	public List<User> getAll() {
		return users.findAll();
	}

}
