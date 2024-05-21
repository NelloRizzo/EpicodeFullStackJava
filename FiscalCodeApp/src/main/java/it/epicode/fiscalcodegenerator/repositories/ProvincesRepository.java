package it.epicode.fiscalcodegenerator.repositories;

import java.util.Optional;

import it.epicode.fiscalcodegenerator.entities.ProvinceEntity;

public interface ProvincesRepository extends BaseRepository<ProvinceEntity> {

	Optional<ProvinceEntity> findOneByAcronym(String acronym);
}
