package it.epicode.bms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.bms.entities.BaseEntity;

public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long>{

}
