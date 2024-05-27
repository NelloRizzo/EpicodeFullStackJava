package it.epicode.devicesmanagement.businesslayer.services.impl;

import org.springframework.stereotype.Service;

import it.epicode.devicesmanagement.businesslayer.dto.EmployeeDto;
import it.epicode.devicesmanagement.businesslayer.services.EmployeeService;
import it.epicode.devicesmanagement.datalayer.entities.EmployeeEntity;
import it.epicode.devicesmanagement.datalayer.repositories.EmployeesRepository;

@Service
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeDto, EmployeeEntity> implements EmployeeService {

	public EmployeeServiceImpl(EmployeesRepository repository) {
		super(repository);
	}
}
