package it.epicode.w2d3.fines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.w2d3.fines.entities.Fine;

public interface FinesRepository extends //
		JpaRepository<Fine, Long>, //
		PagingAndSortingRepository<Fine, Long> {

}
