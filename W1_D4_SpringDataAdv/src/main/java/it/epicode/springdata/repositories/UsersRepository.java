package it.epicode.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.springdata.data.User;

public interface UsersRepository extends JpaRepository<User, Long>{
}
