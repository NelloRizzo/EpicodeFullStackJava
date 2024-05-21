package it.epicode.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.contacts.entities.Address;

public interface AddressesRepository extends JpaRepository<Address, Long>{

}
