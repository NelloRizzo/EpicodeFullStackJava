package it.epicode.blog.datalayer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blog.datalayer.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findOneByUsernameAndPassword(String username, String password);
	Optional<UserEntity> findOneByUsername(String username);
}
