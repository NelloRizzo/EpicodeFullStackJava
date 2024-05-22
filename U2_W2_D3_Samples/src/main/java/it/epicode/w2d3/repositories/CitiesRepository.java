package it.epicode.w2d3.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.w2d3.entities.CityEntity;

public interface CitiesRepository extends PagingAndSortingRepository<CityEntity, Long> {

}
