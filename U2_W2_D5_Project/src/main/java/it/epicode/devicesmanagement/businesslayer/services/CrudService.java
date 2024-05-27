package it.epicode.devicesmanagement.businesslayer.services;

import java.util.Optional;

import it.epicode.devicesmanagement.businesslayer.dto.BaseDto;

public interface CrudService<D extends BaseDto> {

	D save(D dto);
	D update(Long id, D dto);
	D delete(Long id);
	Optional<D> get(Long id);
}
