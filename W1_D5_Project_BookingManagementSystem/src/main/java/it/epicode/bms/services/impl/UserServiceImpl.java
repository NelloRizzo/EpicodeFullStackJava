package it.epicode.bms.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.epicode.bms.entities.User;
import it.epicode.bms.repositories.UserRepository;
import it.epicode.bms.services.UserService;

@Service
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

	protected UserServiceImpl(UserRepository repo) {
		super(repo);
	}

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<User> getByEmail(String email) {
		return ((UserRepository)repo).findFirstByEmail(email);
	}

}
