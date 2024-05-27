package it.epicode.devicesmanagement.businesslayer.services;

import it.epicode.devicesmanagement.businesslayer.dto.BaseDto;
import it.epicode.devicesmanagement.datalayer.entities.BaseEntity;

public interface Mapper<D extends BaseDto, E extends BaseEntity> {

	D convert(E entity);

	E convert(D dto);
	
	void update(E entity, D dto);
}
