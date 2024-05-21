package it.epicode.fiscalcodegenerator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.fiscalcodegenerator.entities.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>, PagingAndSortingRepository<T, Long>{

}
