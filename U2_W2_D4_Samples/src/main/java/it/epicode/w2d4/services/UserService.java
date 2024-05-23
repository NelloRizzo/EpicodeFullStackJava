package it.epicode.w2d4.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.epicode.w2d4.data.User;

public interface UserService {
	User register(User user);

	Page<User> getUsers(Pageable pageable);

	Optional<User> getUser(Long id);

	User delete(Long id);
}
