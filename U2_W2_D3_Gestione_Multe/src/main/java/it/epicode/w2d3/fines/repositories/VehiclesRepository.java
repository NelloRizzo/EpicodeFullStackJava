package it.epicode.w2d3.fines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.w2d3.fines.entities.Vehicle;

public interface VehiclesRepository extends //
		JpaRepository<Vehicle, Long>, //
		PagingAndSortingRepository<Vehicle, Long> {

}
