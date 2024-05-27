package it.epicode.devicesmanagement.businesslayer.services.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.devicesmanagement.businesslayer.dto.EmployeeDto;
import it.epicode.devicesmanagement.businesslayer.services.Mapper;
import it.epicode.devicesmanagement.datalayer.entities.EmployeeEntity;

@Component
@Scope("singleton")
public class EmployeeMapper implements Mapper<EmployeeDto, EmployeeEntity> {

	@Override
	public EmployeeDto convert(EmployeeEntity entity) {
		return EmployeeDto.builder().withId(entity.getId()).withEmail(entity.getEmail()).withFirstName(entity.getFirstName())
				.withImagePicture(entity.getImagePicture()).withLastName(entity.getLastName())
				.withUsername(entity.getUsername()).build();
	}

	@Override
	public EmployeeEntity convert(EmployeeDto dto) {
		return EmployeeEntity.builder().withEmail(dto.getEmail()).withFirstName(dto.getFirstName())
				.withImagePicture(dto.getImagePicture()).withLastName(dto.getLastName()).withUsername(dto.getUsername())
				.build();
	}

	@Override
	public void update(EmployeeEntity entity, EmployeeDto dto) {
		// Intenzionalmente vuoto
	}

}
