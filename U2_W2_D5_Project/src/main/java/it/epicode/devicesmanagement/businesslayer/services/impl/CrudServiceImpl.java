package it.epicode.devicesmanagement.businesslayer.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.devicesmanagement.businesslayer.dto.BaseDto;
import it.epicode.devicesmanagement.businesslayer.services.CrudService;
import it.epicode.devicesmanagement.businesslayer.services.Mapper;
import it.epicode.devicesmanagement.datalayer.entities.BaseEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrudServiceImpl<D extends BaseDto, E extends BaseEntity> implements CrudService<D> {

	protected final JpaRepository<E, Long> repository;

	@Autowired
	protected Mapper<D, E> mapper;

	public CrudServiceImpl(JpaRepository<E, Long> repository) {
		this.repository = repository;
	}

	@Override
	public D save(D dto) {
		try {
			return mapper.convert(repository.save(mapper.convert(dto)));
		} catch (Exception e) {
			log.error(String.format("Exception saving entity %s", dto), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public D update(Long id, D dto) {
		try {
			var e = repository.findById(id).orElseThrow();
			mapper.update(e, dto);
			return mapper.convert(repository.save(e));
		} catch (NoSuchElementException e) {
			log.error(String.format("Entity not found for id = %s", id));
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error(String.format("Exception updating entity having id = %s with dto = %s", id, dto), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public D delete(Long id) {
		try {
			var e = repository.findById(id).orElseThrow();
			repository.delete(e);
			return mapper.convert(e);
		} catch (NoSuchElementException e) {
			log.error(String.format("Entity not found for id = %s", id));
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error(String.format("Exception deleting entity having id = %s", id), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<D> get(Long id) {
		try {
			var e = repository.findById(id).orElseThrow();
			return Optional.of(mapper.convert(e));
		} catch (NoSuchElementException e) {
			log.error(String.format("Entity not found for id = %s", id));
			return Optional.empty();
		} catch (Exception e) {
			log.error(String.format("Exception retrieving entity having id = %s", id), e);
			throw new RuntimeException(e);
		}
	}

}
