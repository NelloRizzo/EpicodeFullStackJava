package it.epicode.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.contacts.entities.User;

public interface UsersRepository extends JpaRepository<User, Long>{

}
