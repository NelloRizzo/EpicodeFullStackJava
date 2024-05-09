package it.epicode.bw1.transportcompany.dao;

import java.util.List;
import java.util.Optional;

import it.epicode.bw1.transportcompany.entities.BaseEntity;

public interface Dao<T extends BaseEntity> extends AutoCloseable {
	T save(T entity);

	void save(List<T> entities);

	Optional<T> find(long id);
	
	List<T> findAll();
}
