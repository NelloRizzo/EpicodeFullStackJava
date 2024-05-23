package it.epicode.w2d4.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.w2d4.data.User;

public interface UsersRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

	Optional<User> findOneByEmail(String email);
}
