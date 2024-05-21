package it.epicode.fiscalcodegenerator.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import it.epicode.fiscalcodegenerator.entities.CityEntity;

public interface CitiesRepository extends BaseRepository<CityEntity> {

	List<CityEntity> findAllByProvinceAcronymIgnoreCase(String acronym);

	Page<CityEntity> findAllByProvinceAcronymIgnoreCase(String acronym, Pageable pageable);

	Page<CityEntity> findAllByNameLike(String name, Pageable pageable);

	Optional<CityEntity> findOneByNameAndProvinceAcronym(String name, String acronym);

	@Query("SELECT COUNT(c) FROM CityEntity c")
	Long countCities();
}
