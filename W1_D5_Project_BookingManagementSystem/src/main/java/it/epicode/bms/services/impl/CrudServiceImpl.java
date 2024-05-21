package it.epicode.bms.services.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.bms.entities.BaseEntity;
import it.epicode.bms.services.CrudService;

public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

	protected final JpaRepository<T, Long> repo;

	protected CrudServiceImpl(JpaRepository<T, Long> repo) {
		this.repo = repo;
	}

	@Override
	public T save(T entity) {
		return repo.save(entity);
	}

	@Override
	public Optional<T> getById(Long id) {
		return repo.findById(id);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

}
