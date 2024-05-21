package it.epicode.contacts.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.contacts.entities.Address;
import it.epicode.contacts.entities.User;
import it.epicode.contacts.repositories.AddressesRepository;
import it.epicode.contacts.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private UsersRepository users;

	@Autowired
	private AddressesRepository addresses;

	@Override
	public Optional<User> save(User u) {
		try {
			return Optional.of(users.save(u));
		} catch (Exception e) {
			log.error(String.format("Exception saving user %s", u), e);
			return Optional.empty();
		}
	}

	@Override
	public List<User> getAll() {
		return users.findAll();
	}

	@Override
	public Optional<Address> addAddress(long userId, Address a) {
		try {
			var user = users.findById(userId).orElseThrow();
			a.setOwner(user);
			addresses.save(a);
			return Optional.of(a);
		} catch (NoSuchElementException e) {
			log.error(String.format("User with id = %s not found", userId), e);
		} catch (Exception e) {
			log.error(String.format("Exception adding address to user with id = %s", userId), e);
		}
		return Optional.empty();
	}

}
